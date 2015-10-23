package Services.Repositories;

import Data.HibernateUtil;
import Data.RequestContract;
import Services.Common.BasicRepository;
import Services.Common.MyModel;
import Services.Entities.Worker;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import java.util.List;
import org.springframework.stereotype.Repository;


/**
 * Created by martin-valdez on 19/10/15.
 */
@Repository(value = RequestContract.WORKER_REPOSITORY_NAME)
public class WorkerRepository extends BasicRepository {

    @Override
    public MyModel getOne(final int id) throws Exception{
        Session session = HibernateUtil.getInstace().getSessionFactory().openSession();
        session.beginTransaction();
        MyModel myModel = (MyModel) session.get(Worker.class, id);
        session.close();
        return myModel;
    }

    @Override
    public List<MyModel> getListAll() throws Exception{
        Session session = HibernateUtil.getInstace().getSessionFactory().openSession();
        session.beginTransaction();
        List<MyModel> listMyModel = session.createCriteria(Worker.class).list();
        session.close();
        return listMyModel;
    }

    public List<Worker> getListAllOrderBy(String column) throws Exception{
        Session session = HibernateUtil.getInstace().getSessionFactory().openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Worker.class);
        criteria.addOrder(Order.asc(column));

        List<Worker> listWorker = criteria.list();
        session.close();
        return listWorker;
    }
}
