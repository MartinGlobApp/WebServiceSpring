package Services.Repositories;

import Data.DBContract;
import Data.HibernateUtil;
import Data.RequestContract;
import Services.Common.BasicRepository;
import Services.Common.MyModel;
import Services.Entities.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by martin-valdez on 23/10/15.
 */
@Repository(value = RequestContract.PRODUCTIONORDER_REPOSITORY_NAME)
public class ProductionOrderRepository extends BasicRepository {

    @Override
    public MyModel getOne(final int id) throws Exception {
        Session session = HibernateUtil.getInstace().getSessionFactory().openSession();
        session.beginTransaction();
        ProductionOrder purchaseOrder = (ProductionOrder) session.get(ProductionOrder.class, id);

        List<ItemProcess> itemProcessList = purchaseOrder.getProduct().getProcessList();
        for (ItemProcess itemProcess : itemProcessList){
            itemProcess.setProduct(null);
        }
        return purchaseOrder;
    }

    @Override
    public List<MyModel> getListAll() throws Exception {
        Session session = HibernateUtil.getInstace().getSessionFactory().openSession();
        session.beginTransaction();
        List<MyModel> productionOrderList = session.createCriteria(ProductionOrder.class).list();

        for(MyModel model : productionOrderList){
            ProductionOrder productionOrder = (ProductionOrder) model;
            Product product = productionOrder.getProduct();
            List<ItemProcess> itemProcessList = product.getProcessList();
            for (ItemProcess itemProcess : itemProcessList){
                itemProcess.setProduct(null);
            }
        }

        return productionOrderList;
    }

    public List<ProductionOrder> findPurchasOrderForCart(int idCart){

        Session session = HibernateUtil.getInstace().getSessionFactory().openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(ProductionOrder.class);
        criteria.add(Restrictions.eq("cart." + DBContract.CART_COLUMN_ID, idCart));
        criteria.add(Restrictions.eq("orderState." + DBContract.ORDERSTATE_COLUMN_ID, 1)); // STATE INITIAL

        List<MyModel> productionOrderList = criteria.list();

        for(MyModel model : productionOrderList){
            ProductionOrder purchaseOrder = (ProductionOrder) model;
            Product product = purchaseOrder.getProduct();
            List<ItemProcess> itemProcessList = product.getProcessList();
            for (ItemProcess itemProcess : itemProcessList){
                itemProcess.setProduct(null);
            }
        }

        return criteria.list();
    }
}
