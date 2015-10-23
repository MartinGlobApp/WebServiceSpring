package Services.Services;

import Data.MyResponse;
import Data.ResponseStates;
import Services.Common.BasicRepository;
import Services.Common.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by martin-valdez on 19/10/15.
 */
@Service(value = "workerService")
public class WorkerService extends BasicService{

    @Autowired
    @Qualifier("workerRepository")
    private BasicRepository workerRepository;

    @Override
    public MyResponse getOne(int id){
        MyResponse response = new MyResponse();
        try {
            response.setData(workerRepository.getOne(id));
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
            response.setData(workerRepository.getListAll());
            response.setCode(ResponseStates.DONE);
        } catch (Exception e) {
            response.setCode(ResponseStates.ERROR_DB);
            response.setData(e.toString());
        }
        return response;
    }
}
