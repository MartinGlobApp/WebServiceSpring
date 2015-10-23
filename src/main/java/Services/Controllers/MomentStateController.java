package Services.Controllers;

import Data.DBContract;
import Data.MyResponse;
import Data.RequestContract;
import Services.Entities.MomentState;
import Services.Services.MomentStateService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by martin-valdez on 23/10/15.
 */
@RestController
public class MomentStateController {

    @Autowired
    private MomentStateService momentStateService;

    @RequestMapping(value = RequestContract.INSERT_MOMENTSTATE, method = RequestMethod.POST)
    public MyResponse insertMomentState(@RequestBody final MomentState newMomentState) {
        return momentStateService.insert(newMomentState);
    }

    @RequestMapping(RequestContract.GET_ONE_MOMENTSTATE)
    public MyResponse getMomentState(@RequestParam(value = DBContract.MOMENTSTATE_COLUMN_ID, defaultValue = "0") final int momentStateId){
        return momentStateService.getOne(momentStateId);
    }

    @RequestMapping(RequestContract.GET_ALL_MOMENTSTATE)
    public MyResponse getListAllMomentState(){
        return momentStateService.getListAll();
    }
}
