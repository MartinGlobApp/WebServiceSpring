package Services.Repositories;

import Data.HibernateUtil;
import Services.Common.BasicRepository;
import Services.Common.MyModel;
import Services.Entities.Cart;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by martin-valdez on 22/10/15.
 */
@Repository(value = "cartRepository")
public class CartRepository extends BasicRepository {

    @Override
    public MyModel getOne(int id) throws Exception{
        Session session = HibernateUtil.getInstace().getSessionFactory().openSession();
        session.beginTransaction();
        MyModel myModel = (MyModel) session.get(Cart.class, id);
        return myModel;
    }

    @Override
    public List<MyModel> getListAll() throws Exception{
        Session session = HibernateUtil.getInstace().getSessionFactory().openSession();
        session.beginTransaction();
        List<MyModel> listMyModel = session.createCriteria(Cart.class).list();
        return listMyModel;
    }

}
