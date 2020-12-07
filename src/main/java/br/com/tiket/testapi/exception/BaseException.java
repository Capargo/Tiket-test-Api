package br.com.tiket.testapi.exception;

import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 5683611100549987323L;

    private HttpStatus status;

    private String message;

    public BaseException(HttpStatus status, String message){
        super(message);
        this.message = message;
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
