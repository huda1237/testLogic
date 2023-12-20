package co.id.test.sales.Pojo.Request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GroupProduct {
    @JsonProperty("group_id")
    private int groupId;
    @JsonProperty("group_name")
    private String groupName;
    @JsonProperty("description")
    private String description;
}
