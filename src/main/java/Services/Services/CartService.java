package Services.Services;

import Data.MyResponse;
import Data.ResponseStates;
import Services.Common.BasicRepository;
import Services.Common.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by martin-valdez on 22/10/15.
 */
@Service(value = "cartService")
public class CartService extends BasicService {

    @Autowired
    @Qualifier("cartRepository")
    private BasicRepository cartRepository;

    @Override
    public MyResponse getOne(int id){
        MyResponse response = new MyResponse();
        try {
            response.setData(cartRepository.getOne(id));
            response.setCode(ResponseStates.DONE);
        } catch (Exception e) {
            response.setCode(ResponseStates.ERROR_DB);
            response.setData(e.toString());
        }
        return response;
    }

}
