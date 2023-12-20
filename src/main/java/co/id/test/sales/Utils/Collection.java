package co.id.test.sales.Utils;

import co.id.test.sales.Constant.HttpConstant;
import co.id.test.sales.Exception.ResponseErrorException;
import co.id.test.sales.Pojo.Response.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class Collection {
    public final ResponseEntity<?> failResponse(Throwable e) {

        SuccessResponse response = new SuccessResponse();

        HttpStatus status = HttpStatus.BAD_REQUEST;
        if (e instanceof ResponseErrorException) {
            ResponseErrorException bse = (ResponseErrorException) e;
            response.setResponseCode(bse.getCode());
            response.setResponseMessage(bse.getMessage());
            status = bse.getHttpCode();

        }else{
            response.setResponseCode(HttpConstant.BADR_CODE);
            response.setResponseMessage(HttpConstant.MESSAGE_GENERAL_ERROR);
        }
        return new ResponseEntity<>(response, status);
    }
}
