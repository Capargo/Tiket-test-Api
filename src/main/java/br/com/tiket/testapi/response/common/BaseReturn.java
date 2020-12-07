package br.com.tiket.testapi.response.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

import java.io.Serializable;

@Builder
@ToString
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseReturn<T> implements Serializable {

    private static final long serialVersionUID = -3607418919965508609L;

    public BaseReturn() {
        this.success = true;
        this.errorMessage = null;
        this.description = null;
        this.rejectValue = null;
        this.field = null;
        this.code = null;
        this.errorCode = null;
        this.error = null;
        this.data = null;
    }

    public BaseReturn(T data) {
        this.success = true;
        this.errorMessage = null;
        this.description = null;
        this.rejectValue = null;
        this.field = null;
        this.code = null;
        this.errorCode = null;
        this.error = null;
        this.data = data;
    }

    public Boolean success;

    public Integer errorCode;

    public String error;

    public String field;

    public Object rejectValue;

    public String errorMessage;

    public String description;

    public String code;

    public T data;
}
