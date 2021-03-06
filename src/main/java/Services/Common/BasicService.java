package Services.Common;

import Data.MyResponse;
import Data.ResponseStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by martin-valdez on 21/10/15.
 */

@Service
public abstract class BasicService implements IService {

    @Autowired
    private BasicRepository mRepository;

    public MyResponse insert(final MyModel newModel){
        MyResponse response = new MyResponse();
        if(newModel != null){
            try {
                response.setData(mRepository.insert(newModel));
                response.setCode(ResponseStates.DONE);
            } catch (Exception e) {
                response.setCode(ResponseStates.ERROR_DB);
                response.setData(e.toString());
            }
        }else{
            response.setData("Incorrect Parameters");
            response.setCode(ResponseStates.ERROR_DATA);
        }
        return response;
    }

    public MyResponse update(final MyModel newModel){
        MyResponse response = new MyResponse();
        if(newModel != null){
            try {
                mRepository.update(newModel);
                response.setCode(ResponseStates.DONE);
            } catch (Exception e) {
                response.setCode(ResponseStates.ERROR_DB);
                response.setData(e.toString());
            }
        }else{
            response.setData("Something went wrong");
            response.setCode(ResponseStates.ERROR_DATA);
        }
        return response;
    }

    public MyResponse delete(final MyModel model){
        MyResponse response = new MyResponse();
        if(model != null){
            try {
                mRepository.delete(model);
                response.setCode(ResponseStates.DONE);
            } catch (Exception e) {
                response.setCode(ResponseStates.ERROR_DB);
                response.setData(e.toString());
            }
        }else{
            response.setCode(ResponseStates.ERROR_DATA);
        }
        return response;

    }
}
