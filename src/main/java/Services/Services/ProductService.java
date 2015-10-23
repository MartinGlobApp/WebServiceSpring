package Services.Services;

import Data.MyResponse;
import Data.ResponseStates;
import Services.Common.BasicRepository;
import Services.Common.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by martin-valdez on 20/10/15.
 */
@Service(value = "productService")
public class ProductService extends BasicService{

    @Autowired
    @Qualifier("productRepository")
    private BasicRepository productRepository;

    @Override
    public MyResponse getOne(int id){
        MyResponse response = new MyResponse();
        try {
            response.setData(productRepository.getOne(id));
            response.setCode(ResponseStates.DONE);
        } catch (Exception e) {
            response.setCode(ResponseStates.ERROR_DB);
            response.setData(e.toString());
        }
        return response;
    }

    @Override
    public MyResponse getListAll(){
        MyResponse response = new MyResponse();
        try {
            response.setData(productRepository.getListAll());
            response.setCode(ResponseStates.DONE);
        } catch (Exception e) {
            response.setCode(ResponseStates.ERROR_DB);
            response.setData(e.toString());
        }
        return response;
    }

}
