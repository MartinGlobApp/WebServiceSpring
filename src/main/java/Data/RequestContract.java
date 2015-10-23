package Data;

/**
 * Created by martin-valdez on 22/10/15.
 */
public final class RequestContract {
    /**
     * COMMON
     */
    private static final String INSERT = "/insert";
    private static final String GET_ONE = "/getOne";
    private static final String GET_ALL = "/getListAll";
    private static final String REPOSITORY = "Repository";
    private static final String SERVICE = "Service";

    /**
     * SERVER CONTROLLER
     */
    public static final String SERVER_GET_TIME = "/getTimeSever";
    public static final String SERVER_FORMAT_DATE = "dd//MM/yyyy HH:mm:ss";

    /**
     * BREAK CONTROLLER
     */
    private static final String breakClassName = "Break";
    private static final String breakClassNameToLowerCase = "break";

    public static final String BREAK_SERVICE_NAME = breakClassNameToLowerCase + SERVICE;
    public static final String BREAK_REPOSITORY_NAME = breakClassNameToLowerCase + REPOSITORY;

    public static final String INSERT_BREAK = INSERT + breakClassName;
    public static final String GET_ONE_BREAK = GET_ONE + breakClassName;
    public static final String GET_ALL_BREAK = GET_ALL + breakClassName;

    /**
     * BREAK STATE CONTROLLER
     */
    private static final String breakStateClassName = "BreakState";
    private static final String breakStateClassNameToLowerCase = "breakState";

    public static final String BREAKSTATE_SERVICE_NAME = breakStateClassNameToLowerCase + SERVICE;
    public static final String BREAKSTATE_REPOSITORY_NAME = breakStateClassNameToLowerCase + REPOSITORY;

    public static final String INSERT_BREAKSTATE = INSERT + breakStateClassName;
    public static final String GET_ONE_BREAKSTATE = GET_ONE + breakStateClassName;
    public static final String GET_ALL_BREAKSTATE = GET_ALL + breakStateClassName;

    /**
     * BREAK TYPE CONTROLLER
     */
    private static final String breakTypeClassName = "BreakType";
    private static final String breakTypeClassNameToLowerCase = "breakType";

    public static final String BREAKTYPE_SERVICE_NAME = breakTypeClassNameToLowerCase + SERVICE;
    public static final String BREAKTYPE_REPOSITORY_NAME = breakTypeClassNameToLowerCase + REPOSITORY;

    public static final String INSERT_BREAKTYPE = INSERT + breakTypeClassName;
    public static final String GET_ONE_BREAKTYPE = GET_ONE + breakTypeClassName;
    public static final String GET_ALL_BREAKTYPE = GET_ALL + breakTypeClassName;

    /**
     * CART CONTROLLER
     */
    private static final String cartClassName = "Cart";
    private static final String cartClassNameToLowerCase = "cart";


    public static final String CART_SERVICE_NAME = cartClassNameToLowerCase + SERVICE;
    public static final String CART_REPOSITORY_NAME = cartClassNameToLowerCase + REPOSITORY;

    public static final String INSERT_CART = INSERT + cartClassName;
    public static final String GET_ONE_CART = GET_ONE + cartClassName;
    public static final String GET_ALL_CART = GET_ALL + cartClassName;

    /**
     * MOMENT CONTROLLER
     */
    private static final String momentClassName = "Moment";
    private static final String momentClassNameToLowerCase = "moment";

    public static final String MOMENT_SERVICE_NAME = momentClassNameToLowerCase + SERVICE;
    public static final String MOMENT_REPOSITORY_NAME = momentClassNameToLowerCase + REPOSITORY;

    public static final String INSERT_MOMENT = INSERT + momentClassName;
    public static final String GET_ONE_MOMENT = GET_ONE + momentClassName;
    public static final String GET_ALL_MOMENT = GET_ALL + momentClassName;

