package co.id.test.sales.Controller;

import co.id.test.sales.Pojo.Request.GroupProduct;
import co.id.test.sales.Pojo.Request.Product;
import co.id.test.sales.Service.ProductService;
import co.id.test.sales.Utils.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1.0/product")
public class ProductController {
    private final ProductService service;
    private final Collection collection;

    @PostMapping("/insert")
    public <T> T insert(
            @RequestBody Product req
    ) {
        try{
            return (T) service.insert( req);
        }catch (Exception e){
            e.printStackTrace();
            return (T) collection.failResponse(e);
        }
    }
    @GetMapping("get")
    public <T> T get(
            @RequestParam int id
    ) {
        try{
            return (T) service.get( id);
        }catch (Exception e){
            e.printStackTrace();
            return (T) collection.failResponse(e);
        }
    }
    @GetMapping ("get-all")
    public <T> T getAll(
    ) {
        try{
            return (T) service.getAll( );
        }catch (Exception e){
            e.printStackTrace();
            return (T) collection.failResponse(e);
        }
    }
}
