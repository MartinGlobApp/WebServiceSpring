package Data;

public class ResponseStates {
    public static final int DONE = 200;// OK
    public static final int ERROR_DB = 400;// ERROR SAVE MYSQL-HIBERNATE
    public static final int ERROR_DATA = 500;// PARAMETERS ERROR
    public static final int ERROR_NOT_FOUND = 404;// NOT FOUND METHODS
    public static final int ERROR_UNAUTHORIZED = 600; // Unauthorized Access
    public static final int ERROR_INVALID_TOKEN = 610; // Invalid token
}
