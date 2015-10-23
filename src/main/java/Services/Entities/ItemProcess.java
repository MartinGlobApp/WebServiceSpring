package Services.Entities;

import Data.DBContract;
import Services.Common.MyModel;

import javax.persistence.*;

/**
 * Created by martin-valdez on 20/10/15.
 */
@Entity
@Table(name = DBContract.ITEMPROCESS_TABLE, uniqueConstraints = {
        @UniqueConstraint(columnNames = {DBContract.PRODUCTS_COLUMN_ID, DBContract.STATION_COLUMN_ID})
})
public class ItemProcess implements MyModel{

    @Id
    @GeneratedValue
    private int itemProcessId;

    @Basic(optional = false)
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = DBContract.PRODUCTS_COLUMN_ID)
    private Product product;

    @Basic(optional = false)
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = DBContract.STATION_COLUMN_ID)
    private Station station;

    private int ordenInProcess;

    public int getItemProcessId() {
        return itemProcessId;
    }

    public void setItemProcessId(int itemProcessId) {
        this.itemProcessId = itemProcessId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public int getOrdenInProcess() {
        return ordenInProcess;
    }

    public void setOrdenInProcess(int ordenInProcess) {
        this.ordenInProcess = ordenInProcess;
    }

    @Override
    public int getId() {
        return getItemProcessId();
    }
}
