package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {
    @Id
    private String itemCode;
    private String description;
    private double unitPrice;
    private int qty;
    @OneToMany(mappedBy = "item")
    private List<OrderDetails> orderDetails = new ArrayList();


    public Item() {
    }

    public Item(String itemCode, String description, double unitPrice, int qty) {
        this.itemCode = itemCode;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    public Item(String itemCode, String description, double unitPrice, int qty, List<OrderDetails> orderDetails) {
        this.itemCode = itemCode;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qty = qty;
        this.orderDetails = orderDetails;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
