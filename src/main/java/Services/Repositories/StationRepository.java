package Services.Repositories;

import Data.HibernateUtil;
import Data.RequestContract;
import Services.Common.BasicRepository;
import Services.Common.MyModel;
import Services.Entities.Station;
import org.hibernate.Session;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * Created by martin-valdez on 20/10/15.
 */
@Repository(value = RequestContract.STATION_REPOSITORY_NAME)
public class StationRepository extends BasicRepository{

    @Override
    public MyModel getOne(final int id) throws Exception{
        Session session = HibernateUtil.getInstace().getSessionFactory().openSession();
        session.beginTransaction();
        MyModel myModel = (MyModel) session.get(Station.class, id);
        session.close();
        return myModel;
    }

    @Override
    public List<MyModel> getListAll() throws Exception{
        Session session = HibernateUtil.getInstace().getSessionFactory().openSession();
        session.beginTransaction();
        List<MyModel> listMyModel = session.createCriteria(Station.class).list();
        session.close();
        return listMyModel;
    }
}
