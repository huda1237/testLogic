package co.id.test.sales.RadistRepo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("BasketEntity")
public class BasketEntity implements Serializable {
    @Id
    private long id;
    private long idProduct;
    private String name;
    private long qty;
    private long price;
}
