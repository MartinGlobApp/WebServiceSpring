package Services.Controllers;

import Data.DBContract;
import Data.MyResponse;
import Data.RequestContract;
import Services.Entities.Break;
import Services.Services.BreakService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by martin-valdez on 23/10/15.
 */
@RestController
public class BreakController{

    @Autowired
    private BreakService breakService;

    @RequestMapping(value = RequestContract.INSERT_BREAK, method = RequestMethod.POST)
    public MyResponse insertBreak(@RequestBody final Break newBreak) {
        return breakService.insert(newBreak);
    }

    @RequestMapping(RequestContract.GET_ONE_BREAK)
    public MyResponse getBreak(@RequestParam(value = DBContract.BREAK_COLUMN_ID, defaultValue = "0") final int breakId){
        return breakService.getOne(breakId);
    }

    @RequestMapping(RequestContract.GET_ALL_BREAK)
    public MyResponse getListAllBreaks(){
        return breakService.getListAll();
    }
}
