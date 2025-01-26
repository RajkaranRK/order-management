package com.rk.ordermanagement.enums;

import com.rk.ordermanagement.exception.ErrorCodeDetails;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCodes implements ErrorCodeDetails {

    INTERNAL_SERVER_ERROR("OMS_500", HttpStatus.INTERNAL_SERVER_ERROR),
    NOT_FOUND("OMS_404", HttpStatus.OK);

    private final String code;

    private HttpStatus httpStatus;

    ErrorCodes(String code,HttpStatus httpStatus) {
        this.code = code;
        this.httpStatus = httpStatus;
    }

    /**
     * Gets error code.
     *
     * @param code the code
     * @return the error code
     */
    public static ErrorCodeDetails getErrorCode(String code) {
        for (ErrorCodes errorCode : ErrorCodes.values()) {
            if (errorCode.getCode().equals(code)) {
                return errorCode;
            }
        }
        return null;
    }
}
