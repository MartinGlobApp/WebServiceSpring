package Services.Controllers;

import Data.DBContract;
import Data.MyResponse;
import Data.RequestContract;
import Services.Entities.ProductionOrder;
import Services.Services.ProductionOrderService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by martin-valdez on 23/10/15.
 */
@RestController
public class ProductionOrderController {

    @Autowired
    private ProductionOrderService productionOrderService;

    @RequestMapping(value = RequestContract.INSERT_PRODUCTIONORDER, method = RequestMethod.POST)
    public MyResponse insertProductionOrder(@RequestBody final ProductionOrder newPurchaseOrder) {
        return productionOrderService.insert(newPurchaseOrder);
    }

    @RequestMapping(RequestContract.GET_ONE_PRODUCTIONORDER)
    public MyResponse getProductionOrder(@RequestParam(value = DBContract.PRODUCTIONORDER_COLUMN_ID, defaultValue = "0") final int purchaseOrderId){
        return productionOrderService.getOne(purchaseOrderId);
    }

    @RequestMapping(RequestContract.GET_ALL_PRODUCTIONORDER)
    public MyResponse getListAllProductionOrder(){
        return productionOrderService.getListAll();
    }

    @RequestMapping("/findProductionOrderForCart")
    public MyResponse findProductionOrderForCart(int idCart){
        return productionOrderService.findPurchasOrderForCart(idCart);
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public MyResponse uploadFile(@RequestBody final MultipartFile file){
        MyResponse response = new MyResponse();
        if(!file.isEmpty()){
            try{
                byte[] bytes = file.getBytes();
                File dir = new File("Files");
                if(!dir.exists()){
                    dir.mkdirs();
                }

                File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                response.setData("URL : " + serverFile.getAbsolutePath());
            }catch (Exception e){
                response.setData("ERROR : " + e.toString());
            }
        }
        return  response;
    }
}
