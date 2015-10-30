package Services.Controllers;

import Data.MyResponse;
import Data.RequestContract;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import Data.ResponseStates;
import Services.Entities.*;
import Services.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by martin-valdez on 19/10/15.
 */
@RestController
public class ServerController {

    DateFormat dateFormat = new SimpleDateFormat(RequestContract.SERVER_FORMAT_DATE);

    @Autowired
    private StationService stationService;

    @Autowired
    private WorkerService workerService;

    @Autowired
    private CartService cartService;

    @Autowired
    private BreakTypeService breakTypeService;

    @Autowired
    private BreakStateService breakStateService;

    @Autowired
    private OrderStateService orderStateService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductionOrderService purchaseOrderService;

    @RequestMapping("/")
    public String welcome() {
        return "Welcome Scarpatti API";
    }

    @RequestMapping(value = RequestContract.SERVER_GET_TIME)
    public String getTimeServer() {
        return dateFormat.format(Calendar.getInstance().getTime());
    }

    @RequestMapping(value = "/API/testToken")
    public MyResponse testToken(String token) {
        MyResponse response = new MyResponse();
        if(token != null){
            if(token.equals("qwerty987")){
                response.setCode(ResponseStates.DONE);
                response.setData(dateFormat.format(Calendar.getInstance().getTime()));
            }else{
                response.setCode(ResponseStates.ERROR_INVALID_TOKEN);
                response.setData("Invalid TOCKEN");
            }
        }else{
            response.setCode(ResponseStates.ERROR_UNAUTHORIZED);
            response.setData("Requires Authorization");
        }
        return response;
    }

