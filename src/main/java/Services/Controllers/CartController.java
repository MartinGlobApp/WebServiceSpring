package Services.Controllers;

import Data.MyResponse;
import Services.Common.BasicService;
import Services.Entities.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by martin-valdez on 22/10/15.
 */
@RestController
public class CartController {

    @Autowired
    @Qualifier("cartService")
    private BasicService cartService;

    @RequestMapping(value = "/insertCart")
    public MyResponse insertCart(String name, String tabletMac) {
        Cart cart = null;
        if(name != null && tabletMac != null
                && !name.equals("") && !tabletMac.equals("")){
            cart = new Cart();
            cart.setName(name);
            cart.setTabletMac(tabletMac);
        }
        return cartService.insert(cart);
    }

    @RequestMapping("/getCart")
    public MyResponse getCart(@RequestParam(value = "cartId", defaultValue = "0") int cartId){
        return cartService.getOne(cartId);
    }

}
