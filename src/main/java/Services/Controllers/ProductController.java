package Services.Controllers;

import Data.MyResponse;
import Services.Common.BasicService;
import Services.Entities.ItemProcess;
import Services.Entities.Product;
import Services.Entities.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by martin-valdez on 20/10/15.
 */

@RestController
public class ProductController {

    @Autowired
    @Qualifier("productService")
    private BasicService productService;

    @RequestMapping("/insertProduct")
    public MyResponse insertProduct(){

        ArrayList<ItemProcess> list = new ArrayList<>();

        Product product = new Product();
        //product.setProductId(1);
        product.setName("Escritorio");
        product.setDescription("Modelo 98");

        Station station = new Station();
        //station.setStationId(1);
        station.setName("Estacion 1");
        station.setDescription("Corte");

        Station station2 = new Station();
        //station2.setStationId(2);
        station2.setName("Estacion 2");
        station2.setDescription("Pegado");

        ItemProcess itemProcess = new ItemProcess();
        itemProcess.setStation(station);
        itemProcess.setProduct(product);
        itemProcess.setOrdenInProcess(2);

        ItemProcess itemProcess2 = new ItemProcess();
        itemProcess2.setStation(station2);
        itemProcess2.setProduct(product);
        itemProcess2.setOrdenInProcess(1);

        list.add(itemProcess);
        list.add(itemProcess2);

        product.setProcessList(list);

        return productService.insert(product);
    }

    @RequestMapping("/getProduct")
    public MyResponse getProduct(@RequestParam(value = "productId", defaultValue = "0") int productId){
        return productService.getOne(productId);
    }

    @RequestMapping("/getListAllProduct")
    public MyResponse getListAllProduct(){
        return productService.getListAll();
    }
}
