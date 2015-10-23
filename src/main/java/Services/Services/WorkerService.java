package Services.Services;

import Data.MyResponse;
import Data.RequestContract;
import Data.ResponseStates;
import Services.Common.BasicService;
import Services.Repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by martin-valdez on 19/10/15.
 */
@Service(value = RequestContract.WORKER_SERVICE_NAME)
public class WorkerService extends BasicService{

    @Autowired
    private WorkerRepository workerRepository;

    public MyResponse getOne(final int id){
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
