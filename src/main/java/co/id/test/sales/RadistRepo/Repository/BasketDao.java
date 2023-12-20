package co.id.test.sales.RadistRepo.Repository;

import co.id.test.sales.RadistRepo.Entity.BasketEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BasketDao {
    public static final String HASH_KEY = "BasketEntity";
    @Autowired
    private RedisTemplate template;
    public BasketEntity save(BasketEntity basket){
        template.opsForHash().put(HASH_KEY,basket.getId(),basket);
        return basket;
    }

    public List< BasketEntity > findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public BasketEntity findProductById(long id){
        return (BasketEntity) template.opsForHash().get(HASH_KEY,id);
    }
}
