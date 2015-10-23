package Services.Controllers;

import Data.MyResponse;
import Data.RequestContract;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import Data.ResponseStates;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by martin-valdez on 19/10/15.
 */
@RestController
public class ServerController {

    DateFormat dateFormat = new SimpleDateFormat(RequestContract.SERVER_FORMAT_DATE);

    @RequestMapping("/")
    public String welcome() {
        return "Welcome Scarpatti API";
    }

    @RequestMapping(value = RequestContract.SERVER_GET_TIME)
    public String getTimeServer() {
        return dateFormat.format(Calendar.getInstance().getTime());
    }

    @RequestMapping(value = "/API/testToken")
    public MyResponse testToken(String token) {
        MyResponse response = new MyResponse();
        if(token != null){
            if(token.equals("qwerty987")){
                response.setCode(ResponseStates.DONE);
                response.setData(dateFormat.format(Calendar.getInstance().getTime()));
            }else{
                response.setCode(ResponseStates.ERROR_INVALID_TOKEN);
                response.setData("Invalid TOCKEN");
            }
        }else{
            response.setCode(ResponseStates.ERROR_UNAUTHORIZED);
            response.setData("Requires Authorization");
        }
        return response;
    }
}
