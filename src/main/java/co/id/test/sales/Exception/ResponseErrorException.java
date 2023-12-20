package co.id.test.sales.Exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;


/*
 * class build exception from app
 *
 * */
@Getter
@Setter
@ToString
public class ResponseErrorException extends RuntimeException{
    private final String code;
    private final String message;
    private final HttpStatus httpCode;

    public ResponseErrorException() {
        this.code = "400";
        this.message = "error data";
        this.httpCode = HttpStatus.BAD_REQUEST;
    }

    public ResponseErrorException(String message) {
        // super(message);
        this.httpCode = HttpStatus.BAD_REQUEST;
        this.message = message;
        this.code ="400";
    }
    public ResponseErrorException(String code, String message , HttpStatus httpStatus) {
        this.message = message;
        this.code = code;
        this.httpCode = httpStatus;
    }
}
