/**
 * This file is a part of the felix-api GitHub project.
 *
 * felix-api is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * felix-api is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with felix-api. If not, see <https://www.gnu.org/licenses/>.
 */

package fr.nkosmos.felix.api.common.request;

import java.net.MalformedURLException;
import java.net.URL;

import lombok.Data;

import static fr.nkosmos.felix.api.common.request.Method.*;

/**
 * Class defining how a request to an endpoint should be handled with which arguments.<br>
 * 
 * Heavily inspired by <a href="https://github.com/DV8FromTheWorld/JDA/blob/v3.8.3/src/main/java/net/dv8tion/jda/core/requests/Route.java">DV8FromTheWorld/JDA</a>
 * 
 * @author xTrM_
 */
@Data
public class Route {

	public static class Defaults {
		
		public static class Self {
			
			
			
		}
		
		public static class User {
			
			public static final Route GET_USER = new Route(GET, "users/%s");
	        
		}
		
		public static class Stream {
			
			
			
		}
		
		public static class Marketplace {
			
			
			
		}
		
		public static class Statistics {
			
			
			
		}
		
	}
	
	/** The request method */
	private final Method method;
	/** The endpoint */
	private final String endpoint;
	/** The parameter count */
	private final int paramCount = getParamCount();
	
	public CompiledRoute compile(String... args) {
		if(args.length != paramCount) {
			throw new IllegalArgumentException("Route cannot be compiled with " + (args.length < paramCount ? "less" : "more") + " than " + paramCount + " arguments!");
		}
		
		String endpoint = String.format(this.endpoint, (Object[])args);
		return new CompiledRoute(this, endpoint);
	}
	
	private int getParamCount() {
		int paramCount = 0;
		int count2 = 0;
		
		for(int i = 0; i < endpoint.length(); i++) {
			if(endpoint.charAt(i) == '{') {
				paramCount++;
			}
			if(endpoint.charAt(i) == '}') {
				count2++;
			}
		}
		
		if(paramCount != count2) {
			throw new IllegalArgumentException("An argument does not have both {}'s for route: " + toString());
		}
		
		return paramCount;
	}
	
	/**
	 * The compiled version of a {@link Route}, meaning it contains the required "argument-full" endpoint
	 * 
	 * @author xTrM_
	 */
	@Data
	public static class CompiledRoute {
		private final Route baseRoute;
		private final String endpoint;
		
		public URL getURL(URL base) throws MalformedURLException {
			return new URL(base, this.endpoint);
		}
	}
}
