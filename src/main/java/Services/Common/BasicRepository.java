package Services.Common;

import Data.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * Created by martin-valdez on 21/10/15.
 */

@Repository
public abstract class BasicRepository implements IRepository{

    public int insert(final MyModel newModel) throws Exception{
        Session session = HibernateUtil.getInstace().getSessionFactory().openSession();
        session.beginTransaction();
        session.save(newModel);
        int id = newModel.getId();
        session.getTransaction().commit();
        session.close();
        return id;
    }

    public void update(final MyModel newModel) throws Exception{
        Session session = HibernateUtil.getInstace().getSessionFactory().openSession();
        session.beginTransaction();
        session.update(newModel);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(final MyModel model) throws Exception{
        Session session = HibernateUtil.getInstace().getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(model);
        session.getTransaction().commit();
        session.close();
    }
}
