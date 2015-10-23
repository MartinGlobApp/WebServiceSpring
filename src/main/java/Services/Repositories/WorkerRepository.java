package Services.Repositories;

import Data.HibernateUtil;
import Services.Common.BasicRepository;
import Services.Common.MyModel;
import Services.Entities.Worker;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by martin-valdez on 19/10/15.
 */
@Repository(value = "workerRepository")
public class WorkerRepository extends BasicRepository {

    @Override
    public MyModel getOne(int id) throws Exception{
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
        List<MyModel> listModel = session.createCriteria(Worker.class).list();
        session.close();
        return listModel;
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
