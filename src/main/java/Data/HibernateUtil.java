package Data;

import Services.Entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Properties;

/**
 * Created by martin-valdez on 19/10/15.
 */
public class HibernateUtil {

    private static HibernateUtil instace = null;
    private static SessionFactory sessionFactory = null;
    private static ServiceRegistry serviceRegistry;

    enum Auto_hibernate{
        AUTO_CREATE {
            public String toString() {
                return "create";
            }
        },
        AUTO_UPDATE {
            public String toString() {
                return "update";
            }
        }
    }

    public HibernateUtil(){
        sessionFactory = buildSessionFactory();
    }

    private SessionFactory buildSessionFactory(){
        try{
            Properties properties = new Properties();
            properties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
            properties.put("hibernate.hbm2ddl.auto", Auto_hibernate.AUTO_UPDATE.toString());
            properties.put("hibernate.show_sql", "true");
            properties.put("hibernate.format_sql", "true");
            properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            properties.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/" + DBContract.DB_NAME);
            properties.put("hibernate.connection.username", DBContract.DB_USER);
            properties.put("hibernate.connection.password", DBContract.DB_PASS);

            Configuration configuration = new Configuration()
                    .addProperties(properties)
                    .addAnnotatedClass(BreakState.class)
                    .addAnnotatedClass(BreakType.class)
                    .addAnnotatedClass(Station.class)
                    .addAnnotatedClass(Worker.class)
                    .addAnnotatedClass(Cart.class)
                    .addAnnotatedClass(OrderState.class)
                    .addAnnotatedClass(MomentState.class)
                    .addAnnotatedClass(Break.class)
                    .addAnnotatedClass(ItemProcess.class)
                    .addAnnotatedClass(ProductionOrder.class)
                    .addAnnotatedClass(Moment.class)
                    .addAnnotatedClass(Product.class)
                    .addAnnotatedClass(ProductionOrderDocument.class)
                    .addAnnotatedClass(Document.class);

            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            return configuration.buildSessionFactory(serviceRegistry);
        }catch (Throwable ex){
            String erroMessage = ex.getMessage();
            throw new ExceptionInInitializerError();
        }
    }

    public static HibernateUtil getInstace(){
        if(instace == null){
            instace = new HibernateUtil();
        }
        return instace;
    }

    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public void shutdown(){
        getSessionFactory().close();
    }
}
