package co.id.test.sales.Pojo.Response;

import lombok.Data;

import java.io.Serializable;

@Data
public class SuccessResponse implements Serializable {
    private static final Long serialVersionUID = 1L ;
    private String responseCode;
    private String responseMessage;
    private Object payload;
}
