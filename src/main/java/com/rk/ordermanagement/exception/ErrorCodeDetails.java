package com.rk.ordermanagement.exception;

import org.springframework.http.HttpStatus;

/**
 * The interface Error code details.
 *
 * @author: Rajkaran
 * @use:
 */
public interface ErrorCodeDetails {

    /**
     * Gets code.
     *
     * @return the code
     */
    String getCode();

    /**
     * Gets http status.
     *
     * @return the http status
     */
    HttpStatus getHttpStatus();
}
