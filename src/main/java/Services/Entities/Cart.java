package Services.Entities;

import Data.DBContract;
import Services.Common.MyModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by martin-valdez on 20/10/15.
 */
@Entity
@Table(name = DBContract.CART_TABLE)
public class Cart implements MyModel{

    @Id
    @GeneratedValue
    private int cartId;
    private String name;
    private String tabletMac;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTabletMac() {
        return tabletMac;
    }

    public void setTabletMac(String tabletMac) {
        this.tabletMac = tabletMac;
    }

    @Override
    public int getId() {
        return getCartId();
    }
}
