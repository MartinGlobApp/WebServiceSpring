package Services.Controllers;

import Data.DBContract;
import Data.MyResponse;
import Data.RequestContract;
import Services.Entities.Worker;
import Services.Services.WorkerService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by martin-valdez on 19/10/15.
 */
@RestController
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @RequestMapping("/insertWorkerGet")
    public MyResponse insertWorker(@RequestParam(value = "name", defaultValue = "NULL") final String name,
                                   @RequestParam(value = "lastName", defaultValue = "NULL") final String lastName) {
        Worker worker = new Worker();
        worker.setName(name);
        worker.setLastName(lastName);
        return workerService.insert(worker);
    }

    @RequestMapping(value = RequestContract.INSERT_WORKER, method = RequestMethod.POST)
    public MyResponse insertWorker(@RequestBody final Worker newWorker) {
        return workerService.insert(newWorker);
    }

    @RequestMapping(RequestContract.GET_ONE_WORKER)
    public MyResponse getWorker(@RequestParam(value = DBContract.WORKER_COLUMN_ID, defaultValue = "0") final int workerId){
        return workerService.getOne(workerId);
    }

    @RequestMapping(RequestContract.GET_ALL_WORKER)
    public MyResponse getListAllWorkers(){
        return workerService.getListAll();
    }
}
