package Services.Controllers;

import Data.DBContract;
import Data.MyResponse;
import Data.RequestContract;
import Services.Entities.Cart;
import Services.Services.CartService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by martin-valdez on 22/10/15.
 */
@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = RequestContract.INSERT_CART, method = RequestMethod.POST)
    public MyResponse insertCart(@RequestBody final Cart newCart) {
        return cartService.insert(newCart);
    }

    @RequestMapping(RequestContract.GET_ONE_CART)
    public MyResponse getCart(@RequestParam(value = DBContract.CART_COLUMN_ID, defaultValue = "0") final int cartId){
        return cartService.getOne(cartId);
    }

    @RequestMapping(RequestContract.GET_ALL_CART)
    public MyResponse getListAllCarts(){
        return cartService.getListAll();
    }

    @RequestMapping("/getListAvailableCart")
    public MyResponse getListAvailableCart(){
        return cartService.getListAvailable();
    }

}
