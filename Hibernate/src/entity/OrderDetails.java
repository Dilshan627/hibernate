package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderDetails {
    @Id
    private String id;
    @ManyToOne
    private Orders orders;
    @ManyToOne
    private Item item;
    private double unitPrice;
    private int qty;

    public OrderDetails() {
    }

    public OrderDetails(String id, Orders orders, Item item, double unitPrice, int qty) {
        this.id = id;
        this.orders = orders;
        this.item = item;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }



    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

}
