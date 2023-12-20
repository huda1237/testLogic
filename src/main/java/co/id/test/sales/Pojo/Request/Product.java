package co.id.test.sales.Pojo.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Product {
    @JsonProperty("product_id")
    private int productId;
    @JsonProperty("product_name")
    private String productName;
    @JsonProperty("price")
    private String price;
    @JsonProperty("group_id")
    private int groupId;
    @JsonProperty("group_name")
    private String groupName;
    @JsonProperty("description_group")
    private String descriptionGroup;
}
