package Services.Common;

import Data.MyResponse;
import org.springframework.stereotype.Service;

/**
 * Created by martin-valdez on 22/10/15.
 */
@Service
public interface IService {
    MyResponse insert(final MyModel newModel);
    MyResponse update(final MyModel newModel);
    MyResponse delete(final MyModel model);
    MyResponse getOne(final int id);
    MyResponse getListAll();

}
