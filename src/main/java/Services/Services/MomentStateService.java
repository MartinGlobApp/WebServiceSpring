package Services.Services;

import Data.MyResponse;
import Data.RequestContract;
import Data.ResponseStates;
import Services.Common.BasicService;
import Services.Repositories.MomentRepository;
import Services.Repositories.MomentStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by martin-valdez on 23/10/15.
 */
@Service(value = RequestContract.MOMENTSTATE_SERVICE_NAME)
public class MomentStateService extends BasicService {

    @Autowired
    private MomentStateRepository momentStateRepository;

    public MyResponse getOne(final int id){
        MyResponse response = new MyResponse();
        try {
            response.setData(momentStateRepository.getOne(id));
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
            response.setData(momentStateRepository.getListAll());
            response.setCode(ResponseStates.DONE);
        } catch (Exception e) {
            response.setCode(ResponseStates.ERROR_DB);
            response.setData(e.toString());
        }
        return response;
    }
}
