package co.id.test.sales.Service;

import co.id.test.sales.Pojo.Request.GroupProduct;
import org.springframework.http.ResponseEntity;

public interface GroupProductService {
    public ResponseEntity<?> insert(GroupProduct request);
    public ResponseEntity<?> get( int id);
    public ResponseEntity<?> getAll();
}
