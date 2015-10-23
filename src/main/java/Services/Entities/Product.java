package Services.Entities;

import Data.DBContract;
import Services.Common.MyModel;

import javax.persistence.*;
import java.util.List;

/**
 * Created by martin-valdez on 20/10/15.
 */
@Entity
@Table(name = DBContract.PRODUCTS_TABLE)
public class Product implements MyModel{

    @Id
    @GeneratedValue
    private int productId;
    private String name;
    private String description;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<ItemProcess> processList;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ItemProcess> getProcessList() {
        return processList;
    }

    public void setProcessList(List<ItemProcess> processList) {
        this.processList = processList;
    }

    @Override
    public int getId() {
        return getProductId();
    }
}
