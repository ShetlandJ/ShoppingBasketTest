package myfirstgame.shoppingbasket;

import java.util.ArrayList;

/**
 * Created by James on 22/11/2017.
 */

public class Basket {

    ArrayList<Item> basketItems;

    public Basket() {
        this.basketItems = new ArrayList<>();
    }

    public int getItemCount() {
        return basketItems.size();
    }

    protected void addItemToBasket(Item item) {
        basketItems.add(item);
    }

    protected void removeItemFromBasket(Item item) {
        basketItems.remove(item);
    }

    public double buyOneGetOneFreeChecker() {

        ArrayList<Item> tempBuyOneGetOneFreeArray = new ArrayList<>();
        double total = 0;
        for( Item item : basketItems ){

            if(!tempBuyOneGetOneFreeArray.contains(item)) {
                if (item.getBuyOneGetOneFreeStatus()) {
                    tempBuyOneGetOneFreeArray.add(item);
                    total += item.getPrice();
                } else {
                    total += item.getPrice();
                }
            } else {
                tempBuyOneGetOneFreeArray.remove(item);
            }
        }
        return total;
    }

    public double getBasketTotal(Customer customer) {
        double total = buyOneGetOneFreeChecker();

        if (total > 20) {
            total -= (total * (10 / 100.0));
        }
        if (customer.loyaltyCardCheck()) {
            total -= (total * (2 / 100.0));
        }
        return total;
    }
}
