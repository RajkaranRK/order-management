package com.rk.ordermanagement.exception;


import com.rk.ordermanagement.pojo.BaseRestResponse;
import lombok.Getter;

/**
 * @author Rajkaran
 */
@Getter
public class RestServiceException extends RuntimeException {
    private static final long serialVersionUID = -6058067821158675893L;

    private Object[] args;

    private BaseRestResponse response;

    /**
     *
     * @param code Error Code
     * @param args Error Arguments
     */
    public RestServiceException(String code, Object... args) {
        super(code);
        this.args = args;
    }

    /**
     *
     * @param code Error Code
     * @param response Error Response
     * @param args Error Arguments
     */
    public RestServiceException(String code, BaseRestResponse response, Object... args) {
        super(code);
        this.response = response;
        this.args = args;
    }

    /**
     *
     * @param code Error Code
     */
    public RestServiceException(String code) {
        super(code);
    }
}
