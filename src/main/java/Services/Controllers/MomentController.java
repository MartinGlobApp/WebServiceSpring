package Services.Controllers;

import Data.DBContract;
import Data.MyResponse;
import Data.RequestContract;
import Services.Entities.Break;
import Services.Entities.Moment;
import Services.Services.MomentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by martin-valdez on 23/10/15.
 */
@RestController
public class MomentController {

    @Autowired
    private MomentService momentService;

    @RequestMapping(value = RequestContract.INSERT_MOMENT, method = RequestMethod.POST)
    public MyResponse insertMoment(@RequestBody final Moment newMoment) {
        return momentService.insert(newMoment);
    }

    @RequestMapping(RequestContract.UPDATE_MOMENT)
    public MyResponse updateMoment(@RequestBody final Moment moment){
        return momentService.update(moment);
    }

    @RequestMapping(RequestContract.GET_ONE_MOMENT)
    public MyResponse getMoment(@RequestParam(value = DBContract.MOMENT_COLUMN_ID, defaultValue = "0") final int momentId){
        return momentService.getOne(momentId);
    }

    @RequestMapping(RequestContract.GET_ALL_MOMENT)
    public MyResponse getListAllMoment(){
        return momentService.getListAll();
    }
}