    @RequestMapping(value = "/initialBd")
    public void initialBd() {

        Station station = new Station();
        station.setName("Estacion 1");
        station.setDescription("Corte");

        Station station2 = new Station();
        station2.setName("Estacion 2");
        station2.setDescription("Pegado");

        Station station3 = new Station();
        station3.setName("Estacion 3");
        station3.setDescription("Perforacion");

        Station station4 = new Station();
        station4.setName("Estacion 4");
        station4.setDescription("Armado");

        Station station5 = new Station();
        station5.setName("Estacion 5");
        station5.setDescription("Empaquetado");

        Station station6 = new Station();
        station6.setName("Estacion 6");
        station6.setDescription("Limpiado");

        Station station7 = new Station();
        station7.setName("Estacion 7");
        station7.setDescription("Preparando");

        station.setStationId((int) stationService.insert(station).getData());
        station2.setStationId((int) stationService.insert(station2).getData());
        station3.setStationId((int) stationService.insert(station3).getData());
        station4.setStationId((int) stationService.insert(station4).getData());
        station5.setStationId((int) stationService.insert(station5).getData());
        station6.setStationId((int) stationService.insert(station6).getData());
        station7.setStationId((int) stationService.insert(station7).getData());

        Worker worker = new Worker();
        worker.setName("Carlos");
        worker.setLastName("Miranda");

        Worker worker2 = new Worker();
        worker2.setName("Martin");
        worker2.setLastName("Valdez");

        Worker worker3 = new Worker();
        worker3.setName("Maximiliano");
        worker3.setLastName("Ruiz Nieto");

        Worker worker4 = new Worker();
        worker4.setName("Juan");
        worker4.setLastName("Octogonal");

        Worker worker5 = new Worker();
        worker5.setName("Tomas");
        worker5.setLastName("Contrera");

        Worker worker6 = new Worker();
        worker6.setName("Sergio");
        worker6.setLastName("Maldonado");

        worker.setWorkerId((int)workerService.insert(worker).getData());
        worker2.setWorkerId((int)workerService.insert(worker2).getData());
        worker3.setWorkerId((int)workerService.insert(worker3).getData());
        worker4.setWorkerId((int)workerService.insert(worker4).getData());
        worker5.setWorkerId((int)workerService.insert(worker5).getData());
        worker6.setWorkerId((int)workerService.insert(worker6).getData());

        Cart cart = new Cart();
        cart.setName("CARRO 1");
        cart.setTabletMac("21:58:AD:FR:ER:58");

        Cart cart2 = new Cart();
        cart2.setName("CARRO 2");
        cart2.setTabletMac("21:58:AD:FR:ER:59");

        Cart cart3 = new Cart();
        cart3.setName("CARRO 3");
        cart3.setTabletMac("21:58:AD:FR:ER:60");

        Cart cart4 = new Cart();
        cart4.setName("CARRO 4");
        cart4.setTabletMac("21:58:AD:FR:ER:61");

        Cart cart5 = new Cart();
        cart5.setName("CARRO 5");
        cart5.setTabletMac("21:58:AD:FR:ER:62");

        Cart cart6 = new Cart();
        cart6.setName("CARRO 6");
        cart6.setTabletMac("21:58:AD:FR:ER:63");

        Cart cart7 = new Cart();
        cart7.setName("CARRO 7");
        cart7.setTabletMac("21:58:AD:FR:ER:64");

        Cart cart8 = new Cart();
        cart8.setName("CARRO 8");
        cart8.setTabletMac("21:58:AD:FR:ER:65");

        Cart cart9 = new Cart();
        cart9.setName("CARRO 9");
        cart9.setTabletMac("21:58:AD:FR:ER:66");

        cart.setCartId((int)cartService.insert(cart).getData());
        cart2.setCartId((int)cartService.insert(cart2).getData());
        cart3.setCartId((int)cartService.insert(cart3).getData());
        cart4.setCartId((int)cartService.insert(cart4).getData());
        cart5.setCartId((int)cartService.insert(cart5).getData());
        cart6.setCartId((int)cartService.insert(cart6).getData());
        cart7.setCartId((int)cartService.insert(cart7).getData());
        cart8.setCartId((int)cartService.insert(cart8).getData());
        cart9.setCartId((int)cartService.insert(cart9).getData());

        BreakType breakType = new BreakType();
        breakType.setName("Falla maquinaria");

        BreakType breakType2 = new BreakType();
        breakType2.setName("Falla materia prima");

        BreakType breakType3 = new BreakType();
        breakType3.setName("Descanso");

        breakType.setBreakTypeId((int)breakTypeService.insert(breakType).getData());
        breakType2.setBreakTypeId((int)breakTypeService.insert(breakType2).getData());
        breakType3.setBreakTypeId((int) breakTypeService.insert(breakType3).getData());

        BreakState breakState = new BreakState();
        breakState.setName("En proceso");
        BreakState breakState2 = new BreakState();
        breakState2.setName("Finalizado");

        breakState.setBreakStateId((int) breakStateService.insert(breakState).getData());
        breakState2.setBreakStateId((int) breakStateService.insert(breakState2).getData());


        OrderState orderState = new OrderState();
        orderState.setName("Iniciada");

        OrderState orderState2 = new OrderState();
        orderState2.setName("En Proceso");

        OrderState orderState3 = new OrderState();
        orderState3.setName("Pausada");

        OrderState orderState4 = new OrderState();
        orderState4.setName("Finalizada");

        orderState.setOrderStateId((int) orderStateService.insert(orderState).getData());
        orderState2.setOrderStateId((int) orderStateService.insert(orderState2).getData());
        orderState3.setOrderStateId((int) orderStateService.insert(orderState3).getData());
        orderState4.setOrderStateId((int) orderStateService.insert(orderState4).getData());

        Product product = new Product();
        product.setName("Mesa");
        product.setDescription("Combinacion Roble-Blanco");

        ItemProcess itemProcess = new ItemProcess();
        itemProcess.setStation(station);
        itemProcess.setOrdenInProcess(1);
        itemProcess.setProduct(product);

        ItemProcess itemProcess2 = new ItemProcess();
        itemProcess2.setStation(station2);
        itemProcess2.setOrdenInProcess(2);
        itemProcess2.setProduct(product);

        ItemProcess itemProcess3 = new ItemProcess();
        itemProcess3.setStation(station3);
        itemProcess3.setOrdenInProcess(3);
        itemProcess3.setProduct(product);

        ItemProcess itemProcess4 = new ItemProcess();
        itemProcess4.setStation(station4);
        itemProcess4.setOrdenInProcess(4);
        itemProcess4.setProduct(product);

        ItemProcess itemProcess5 = new ItemProcess();
        itemProcess5.setStation(station5);
        itemProcess5.setOrdenInProcess(5);
        itemProcess5.setProduct(product);

        ItemProcess itemProcess6 = new ItemProcess();
        itemProcess6.setStation(station6);
        itemProcess6.setOrdenInProcess(6);
        itemProcess6.setProduct(product);

        ItemProcess itemProcess7 = new ItemProcess();
        itemProcess7.setStation(station7);
        itemProcess7.setOrdenInProcess(7);
        itemProcess7.setProduct(product);

        ArrayList<ItemProcess> listaItems = new ArrayList<>();
        listaItems.add(itemProcess);
        listaItems.add(itemProcess2);
        listaItems.add(itemProcess3);
        listaItems.add(itemProcess4);
        listaItems.add(itemProcess5);
//        listaItems.add(itemProcess6);
//        listaItems.add(itemProcess7);
        product.setProcessList(listaItems);

        product.setProductId((int)productService.insert(product).getData());

        ProductionOrder purchaseOrder = new ProductionOrder();
        purchaseOrder.setPurchaseOrderNumber(265);
        purchaseOrder.setProduct(product);
        purchaseOrder.setCart(cart4);
        purchaseOrder.setCustomerName("Taller Technologies");
        purchaseOrder.setOrderState(orderState);

        purchaseOrderService.insert(purchaseOrder);
    }
}