    /**
     * MOMENT STATE CONTROLLER
     */
    private static final String momentStateClassName = "MomentState";
    private static final String momentStateClassNameToLowerCase = "momentState";

    public static final String MOMENTSTATE_SERVICE_NAME = momentStateClassNameToLowerCase + SERVICE;
    public static final String MOMENTSTATE_REPOSITORY_NAME = momentStateClassNameToLowerCase + REPOSITORY;

    public static final String INSERT_MOMENTSTATE = INSERT + momentStateClassName;
    public static final String GET_ONE_MOMENTSTATE = GET_ONE + momentStateClassName;
    public static final String GET_ALL_MOMENTSTATE = GET_ALL + momentStateClassName;

    /**
     * ORDER STATE CONTROLLER
     */
    private static final String orderStateClassName = "OrderState";
    private static final String orderStateClassNameToLowerCase = "orderState";

    public static final String ORDERSTATE_SERVICE_NAME = orderStateClassNameToLowerCase + SERVICE;
    public static final String ORDERSTATE_REPOSITORY_NAME = orderStateClassNameToLowerCase + REPOSITORY;

    public static final String INSERT_ORDERSTATE = INSERT + orderStateClassName;
    public static final String GET_ONE_ORDERSTATE = GET_ONE + orderStateClassName;
    public static final String GET_ALL_ORDERSTATE = GET_ALL + orderStateClassName;

    /**
     * PRODUCT CONTROLLER
     */
    private static final String productClassName = "Product";
    private static final String productClassNameToLowerCase = "product";

    public static final String PRODUCT_SERVICE_NAME = productClassNameToLowerCase + SERVICE;
    public static final String PRODUCT_REPOSITORY_NAME = productClassNameToLowerCase + REPOSITORY;

    public static final String INSERT_PRODUCT = INSERT + productClassName;
    public static final String GET_ONE_PRODUCT = GET_ONE + productClassName;
    public static final String GET_ALL_PRODUCT = GET_ALL + productClassName;

    /**
     * PURCHASE ORDER CONTROLLER
     */
    private static final String purchaseOrderClassName = "PurchaseOrder";
    private static final String purchaseOrderClassNameToLowerCase = "purchaseOrder";

    public static final String PURCHASEORDER_SERVICE_NAME = purchaseOrderClassNameToLowerCase + SERVICE;
    public static final String PURCHASEORDER_REPOSITORY_NAME = purchaseOrderClassNameToLowerCase + REPOSITORY;

    public static final String INSERT_PURCHASEORDER = INSERT + purchaseOrderClassName;
    public static final String GET_ONE_PURCHASEORDER = GET_ONE + purchaseOrderClassName;
    public static final String GET_ALL_PURCHASEORDER = GET_ALL + purchaseOrderClassName;

    /**
     * STATION CONTROLLER
     */
    private static final String stationClassName = "Station";
    private static final String stationClassNameToLowerCase = "station";


    public static final String STATION_SERVICE_NAME = stationClassNameToLowerCase + SERVICE;
    public static final String STATION_REPOSITORY_NAME = stationClassNameToLowerCase + REPOSITORY;

    public static final String INSERT_STATION = INSERT + stationClassName;
    public static final String GET_ONE_STATION = GET_ONE + stationClassName;
    public static final String GET_ALL_STATION = GET_ALL + stationClassName;

    /**
     * WORKER CONTROLLER
     */
    private static final String workerClassName = "Worker";
    private static final String workerClassNameToLowerCase = "worker";

    public static final String WORKER_SERVICE_NAME = workerClassNameToLowerCase + SERVICE;
    public static final String WORKER_REPOSITORY_NAME = workerClassNameToLowerCase + REPOSITORY;

    public static final String INSERT_WORKER = INSERT + workerClassName;
    public static final String GET_ONE_WORKER = GET_ONE + workerClassName;
    public static final String GET_ALL_WORKER = GET_ALL + workerClassName;
}
