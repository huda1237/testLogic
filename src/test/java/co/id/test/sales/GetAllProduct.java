package co.id.test.sales;

import co.id.test.sales.Dao.PerentInterfaceDao;
import co.id.test.sales.Pojo.Request.Product;
import co.id.test.sales.RadistRepo.Entity.BasketEntity;
import co.id.test.sales.RadistRepo.Repository.BasketDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GetAllProduct {
    @Autowired
    @Qualifier("ProductDao")
    PerentInterfaceDao dao;

    @Test
    void contextLoads() {
        List< Product > data = dao.getAll(Product.class );
        System.out.println(data.toString());
    }
}
