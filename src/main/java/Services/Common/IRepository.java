package Services.Common;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by martin-valdez on 22/10/15.
 */

@Repository
public interface IRepository {
    int insert(MyModel newModel) throws Exception;
    void delete(MyModel model) throws Exception;
    MyModel getOne(int id) throws Exception;
    List<MyModel> getListAll() throws Exception;
}
