package co.id.test.sales.Controller;

import co.id.test.sales.Pojo.Request.Basket;
import co.id.test.sales.Pojo.Request.GroupProduct;
import co.id.test.sales.Service.BasketService;
import co.id.test.sales.Service.GroupProductService;
import co.id.test.sales.Utils.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1.0/basket")
public class BasketController {
    private final BasketService service;
    private final Collection collection;

    @PostMapping("/add-basket")
    public <T> T insert(
            @RequestBody Basket req
    ) {
        try{
            return (T) service.addBasket( req);
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
            return (T) service.getBasket( id);
        }catch (Exception e){
            e.printStackTrace();
            return (T) collection.failResponse(e);
        }
    }
    @GetMapping ("get-all")
    public <T> T getAll(
    ) {
        try{
            return (T) service.findAllBasket( );
        }catch (Exception e){
            e.printStackTrace();
            return (T) collection.failResponse(e);
        }
    }
}
