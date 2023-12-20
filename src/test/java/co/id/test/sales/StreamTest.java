package co.id.test.sales;

import co.id.test.sales.RadistRepo.Entity.BasketEntity;
import co.id.test.sales.RadistRepo.Repository.BasketDao;
import co.id.test.sales.Service.BasketService;
import co.id.test.sales.Service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
public class StreamTest {
    @Autowired
    private BasketDao dao;
    @Test
    void contextLoads() {
        List< BasketEntity > data = dao.findAll();
        data.stream().forEach( x ->
                System.out.println(x.toString())
        );
    }
}
