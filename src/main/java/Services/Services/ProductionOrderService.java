package Services.Services;

import Data.MyResponse;
import Data.RequestContract;
import Data.ResponseStates;
import Services.Common.BasicService;
import Services.Repositories.ProductionOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by martin-valdez on 23/10/15.
 */
@Service(value = RequestContract.PRODUCTIONORDER_SERVICE_NAME)
public class ProductionOrderService extends BasicService {

    @Autowired
    private ProductionOrderRepository productionOrderRepository;

    public MyResponse getOne(final int id){
        MyResponse response = new MyResponse();
        try {
            response.setData(productionOrderRepository.getOne(id));
            response.setCode(ResponseStates.DONE);
        } catch (Exception e) {
            response.setCode(ResponseStates.ERROR_DB);
            response.setData(e.toString());
        }
        return response;
    }

    public MyResponse getListAll(){
        MyResponse response = new MyResponse();
        try {
            response.setData(productionOrderRepository.getListAll());
            response.setCode(ResponseStates.DONE);
        } catch (Exception e) {
            response.setCode(ResponseStates.ERROR_DB);
            response.setData(e.toString());
        }
        return response;
    }

    public MyResponse findPurchasOrderForCart(int idCart){
        MyResponse response = new MyResponse();
        try {
            response.setData(productionOrderRepository.findPurchasOrderForCart(idCart));
            response.setCode(ResponseStates.DONE);
        } catch (Exception e) {
            response.setCode(ResponseStates.ERROR_DB);
            response.setData(e.toString());
        }
        return response;

    }
}
