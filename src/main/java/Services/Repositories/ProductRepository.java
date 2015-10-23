package Services.Repositories;

import Data.HibernateUtil;
import Data.RequestContract;
import Services.Common.BasicRepository;
import Services.Common.MyModel;
import Services.Entities.ItemProcess;
import Services.Entities.Product;
import org.hibernate.Session;
import java.util.List;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * Created by martin-valdez on 20/10/15.
 */

@Primary
@Repository(value = RequestContract.PRODUCT_REPOSITORY_NAME)
public class ProductRepository extends BasicRepository{

    @Override
    public MyModel getOne(final int id) throws Exception{
        Session session = HibernateUtil.getInstace().getSessionFactory().openSession();
        session.beginTransaction();
        Product product = (Product) session.get(Product.class, id);

        List<ItemProcess> itemProcessList = product.getProcessList();
        for (ItemProcess itemProcess : itemProcessList){
            itemProcess.setProduct(null);
        }
        session.close();
        return product;
    }

    @Override
    public List<MyModel> getListAll() throws Exception{
        Session session = HibernateUtil.getInstace().getSessionFactory().openSession();
        session.beginTransaction();
        List<MyModel> listMyModel = session.createCriteria(Product.class).list();

        for(MyModel model : listMyModel){
            Product product = (Product) model;
            List<ItemProcess> itemProcessList = product.getProcessList();
            for (ItemProcess itemProcess : itemProcessList){
                itemProcess.setProduct(null);
            }
        }
        session.close();
        return listMyModel;
    }
}
