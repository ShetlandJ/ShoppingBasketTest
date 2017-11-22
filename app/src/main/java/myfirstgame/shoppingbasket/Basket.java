package myfirstgame.shoppingbasket;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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

    public void addItemToBasket(Item item) {
        basketItems.add(item);
    }

    public void removeItemFromBasket(Item item) {
        basketItems.remove(item);
    }



    public double buyOneGetOneFreeChecker() {

        ArrayList<Item> tempBuyOneGetOneFreeArray = new ArrayList<>();
        double total = 0;
        for( Item item : basketItems ){

            if(!tempBuyOneGetOneFreeArray.contains(item) && (item.getBuyOneGetOneFreeStatus())) {
                tempBuyOneGetOneFreeArray.add(item);
                total += item.getPrice();
            } else {
                tempBuyOneGetOneFreeArray.remove(item);
            }
        }
        return total;
    }

    public int getBasketTotal(Customer customer) {
        int total = 0;
        for (Item item : this.basketItems) {
            total += item.getPrice();
        }
        if (total > 20) {
            total -= (total * (10 / 100.0));
        }
        if (customer.loyaltyCardCheck()) {
            total -= (total * (2 / 100.0));
        }
        return total;
    }
}
