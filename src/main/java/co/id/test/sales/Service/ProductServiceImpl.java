package co.id.test.sales.Service;

import co.id.test.sales.Constant.HttpConstant;
import co.id.test.sales.Dao.PerentInterfaceDao;
import co.id.test.sales.Pojo.Request.GroupProduct;
import co.id.test.sales.Pojo.Request.Product;
import co.id.test.sales.Pojo.Response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{

    @Autowired
    @Qualifier("ProductDao")
    PerentInterfaceDao dao;

    @Override
    public ResponseEntity< ? > insert(Product request) {

        log.debug("Arcive Request");
        SuccessResponse response = new SuccessResponse();
        response.setResponseMessage(HttpConstant.MESSAGE_SUCCESS);
        response.setResponseCode(HttpConstant.SUCCESS_CODE);
        Object[] objects = {
                request.getProductName() ,
                request.getPrice() ,
                request.getGroupId()
        };
        Product insert = dao.insert(objects ,Product.class );

        response.setPayload(insert);

        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity< ? > get(int id) {
        log.debug("Arcive Request");
        SuccessResponse response = new SuccessResponse();
        response.setResponseMessage(HttpConstant.MESSAGE_SUCCESS);
        response.setResponseCode(HttpConstant.SUCCESS_CODE);
        Object[] objects = {
                id
        };
        Product insert = dao.get(objects ,Product.class );
        response.setPayload(insert);

        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity< ? > getAll() {
        log.debug("Arcive Request");
        SuccessResponse response = new SuccessResponse();
        response.setResponseMessage(HttpConstant.MESSAGE_SUCCESS);
        response.setResponseCode(HttpConstant.SUCCESS_CODE);

        List<Product> insert = dao.getAll(Product.class );
        response.setPayload(insert);

        return  new ResponseEntity<>(response, HttpStatus.OK);
    }
}
