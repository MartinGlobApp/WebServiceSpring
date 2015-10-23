package Services.Controllers;

import Data.DBContract;
import Data.MyResponse;
import Data.RequestContract;
import Services.Entities.BreakState;
import Services.Services.BreakStateService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by martin-valdez on 23/10/15.
 */
@RestController
public class BreakStateController {

    @Autowired
    private BreakStateService breakStateService;

    @RequestMapping(value = RequestContract.INSERT_BREAKSTATE, method = RequestMethod.POST)
    public MyResponse insertBreakState(@RequestBody final BreakState newBreakState) {
        return breakStateService.insert(newBreakState);
    }

    @RequestMapping(RequestContract.GET_ONE_BREAKSTATE)
    public MyResponse getBreakState(@RequestParam(value = DBContract.BREAKSTATES_COLUMN_ID, defaultValue = "0") final int breakStateId){
        return breakStateService.getOne(breakStateId);
    }

    @RequestMapping(RequestContract.GET_ALL_BREAKSTATE)
    public MyResponse getListAllBreakStates(){
        return breakStateService.getListAll();
    }
}
