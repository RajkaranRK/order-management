package com.rk.ordermanagement.exception.handler;

import com.rk.ordermanagement.enums.ErrorCodes;
import com.rk.ordermanagement.exception.ErrorCodeDetails;
import com.rk.ordermanagement.exception.IErrorCodeUtils;
import org.springframework.stereotype.Service;

/**
 * The type Error code utils.
 *
 * @author: Rajkaran
 * @use:
 */
@Service
public class ErrorCodeUtils implements IErrorCodeUtils {

    /**
     * Gets error code detail.
     *
     * @param code the code
     * @return the error code detail
     */
    @Override
    public ErrorCodeDetails getErrorCodeDetail(String code) {
        return ErrorCodes.getErrorCode(code);
    }
}