package myfirstgame.shoppingbasket;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

/**
 * Created by James on 22/11/2017.
 */

public class TestBasket {

    Basket basket;
    Item item1;
    Item item2;
    Item item3;
    Item item4;
    Item item5;
    Customer customer1;
    Customer customer2;

    @Before
    public void setUp() throws Exception {
        item1 = new Item("Grapes", 3, false);
        item2 = new Item("Ice Cubes", 1, false);
        item3 = new Item("Pizza", 5, false);
        item4 = new Item("BBQ", 100, false);
        item5 = new Item("Wine", 10, true);
        basket = new Basket();
        customer1 = new Customer("James", false, basket);
        customer2 = new Customer("Brian", true, basket);
    }

    @Test
    public void basketInitialLengthIsZero() throws Exception {
        int basketSize = basket.getItemCount();
        assertEquals(0, basketSize);
    }

    @Test
    public void canAddItemToBasket() throws Exception {
        basket.addItemToBasket(item1);
        int basketSize = basket.getItemCount();
        assertEquals(1, basketSize);
    }

    @Test
    public void canRemoveItemFromBasket() throws Exception {
        basket.addItemToBasket(item1);
        basket.addItemToBasket(item2);
        basket.addItemToBasket(item3);
        basket.addItemToBasket(item1);
        basket.removeItemFromBasket(item1);

        int basketSize = basket.getItemCount();
        assertEquals(3, basketSize);
    }

    @Test
    public void canGetBasketTotal() throws Exception {

        basket.addItemToBasket(item1);
        basket.addItemToBasket(item2);
        basket.addItemToBasket(item3);

        double basketTotal = basket.getBasketTotal(customer1);
        assertEquals(9, basketTotal, 0.1);
    }

    @Test
    public void basketIsDiscountedAfterCostIs20OrGreater() throws Exception {
        basket.addItemToBasket(item4);

        double basketTotal = basket.getBasketTotal(customer1);
        assertEquals(90, basketTotal, 0.1);
    }

    @Test
    public void customerHasLoyaltyDiscount__true() throws Exception {
        basket.addItemToBasket(item4);

        double basketTotal = basket.getBasketTotal(customer2);
        assertEquals(88.2, basketTotal, 0.1);
    }

    @Test
    public void customerHasLoyaltyDiscount__false() throws Exception {
        basket.addItemToBasket(item4);

        double basketTotal = basket.getBasketTotal(customer1);
        assertEquals(90, basketTotal, 0.1);
    }

    @Test
    public void canApplyBuyOneGetOneFree__true() throws Exception {
        basket.addItemToBasket(item5);
        basket.addItemToBasket(item5);
        basket.addItemToBasket(item4);
        basket.addItemToBasket(item5);


        assertEquals(120.0, basket.buyOneGetOneFreeChecker(), 0.1);
    }

    @Test
    public void canApplyBuyOneGetOneFree__false() throws Exception {
        basket.addItemToBasket(item1);
        basket.addItemToBasket(item1);

        assertEquals(6.0, basket.buyOneGetOneFreeChecker(), 0.1);
    }

    @Test
    public void canApplyBuyOneGetOneFree__two_items() throws Exception {
        basket.addItemToBasket(item1);
        basket.addItemToBasket(item2);
        basket.addItemToBasket(item5);
        basket.addItemToBasket(item5);

        assertEquals(14.0, basket.buyOneGetOneFreeChecker(), 0.1);
    }

    @Test
    public void canApplyBuyOneGetOneFree__four_items() throws Exception {
        basket.addItemToBasket(item1); // price 5
        basket.addItemToBasket(item2); // price 1
        basket.addItemToBasket(item5); // price 10
        basket.addItemToBasket(item5); // price 10 (price amount removed thanks to BOGOF)
        basket.addItemToBasket(item5); // price 10
        basket.addItemToBasket(item5); // price 10 (price amount removed thanks to BOGOF)

        assertEquals(24.0, basket.buyOneGetOneFreeChecker(), 0.1);
    }

    @Test
    public void canApplyBuyOneGetOneFree__four_items__and_customer_is_loyal() throws Exception {
        basket.addItemToBasket(item1); // price 5
        basket.addItemToBasket(item2); // price 1
        basket.addItemToBasket(item5); // price 10
        basket.addItemToBasket(item5); // price 10 (price amount removed thanks to BOGOF)
        basket.addItemToBasket(item5); // price 10
        basket.addItemToBasket(item5); // price 10 (price amount removed thanks to BOGOF)

        assertEquals(21.16, basket.getBasketTotal(customer2), 0.1);
    }

    @Test
    public void buyOneGetOneFreeIsCountedInBasketTotals() throws Exception {
        basket.addItemToBasket(item5);
        basket.addItemToBasket(item5);

        double basketTotal = basket.getBasketTotal(customer1);
        assertEquals(10, basketTotal, 0.1);
    }
}
