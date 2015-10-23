package Services.Controllers;

import Data.DBContract;
import Data.MyResponse;
import Data.RequestContract;
import Services.Entities.OrderState;
import Services.Services.OrderStateService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by martin-valdez on 23/10/15.
 */
@RestController
public class OrderStateController {

    @Autowired
    private OrderStateService orderStateService;

    @RequestMapping(value = RequestContract.INSERT_ORDERSTATE, method = RequestMethod.POST)
    public MyResponse insertOrderState(@RequestBody final OrderState newOrderState) {
        return orderStateService.insert(newOrderState);
    }

    @RequestMapping(RequestContract.GET_ONE_ORDERSTATE)
    public MyResponse getOrderState(@RequestParam(value = DBContract.ORDERSTATE_COLUMN_ID, defaultValue = "0") final int orderStateId){
        return orderStateService.getOne(orderStateId);
    }

    @RequestMapping(RequestContract.GET_ALL_ORDERSTATE)
    public MyResponse getListAllOrderStates(){
        return orderStateService.getListAll();
    }
}
