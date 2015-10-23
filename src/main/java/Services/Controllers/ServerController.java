package Services.Controllers;

import Data.RequestContract;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by martin-valdez on 19/10/15.
 */
@RestController
public class ServerController {

    DateFormat dateFormat = new SimpleDateFormat(RequestContract.SERVER_FORMAT_DATE);

    @RequestMapping(value = RequestContract.SERVER_GET_TIME)
    public String getTimeServer() {
        return dateFormat.format(Calendar.getInstance().getTime());
    }
}
