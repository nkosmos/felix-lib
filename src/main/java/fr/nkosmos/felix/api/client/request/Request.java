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

package fr.nkosmos.felix.api.client.request;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Base interface for an API Request<br>
 * <br>
 * This provides a {@link #queue() queue} method for appending a {@link Consumer} to a response, or a {@link #complete() complete} method for blocking the thread until the request is done. 
 * 
 * @author xTrM_
 */
public interface Request<T> {

	/**
	 * Queues this request without any callback
	 */
	default void queue() {
		queue(null, null);
	}
	
	/**
	 * Queues this request
	 * @param success
	 * 		the {@link Consumer} called on success
	 */
	default void queue(Consumer<T> success) {
		queue(success, null);
	}
	
	/**
	 * Queues this request
	 * @param success
	 * 		the {@link Consumer} called on success
	 * @param error
	 * 		the {@link Consumer} called on error
	 */
	void queue(Consumer<T> success, Consumer<Throwable> error);
	
	/**
	 * Queues this request
	 * @param callback
	 * 		the {@link BiConsumer} called on success/error
	 */
	default void queue(BiConsumer<T, Throwable> callback) {
		queue(resp -> callback.accept(resp, null), err -> callback.accept(null, err));
	}
	
	/**
	 * Queues this request after a certain delay without any callback
	 * @param delay
	 * 		the delay the {@link TimeUnit} should wait
	 * @param unit
	 * 		the time unit
	 */
	default void queueAfter(int delay, TimeUnit unit) {
		queueAfter(delay, unit, null, null);
	}
	
	/**
	 * Queues this request after a certain delay
	 * @param delay
	 * 		the delay the {@link TimeUnit} should wait
	 * @param unit
	 * 		the time unit
	 * @param success
	 * 		the {@link Consumer} called on success
	 */
	default void queueAfter(int delay, TimeUnit unit, Consumer<T> success) {
		queueAfter(delay, unit, success, null);
	}

	/**
	 * Queues this request after a certain delay
	 * @param delay
	 * 		the delay the {@link TimeUnit} should wait
	 * @param unit
	 * 		the time unit
	 * @param success
	 * 		the {@link Consumer} called on success
	 * @param error
	 * 		the {@link Consumer} called on error
	 */
	void queueAfter(int delay, TimeUnit unit, Consumer<T> success, Consumer<Throwable> error);
	
	/**
	 * Blocks the current {@link Thread} until it receives the server's response
	 * @return the response object
	 */
	T complete();
	
	/**
	 * Blocks the current Thread for the specified delay and calls {@link #complete()} when delay has been reached.
	 * @param delay
	 * 		the delay the {@link TimeUnit} should wait
	 * @param unit
	 * 		the time unit
	 * @return the response object
	 */
	default T completeAfter(int delay, TimeUnit unit) {
		try {
			unit.sleep(delay);
		} catch(InterruptedException e) {
			throw new RuntimeException(e);
		}
		return complete();
	}
	
	/**
	 * @return this request's headers map
	 */
	Map<String, Object> headers();
	
	/**
	 * Adds a header to this request
	 * @param key
	 * 		the header's key
	 * @param value
	 * 		the header's value
	 * @return this request's instance (used for chaining)
	 */
	Request<T> addHeader(String key, Object value);
	
}
