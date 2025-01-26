package com.rk.ordermanagement.utils;


import com.rk.ordermanagement.constants.AppConstants;
import com.rk.ordermanagement.enums.SuccessCodes;
import com.rk.ordermanagement.pojo.BaseRestResponse;
import io.micrometer.common.util.StringUtils;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Base utility class.
 * 
 * @author amit.khurana
 *
 */
@Component
@AllArgsConstructor
@Slf4j
public class AppUtils {

	private static Translator translator;

	private Translator translatorInstance;

	@PostConstruct
	private void init() {
		translator = this.translatorInstance;
	}

	/**
	 * @param response
	 */
	public static void setSuccessResponse(BaseRestResponse response) {
		response.setSuccess(true);
		response.setCode(SuccessCodes.SUCCESS_RESPONSE.getCode());
		response.setMsg(translator.getMessage(SuccessCodes.SUCCESS_RESPONSE.getCode() + AppConstants.SUCCESS_POSTFIX, null));

	}



	/**
	 *
	 * @use: method to populate the message in case it's not present
	 * @param response
	 */
	public static void populateMessage(BaseRestResponse response) {
		if(StringUtils.isBlank(response.getMsg())){
			if(response.isSuccess()){
				response.setMsg(translator.getMessage(response.getCode() + AppConstants.SUCCESS_POSTFIX, null));
			}else{
				response.setMsg(translator.getMessage(response.getCode() + AppConstants.ERROR_POSTFIX, null));
			}
		}
	}

	/**
	 *
	 * @use: set failure response
	 * @param response
	 */
	public static void setFailureResponse(BaseRestResponse response,SuccessCodes code) {
		response.setSuccess(false);
		response.setCode(code.getCode());
		response.setMsg(translator.getMessage(code.getCode() + AppConstants.ERROR_POSTFIX, null));
	}

}
