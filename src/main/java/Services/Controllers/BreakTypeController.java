package Services.Controllers;

import Data.DBContract;
import Data.MyResponse;
import Data.RequestContract;
import Services.Entities.BreakType;
import Services.Services.BreakTypeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by martin-valdez on 23/10/15.
 */
@RestController
public class BreakTypeController {

    @Autowired
    private BreakTypeService breakTypeService;

    @RequestMapping(value = RequestContract.INSERT_BREAKTYPE, method = RequestMethod.POST)
    public MyResponse insertBreakType(@RequestBody final BreakType newBreakType) {
        return breakTypeService.insert(newBreakType);
    }

    @RequestMapping(RequestContract.GET_ONE_BREAKTYPE)
    public MyResponse getBreakType(@RequestParam(value = DBContract.BREAKTYPE_COLUMN_ID, defaultValue = "0") final int breakTypeId){
        return breakTypeService.getOne(breakTypeId);
    }

    @RequestMapping(RequestContract.GET_ALL_BREAKTYPE)
    public MyResponse getListAllBreakTypes(){
        return breakTypeService.getListAll();
    }
}
