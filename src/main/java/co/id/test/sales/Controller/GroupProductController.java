package co.id.test.sales.Controller;


import co.id.test.sales.Pojo.Request.GroupProduct;
import co.id.test.sales.Service.GroupProductService;
import co.id.test.sales.Utils.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/v1.0/group-product")
public class GroupProductController
{
    private final GroupProductService service;
    private final Collection collection;

    @PostMapping("/insert")
    public <T> T insert(
            @RequestBody GroupProduct req
    ) {
        try{
            return (T) service.insert( req);
        }catch (Exception e){
           e.printStackTrace();
           return (T) collection.failResponse(e);
        }
    }
    @GetMapping ("get")
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
