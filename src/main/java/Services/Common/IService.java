package Services.Common;

import Data.MyResponse;
import org.springframework.stereotype.Service;

/**
 * Created by martin-valdez on 22/10/15.
 */
@Service
public interface IService {
    MyResponse insert(MyModel newModel);
    MyResponse delete(MyModel model);
    MyResponse getOne(int id);
    MyResponse getListAll();

}
