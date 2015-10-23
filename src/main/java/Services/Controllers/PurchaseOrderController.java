package Services.Controllers;

import Data.DBContract;
import Data.MyResponse;
import Data.RequestContract;
import Services.Entities.PurchaseOrder;
import Services.Services.PurchaseOrderService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by martin-valdez on 23/10/15.
 */
@RestController
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @RequestMapping(value = RequestContract.INSERT_PURCHASEORDER, method = RequestMethod.POST)
    public MyResponse insertPurchaseOrder(@RequestBody final PurchaseOrder newPurchaseOrder) {
        return purchaseOrderService.insert(newPurchaseOrder);
    }

    @RequestMapping(RequestContract.GET_ONE_PURCHASEORDER)
    public MyResponse getPurchaseOrder(@RequestParam(value = DBContract.PURCHASEORDER_COLUMN_ID, defaultValue = "0") final int purchaseOrderId){
        return purchaseOrderService.getOne(purchaseOrderId);
    }

    @RequestMapping(RequestContract.GET_ALL_PURCHASEORDER)
    public MyResponse getListAllPurchaseOrder(){
        return purchaseOrderService.getListAll();
    }
}
