package Model;

import java.util.Vector;

public class Product {

    private String id;
    private String name;
    private int qty;
    private String type;
    private String rate;
    private double price;
    private String shipping;

    private static Vector product_list = new Vector();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    public String getShipping() {
        return shipping;
    }

    public static void setProduct_list(Product p) {
        product_list.addElement(p);
        System.out.println(p.getId()+" is added to list");
    }

    public static Vector getProduct_list() {
        return product_list;
    }

}
