package myfirstgame.shoppingbasket;

/**
 * Created by James on 22/11/2017.
 */

public class Item {

    private String name;
    private double price;
    private boolean buyOneGetOneFree;

    public Item(String name, Integer price, boolean buyOneGetOneFree) {
        this.name = name;
        this.price = price;
        this.buyOneGetOneFree = buyOneGetOneFree;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean getBuyOneGetOneFreeStatus() {
        return buyOneGetOneFree;
    }

    public void setBuyOneGetOneFreeStatus(boolean status) {
        this.buyOneGetOneFree = status;
    }

    public void setDiscountAmount(double discountAmount) {
        this.price -= (this.price*(discountAmount/100.0));
    }
}
