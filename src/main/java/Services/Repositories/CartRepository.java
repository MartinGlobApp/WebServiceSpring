package Services.Repositories;

import Data.DBContract;
import Data.HibernateUtil;
import Data.RequestContract;
import Services.Common.BasicRepository;
import Services.Common.MyModel;
import Services.Entities.Cart;
import Services.Entities.ProductionOrder;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by martin-valdez on 22/10/15.
 */
@Repository(value = RequestContract.CART_REPOSITORY_NAME)
public class CartRepository extends BasicRepository {

    @Override
    public MyModel getOne(final int id) throws Exception{
        Session session = HibernateUtil.getInstace().getSessionFactory().openSession();
        session.beginTransaction();
        MyModel myModel = (MyModel) session.get(Cart.class, id);
        session.close();
        return myModel;
    }

    @Override
    public List<MyModel> getListAll() throws Exception{
        Session session = HibernateUtil.getInstace().getSessionFactory().openSession();
        session.beginTransaction();
        List<MyModel> listMyModel = session.createCriteria(Cart.class).list();
        session.close();
        return listMyModel;
    }

    public List<Cart> getListAvailable() throws Exception{
        Session session = HibernateUtil.getInstace().getSessionFactory().openSession();
        session.beginTransaction();

        String subQuery = "(SELECT " + DBContract.CART_COLUMN_ID +
                " FROM " + DBContract.PRODUCTIONORDER_TABLE +
                " WHERE " + DBContract.ORDERSTATE_COLUMN_ID + " != 4)";

        String query =
                "SELECT " + DBContract.CART_COLUMN_ID +
                "," + DBContract.CART_COLUMN_NAME +
                "," + DBContract.CART_COLUMN_TABLETMAC +
                " FROM " + DBContract.CART_TABLE +
                " WHERE " + DBContract.CART_COLUMN_ID + " NOT IN " + subQuery;

        List<Cart> listMyModel = session.createSQLQuery(query)
                .addEntity(Cart.class)
                .list();
        session.close();

        return listMyModel;
    }

}
