package com.rk.ordermanagement.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * Used to convert error code to error message using i18n
 *
 * @author Rajkaran
 */
@Slf4j
@Component
public class Translator {

    private ResourceBundleMessageSource messageSource;

    /**
     * Constructor
     *
     * @param messageSource Message Source
     */
    @Autowired
    public Translator(ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     *
     * @param msgCode Message Code
     * @param args Arguments
     * @return
     */
    public String getMessage(String msgCode, Object[] args) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(msgCode, args, locale);
    }
}
