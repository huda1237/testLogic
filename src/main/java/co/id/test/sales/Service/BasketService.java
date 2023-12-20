package co.id.test.sales.Service;

import co.id.test.sales.Pojo.Request.Basket;
import co.id.test.sales.Pojo.Request.GroupProduct;
import org.springframework.http.ResponseEntity;

public interface BasketService {
    public ResponseEntity<?> addBasket(Basket request);
    public ResponseEntity<?> getBasket( long id);
    public ResponseEntity<?> findAllBasket();
}
