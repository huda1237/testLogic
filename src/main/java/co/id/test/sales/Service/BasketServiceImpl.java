package co.id.test.sales.Service;

import co.id.test.sales.Constant.HttpConstant;
import co.id.test.sales.Pojo.Request.Basket;
import co.id.test.sales.Pojo.Request.GroupProduct;
import co.id.test.sales.Pojo.Response.SuccessResponse;
import co.id.test.sales.RadistRepo.Entity.BasketEntity;
import co.id.test.sales.RadistRepo.Repository.BasketDao;
import co.id.test.sales.Utils.Utils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class BasketServiceImpl implements BasketService{
    @Autowired
    private BasketDao dao;
    @Autowired
    private Utils utils;
    @Override
    public ResponseEntity< ? > addBasket(Basket request) {
        BasketEntity data = new BasketEntity();
        data.setId(utils.functionNanotimes());
        data.setName(request.getName());
        data.setQty(request.getQty());
        data.setPrice(request.getPrice());
        data.setIdProduct(request.getIdProduct());

        BasketEntity save = dao.save(data);
        log.debug("Arcive Request");
        SuccessResponse response = new SuccessResponse();
        response.setResponseMessage(HttpConstant.MESSAGE_SUCCESS);
        response.setResponseCode(HttpConstant.SUCCESS_CODE);


        response.setPayload(save);

        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity< ? > getBasket(long id) {
        BasketEntity data = dao.findProductById(id);
        log.debug("Arcive Request");
        SuccessResponse response = new SuccessResponse();
        response.setResponseMessage(HttpConstant.MESSAGE_SUCCESS);
        response.setResponseCode(HttpConstant.SUCCESS_CODE);


        response.setPayload(data);

        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity< ? > findAllBasket() {
        List<BasketEntity> data = dao.findAll();
        log.debug("Arcive Request");

        SuccessResponse response = new SuccessResponse();
        response.setResponseMessage(HttpConstant.MESSAGE_SUCCESS);
        response.setResponseCode(HttpConstant.SUCCESS_CODE);


        response.setPayload(data);

        return  new ResponseEntity<>(response, HttpStatus.OK);
    }
}
