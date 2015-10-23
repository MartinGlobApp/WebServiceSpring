package Services.Common;

import Data.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by martin-valdez on 21/10/15.
 */

@Repository
public abstract class BasicRepository implements IRepository{

    public int insert(MyModel newModel) throws Exception{
        Session session = HibernateUtil.getInstace().getSessionFactory().openSession();
        session.beginTransaction();
        session.save(newModel);
        int id = newModel.getId();
        session.getTransaction().commit();
        session.close();
        return id;
    }

    public void delete(MyModel model) throws Exception{
        Session session = HibernateUtil.getInstace().getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(model);
        session.getTransaction().commit();
        session.close();
    }

    public MyModel getOne(int id) throws Exception{
        return null;
    }

    public List<MyModel> getListAll() throws Exception{
        return null;
    }
}
