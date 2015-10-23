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
@Table(name = DBContract.PURCHASEORDER_TABLE)
public class PurchaseOrder implements MyModel{

    @Id
    @GeneratedValue
    private int purchaseOrderId;

    @ManyToOne
    @JoinColumn(name = DBContract.PRODUCTS_COLUMN_ID)
    private Product product;

    @ManyToOne
    @JoinColumn(name = DBContract.CART_COLUMN_ID)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = DBContract.ORDERSTATE_COLUMN_ID)
    private OrderState orderState;

    @OneToMany(mappedBy = "purchaseOrder")
    private List<Moment> momentList;

    private String customerName;
    private String detail;
    private Date starDate;
    private Date endDate;

    public int getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(int purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
        return getPurchaseOrderId();
    }
}
