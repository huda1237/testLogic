package co.id.test.sales.Service;

import co.id.test.sales.Pojo.Request.Product;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    public ResponseEntity<?> insert(Product request);
    public ResponseEntity<?> get( int id);
    public ResponseEntity<?> getAll();
}
