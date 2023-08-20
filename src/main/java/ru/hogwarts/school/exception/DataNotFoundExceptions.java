package ru.hogwarts.school.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST )
public class DataNotFoundExceptions extends RuntimeException{
    public DataNotFoundExceptions() {
    }

    public DataNotFoundExceptions(String message) {
        super(message);
    }

    public DataNotFoundExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public DataNotFoundExceptions(Throwable cause) {
        super(cause);
    }

    public DataNotFoundExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}