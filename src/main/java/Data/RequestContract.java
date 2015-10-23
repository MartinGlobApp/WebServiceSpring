package Data;

import Services.Entities.Cart;
import Services.Entities.Product;
import Services.Entities.Station;
import Services.Entities.Worker;

/**
 * Created by martin-valdez on 22/10/15.
 */
public class RequestContract {

    /**
     * CART CONTROLLER
     */
    public static String CART_SERVICE_NAME = "cartService";
    public static String CART_REPOSITORY_NAME = "cartRepository";
    public static String INSERT_CART = "/insert" + Cart.class.getSimpleName();
    public static String GET_ONE_CART = "/getOne" + Cart.class.getSimpleName();
    public static String GET_ALL_CART = "/getListAll" + Cart.class.getSimpleName();
    /**
     * PRODUCT CONTROLLER
     */
    public static String PRODUCT_SERVICE_NAME = "productService";
    public static String PRODUCT_REPOSITORY_NAME = "productRepository";
    public static String INSERT_PRODUCT = "/insert" + Product.class.getSimpleName();
    public static String GET_ONE_PRODUCT = "/getOne" + Product.class.getSimpleName();
    public static String GET_ALL_PRODUCT = "/getListAll" + Product.class.getSimpleName();
    /**
     * STATION CONTROLLER
     */
    public static String STATION_SERVICE_NAME = "stationService";
    public static String STATION_REPOSITORY_NAME = "stationRepository";
    public static String INSERT_STATION = "/insert" + Station.class.getSimpleName();
    public static String GET_ONE_STATION = "/getOne" + Station.class.getSimpleName();
    public static String GET_ALL_STATION = "/getListAll" + Station.class.getSimpleName();
    /**
     * WORKER CONTROLLER
     */
    public static String WORKER_SERVICE_NAME = "workerService";
    public static String WORKER_REPOSITORY_NAME = "workerRepository";
    public static String INSERT_WORKER = "/insert" + Worker.class.getSimpleName();
    public static String GET_ONE_WORKER = "/getOne" + Worker.class.getSimpleName();
    public static String GET_ALL_WORKER = "/getListAll" + Worker.class.getSimpleName();

}
