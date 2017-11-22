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

    protected String getName() {
        return name;
    }

    protected double getPrice() {
        return price;
    }

    protected boolean getBuyOneGetOneFreeStatus() {
        return buyOneGetOneFree;
    }

    protected void setBuyOneGetOneFreeStatus(boolean status) {
        this.buyOneGetOneFree = status;
    }

    protected void setDiscountAmount(double discountAmount) {
        this.price -= (this.price*(discountAmount/100.0));
    }
}
