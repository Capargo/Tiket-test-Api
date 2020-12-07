package br.com.tiket.testapi.exception;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.validation.FieldError;

import java.util.Arrays;

public class Strings {

    public static String formatCode(String key) {
        String[] keyStrings = key.split("(?=\\p{Lu})");
        String keyUpdated = StringUtils.join(Arrays.asList(keyStrings), '_').toUpperCase();
        return keyUpdated;
    }

    public static String formatField(String field) {
        String[] fieldStrings = field.split("(?=\\p{Lu})");
        String fieldUpdated = StringUtils.join(Arrays.asList(fieldStrings), '_').toUpperCase();
        return fieldUpdated;
    }

    public static String formatResponseCode(FieldError error, String code) {
        String responseCode = String.format("%s_%s", Strings.formatField(error.getField()), code);
        return responseCode;
    }
}
