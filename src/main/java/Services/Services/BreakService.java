package Services.Services;

import Data.MyResponse;
import Data.RequestContract;
import Data.ResponseStates;
import Services.Common.BasicService;
import Services.Repositories.BreakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by martin-valdez on 23/10/15.
 */
@Service(value = RequestContract.BREAK_SERVICE_NAME)
public class BreakService extends BasicService {

    @Autowired
    private BreakRepository breakRepository;

    public MyResponse getOne(final int id){
        MyResponse response = new MyResponse();
        try {
            response.setData(breakRepository.getOne(id));
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
            response.setData(breakRepository.getListAll());
            response.setCode(ResponseStates.DONE);
        } catch (Exception e) {
            response.setCode(ResponseStates.ERROR_DB);
            response.setData(e.toString());
        }
        return response;
    }
}
