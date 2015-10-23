package Services.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by martin-valdez on 19/10/15.
 */
@RestController
public class ServerController {

    DateFormat dateFormat = new SimpleDateFormat("dd//MM/yyyy HH:mm:ss");

    @RequestMapping("/getTimeServer")
    public String getTimeServer() {
        return dateFormat.format(Calendar.getInstance().getTime());
    }
}
