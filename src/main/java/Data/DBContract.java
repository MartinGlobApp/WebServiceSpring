package Data;

/**
 * Created by martin-valdez on 19/10/15.
 */
public class DBContract {

    public static final String DB_NAME = "ScarpattiDB";
    public static final String DB_USER = "root";
    public static final String DB_PASS = "root";

    /**
     * WORKERS
     */
    public static final String WORKER_TABLE = "Workers";
    public static final String WORKER_COLUMN_ID = "workerId";
    /**
     * PRODUCTS
     */
    public static final String PRODUCTS_TABLE = "Products";
    public static final String PRODUCTS_COLUMN_ID = "productId";
    /**
     * CARTS
     */
    public static final String CART_TABLE = "Carts";
    public static final String CART_COLUMN_ID = "cartId";
    /**
     * STATIONS
     */
    public static final String STATION_TABLE = "Stations";
    public static final String STATION_COLUMN_ID = "stationId";
    /**
     * BREAKS TYPE
     */
    public static final String BREAKTYPE_TABLE = "BreakType";
    /**
     * BREAK STATES
     */
    public static final String BREAKSTATES_TABLE = "BreakStates";
    public static final String BREAKSTATES_COLUMN_ID = "breakStateId";
    /**
     * PROCESSES
     */
    public static final String ITEMPROCESS_TABLE = "ItemProcesses";
    /**
     * BREAKS
     */
    public static final String BREAK_TABLE = "Breaks";
    public static final String BREAK_COLUMN_ID = "breakTypeId";
    /**
     * MOMENT STATES
     */
    public static final String MOMENTSTATE_TABLE = "MomentStates";
    public static final String MOMENTSTATE_COLUMN_ID = "momentStateId";
    /**
     * ORDER STATES
     */
    public static final String ORDERSTATE_TABLE = "OrderStates";
    public static final String ORDERSTATE_COLUMN_ID = "orderStateId";
    /**
     * MOMENTS
     */
    public static final String MOMENT_TABLE = "Moments";
    public static final String MOMENT_COLUMN_ID = "momentId";
    /**
     * ORDERS
     */
    public static final String PURCHASEORDER_TABLE = "PruchaseOrders";
    public static final String PURCHASEORDER_COLUMN_ID = "purchaseOrderId";
}
