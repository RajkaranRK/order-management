package com.rk.ordermanagement.exception.handler;


import com.rk.ordermanagement.exception.ErrorCodeDetails;
import com.rk.ordermanagement.exception.IErrorCodeUtils;
import com.rk.ordermanagement.exception.RestServiceException;
import com.rk.ordermanagement.pojo.BaseRestResponse;
import com.rk.ordermanagement.utils.Translator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

/**
 * @author Rajkaran
 *
 * This class will be used for handling all exceptions & returning well-formatted response
 */
@Slf4j
@ControllerAdvice
@AllArgsConstructor
public class RestExceptionHandler {

    /**
     * The constant ERROR_SUFFIX.
     */
    public static final String ERROR_SUFFIX = ".ERROR";

    /**
     * The Translator.
     */
    private Translator translator;


    private IErrorCodeUtils errorCodeUtils;

    /**
     * Used to create BaseRestResponse
     *
     * @param errorCode Error Code
     * @param message Error Message
     * @param response Response
     * @return
     */
    public static BaseRestResponse setBaseRestResponse(String errorCode, String message, BaseRestResponse response) {
        if(response == null) {
            response = new BaseRestResponse();
        }
        response.setSuccess(false);
        response.setCode(errorCode);
        response.setMsg(message);
        return response;
    }

    /**
     * Catch RestServiceException and return appropriate BaseRestResponse
     *
     * @param e Exception
     * @return response
     */
    @ExceptionHandler(RestServiceException.class)
    @ResponseBody
    public ResponseEntity<Object> handleRestServiceException(RestServiceException e) {
        String code = e.getMessage();
        ErrorCodeDetails errorCodeDetails = errorCodeUtils.getErrorCodeDetail(code);
        String msg = this.translator.getMessage(code + ERROR_SUFFIX, e.getArgs());
        log.error("Rest Service Exception with code: {} and message: {}", e.getMessage(), msg);
        BaseRestResponse baseResponse =  setBaseRestResponse(e.getMessage(), msg, e.getResponse());
        return new ResponseEntity<>(baseResponse, Objects.isNull(errorCodeDetails) ? HttpStatus.INTERNAL_SERVER_ERROR : errorCodeDetails.getHttpStatus());
    }

}
