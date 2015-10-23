package Services.Controllers;

import Data.MyResponse;
import Services.Common.BasicService;
import Services.Entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * Created by martin-valdez on 19/10/15.
 */
@RestController
public class WorkerController {

    @Autowired
    @Qualifier("workerService")
    private BasicService workerService;

    @RequestMapping(value = "/insert")
    public MyResponse insertWorker(@RequestParam(value = "name", defaultValue = "hola") String name,
                                   @RequestParam(value = "lastName", defaultValue = "hola") String lastName) {
        Worker worker = new Worker();
        worker.setName(name);
        worker.setLastName(lastName);
        return workerService.insert(worker);
    }

    @RequestMapping(value = "/insertWorker", method = RequestMethod.POST)
    public MyResponse insertWorker(@RequestBody Worker worker) {
        return workerService.insert(worker);
    }

    @RequestMapping("/getWorker")
    public MyResponse getWorker(@RequestParam(value = "workerId", defaultValue = "0") int workerId){
        return workerService.getOne(workerId);
    }

    @RequestMapping("/getListAllWorkers")
    public MyResponse getListAllWorkers(){
        return workerService.getListAll();
    }
}
