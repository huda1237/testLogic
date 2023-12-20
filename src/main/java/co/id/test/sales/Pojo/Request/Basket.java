package co.id.test.sales.Pojo.Request;

import lombok.Data;

@Data
public class Basket {
    private int idProduct;
    private String name;
    private int qty;
    private long price;
}
