package co.id.test.sales.Service;

import co.id.test.sales.Constant.HttpConstant;
import co.id.test.sales.Dao.PerentInterfaceDao;
import co.id.test.sales.Pojo.Request.GroupProduct;
import co.id.test.sales.Pojo.Response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class GroupProductImplementService implements GroupProductService{

    @Qualifier("groupProduct")
    private final PerentInterfaceDao dao;
    @Override
    public ResponseEntity<?> insert(GroupProduct request) {
        log.debug("Arcive Request");
        SuccessResponse response = new SuccessResponse();
        response.setResponseMessage(HttpConstant.MESSAGE_SUCCESS);
        response.setResponseCode(HttpConstant.SUCCESS_CODE);
        Object[] objects = {
               request.getGroupName() ,
               request.getDescription()
        };
        GroupProduct insert = dao.insert(objects ,GroupProduct.class );

        response.setPayload(insert);

        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> get(int id) {
        log.debug("Arcive Request");
        SuccessResponse response = new SuccessResponse();
        response.setResponseMessage(HttpConstant.MESSAGE_SUCCESS);
        response.setResponseCode(HttpConstant.SUCCESS_CODE);
        Object[] objects = {
                id
        };
        GroupProduct insert = dao.get(objects ,GroupProduct.class );
        response.setPayload(insert);

        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity< ? > getAll() {
        log.debug("Arcive Request");
        SuccessResponse response = new SuccessResponse();
        response.setResponseMessage(HttpConstant.MESSAGE_SUCCESS);
        response.setResponseCode(HttpConstant.SUCCESS_CODE);

        List<GroupProduct> insert = dao.getAll(GroupProduct.class );
        response.setPayload(insert);

        return  new ResponseEntity<>(response, HttpStatus.OK);
    }
}
