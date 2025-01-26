package com.rk.ordermanagement.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum SuccessCodes {

    SUCCESS_RESPONSE("OMS_200", HttpStatus.OK);


    String code;

    HttpStatus httpStatus;


}
