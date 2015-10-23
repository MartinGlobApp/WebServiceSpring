package Services.Repositories;

import Data.HibernateUtil;
import Data.RequestContract;
import Services.Common.BasicRepository;
import Services.Common.MyModel;
import Services.Entities.PurchaseOrder;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by martin-valdez on 23/10/15.
 */
@Repository(value = RequestContract.PURCHASEORDER_REPOSITORY_NAME)
public class PurchaseOrderRepository extends BasicRepository {

    @Override
    public MyModel getOne(final int id) throws Exception {
        Session session = HibernateUtil.getInstace().getSessionFactory().openSession();
        session.beginTransaction();
        MyModel myModel = (MyModel) session.get(PurchaseOrder.class, id);
        session.close();
        return myModel;
    }

    @Override
    public List<MyModel> getListAll() throws Exception {
        Session session = HibernateUtil.getInstace().getSessionFactory().openSession();
        session.beginTransaction();
        List<MyModel> listMyModel = session.createCriteria(PurchaseOrder.class).list();
        session.close();
        return listMyModel;
    }
}
