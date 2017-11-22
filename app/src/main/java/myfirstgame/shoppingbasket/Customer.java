package myfirstgame.shoppingbasket;

/**
 * Created by James on 22/11/2017.
 */

public class Customer {

    private String name;
    private boolean hasLoyaltyCard;
    private Basket customerBasket;

    public Customer(String name, boolean hasLoyaltyCard, Basket customerBasket) {
        this.name = name;
        this.hasLoyaltyCard = hasLoyaltyCard;
        this.customerBasket = customerBasket;
    }

    public String getName() {
        return name;
    }

    public boolean loyaltyCardCheck() {
        return (hasLoyaltyCard);
    }
}
    
 
