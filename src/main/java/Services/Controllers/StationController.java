package Services.Controllers;

import Data.DBContract;
import Data.MyResponse;
import Data.RequestContract;
import Services.Entities.Station;
import Services.Services.StationService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by martin-valdez on 22/10/15.
 */
@RestController
public class StationController {

    @Autowired
    private StationService stationService;

    @RequestMapping("/insertStationGet")
    public MyResponse insertStation(@RequestParam(value = "name", defaultValue = "hola") final String name,
                                   @RequestParam(value = "description", defaultValue = "hola") final String description) {
        Station station = new Station();
        station.setName(name);
        station.setDescription(description);
        return stationService.insert(station);
    }

    @RequestMapping(value = RequestContract.INSERT_STATION, method = RequestMethod.POST)
    public MyResponse insertStation(@RequestBody final Station newStation) {
        return stationService.insert(newStation);
    }

    @RequestMapping(RequestContract.GET_ONE_STATION)
    public MyResponse getStation(@RequestParam(value = DBContract.STATION_COLUMN_ID, defaultValue = "0") final int stationId){
        return stationService.getOne(stationId);
    }

    @RequestMapping(RequestContract.GET_ALL_STATION)
    public MyResponse getListAllStations(){
        return stationService.getListAll();
    }

}
