package Services.Controllers;

import Data.MyResponse;
import Services.Common.BasicService;
import Services.Entities.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by martin-valdez on 22/10/15.
 */
@RestController
public class StationController {

    @Autowired
    @Qualifier("stationService")
    private BasicService stationService;

    @RequestMapping(value = "/insertStation")
    public MyResponse insertStation(@RequestParam(value = "name", defaultValue = "hola") String name,
                                   @RequestParam(value = "description", defaultValue = "hola") String description) {
        Station station = new Station();
        station.setName(name);
        station.setDescription(description);
        return stationService.insert(station);
    }

    @RequestMapping("/getStation")
    public MyResponse getStation(@RequestParam(value = "stationId", defaultValue = "0") int stationId){
        return stationService.getOne(stationId);
    }

    @RequestMapping("/getListAllStations")
    public MyResponse getListAllStations(){
        return stationService.getListAll();
    }

}
