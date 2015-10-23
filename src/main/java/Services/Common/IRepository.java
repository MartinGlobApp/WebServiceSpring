package Services.Common;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * Created by martin-valdez on 22/10/15.
 */

@Repository
public interface IRepository {
    int insert(final MyModel newModel) throws Exception;
    void update(final MyModel newModel) throws Exception;
    void delete(final MyModel model) throws Exception;
    MyModel getOne(final int id) throws Exception;
    List<MyModel> getListAll() throws Exception;
}
