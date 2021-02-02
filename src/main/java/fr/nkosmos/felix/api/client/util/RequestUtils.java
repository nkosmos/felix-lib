package fr.nkosmos.felix.api.client.util;

import com.github.natanbc.reliqua.request.RequestContext;
import com.github.natanbc.reliqua.request.RequestException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.nkosmos.felix.api.common.exceptions.FelixException;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

/**
 * See <a href="https://github.com/Nekos-life/Nekos4J/blob/master/src/main/java/pw/aru/api/nekos4j/util/RequestUtils.java">Nekos-life/Nekos4J</a>
 */
@SuppressWarnings("unchecked")
public class RequestUtils {
    
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static InputStream getInputStream(Response response) {
        ResponseBody body = response.body();
        if (body == null) throw new IllegalStateException("Body should never be null");
        String encoding = response.header("Content-Encoding");
        if (encoding != null) {
            switch (encoding.toLowerCase()) {
                case "gzip":
                    try {
                        return new GZIPInputStream(body.byteStream());
                    } catch (IOException e) {
                        throw new IllegalStateException("Received Content-Encoding header of gzip, but data is not valid gzip", e);
                    }
                case "deflate":
                    return new InflaterInputStream(body.byteStream());
                default:
                    return body.byteStream();
            }
        }
        return body.byteStream();
    }
    
    public static <T> void handleError(RequestContext<T> context) {
        Response response = context.getResponse();
        ResponseBody body = response.body();
        if (body == null) {
            context.getErrorConsumer().accept(new RequestException("Unexpected status code " + response.code() + " (No body)", context.getCallStack()));
            return;
        }
        Map<String, Object> jsonData = new HashMap<>(toJson(response, Map.class));
        handleErrorCode(jsonData, context);
    }

    public static <T> void handleErrorCode(Map<String, Object> json, RequestContext<T> context) {
        Response response = context.getResponse();
        switch (response.code()) {
            case 403:
                fr.nkosmos.felix.api.common.entities.error.Error error = toJson(response, fr.nkosmos.felix.api.common.entities.error.Error.class);
                try {
                    Class<? extends FelixException> exceptionClass = (Class<? extends FelixException>) Class.forName(error.getErrorClass());
                    FelixException exception = exceptionClass.getConstructor(String.class).newInstance(error.getErrorName() + "->" + error.getErrorMessage());
                    context.getErrorConsumer().accept(exception);
                } catch (ReflectiveOperationException e) {
                    e.printStackTrace();
                }
                break;
            case 404:
                context.getSuccessConsumer().accept(null);
                break;
            default:
                if (!json.isEmpty()) {
                    context.getErrorConsumer().accept(new RequestException("Unexpected status code " + response.code() + ": " + json.get("message"), context.getCallStack()));
                } else {
                    context.getErrorConsumer().accept(new RequestException("Unexpected status code " + response.code(), context.getCallStack()));
                }
        }
    }
    
    public static <T> T toJson(Response resp, Class<T> clazz){
        return GSON.fromJson(new InputStreamReader(getInputStream(resp)), clazz);
    }
}