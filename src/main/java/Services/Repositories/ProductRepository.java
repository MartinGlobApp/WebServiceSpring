package Services.Repositories;

import Data.HibernateUtil;
import Services.Common.BasicRepository;
import Services.Common.MyModel;
import Services.Entities.ItemProcess;
import Services.Entities.Product;
import org.hibernate.Session;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by martin-valdez on 20/10/15.
 */

@Primary
@Repository(value = "productRepository")
public class ProductRepository extends BasicRepository{

    @Override
    public MyModel getOne(int id) throws Exception{
        Session session = HibernateUtil.getInstace().getSessionFactory().openSession();
        session.beginTransaction();
        MyModel myModel = (MyModel) session.get(Product.class, id);
        return myModel;
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
        return listMyModel;
    }
}
