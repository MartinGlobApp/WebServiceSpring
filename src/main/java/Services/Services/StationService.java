package Services.Services;

import Services.Common.BasicRepository;
import Services.Common.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by martin-valdez on 20/10/15.
 */
@Service(value = "stationService")
public class StationService extends BasicService{

    @Autowired
    @Qualifier("stationRepository")
    private BasicRepository stationRepository;

}
