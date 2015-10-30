package Services.Entities;

import Data.DBContract;
import Services.Common.MyModel;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by martin-valdez on 20/10/15.
 */
@Entity
@Table(name = DBContract.PRODUCTIONORDER_TABLE)
public class ProductionOrder implements MyModel{

    @Id
    @GeneratedValue
    private int productionOrderId;

    @ManyToOne
    @JoinColumn(name = DBContract.PRODUCTS_COLUMN_ID)
    private Product product;

    @ManyToOne
    @JoinColumn(name = DBContract.CART_COLUMN_ID)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = DBContract.ORDERSTATE_COLUMN_ID)
    private OrderState orderState;

    @OneToMany(mappedBy = "productionOrder")
    private List<Moment> momentList;

    @OneToMany(mappedBy = "productionOrder")
    private List<ProductionOrderDocument> productionOrderDocumentList;

    private String customerName;
    private int purchaseOrderNumber;
    private String detail;
    private Date starDate;
    private Date endDate;

    public int getProductionOrderId() {
        return productionOrderId;
    }

    public void setProductionOrderId(int productionOrderId) {
        this.productionOrderId = productionOrderId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public List<Moment> getMomentList() {
        return momentList;
    }

    public void setMomentList(List<Moment> momentList) {
        this.momentList = momentList;
    }

    public List<ProductionOrderDocument> getProductionOrderDocumentList() {
        return productionOrderDocumentList;
    }

    public void setProductionOrderDocumentList(List<ProductionOrderDocument> productionOrderDocumentList) {
        this.productionOrderDocumentList = productionOrderDocumentList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(int purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getStarDate() {
        return starDate;
    }

    public void setStarDate(Date starDate) {
        this.starDate = starDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public int getId() {
        return getProductionOrderId();
    }
}
