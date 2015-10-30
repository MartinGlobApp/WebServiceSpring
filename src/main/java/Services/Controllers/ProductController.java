package Services.Controllers;

import Data.DBContract;
import Data.MyResponse;
import Data.RequestContract;
import Services.Entities.ItemProcess;
import Services.Entities.Product;
import Services.Entities.Station;
import Services.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by martin-valdez on 20/10/15.
 */

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(RequestContract.INSERT_PRODUCT)
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

//        product.setProcessList(list);

        return productService.insert(product);
    }


    @RequestMapping("/updateProduct")
    public MyResponse updateProduct(@RequestParam(value = DBContract.PRODUCTS_COLUMN_ID, defaultValue = "0") final int productId){
        Product product = (Product) productService.getOne(productId).getData();

        Station station = new Station();
        station.setStationId(1);
        station.setName("Estacion 1");
        station.setDescription("Corte");

        ItemProcess itemProcess = new ItemProcess();
        itemProcess.setStation(station);
        itemProcess.setProduct(product);
        itemProcess.setOrdenInProcess(1);
        List<ItemProcess> list = product.getProcessList();
        list.add(itemProcess);
        product.setProcessList(list);

        return productService.update(product);
    }

    @RequestMapping(RequestContract.GET_ONE_PRODUCT)
    public MyResponse getProduct(@RequestParam(value = DBContract.PRODUCTS_COLUMN_ID, defaultValue = "0") final int productId){
        return productService.getOne(productId);
    }

    @RequestMapping(RequestContract.GET_ALL_PRODUCT)
    public MyResponse getListAllProduct(){
        return productService.getListAll();
    }


}
