package myfirstgame.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by James on 22/11/2017.
 */

public class TestItem {

    Item item;

    @Before
    public void setUp() throws Exception {
        item = new Item("Turnip", 2, false);
    }

    @Test
    public void canGetName() throws Exception {
        String itemName = item.getName();

        assertEquals("Turnip", itemName);
    }

    @Test
    public void canGetPrice() throws Exception {
        double itemPrice = item.getPrice();
        assertEquals(2, itemPrice, 0.);
    }

    @Test
    public void canCheckBuyOneGetOneFreeStatus__true() throws Exception {
        item = new Item("Pasta Sauce", 2, true);
        boolean buyOneGetOneFreeStatus = item.getBuyOneGetOneFreeStatus();
        assertEquals(true, buyOneGetOneFreeStatus);
    }

    @Test
    public void canCheckBuyOneGetOneFreeStatus__false() throws Exception {
        boolean buyOneGetOneFreeStatus = item.getBuyOneGetOneFreeStatus();
        assertEquals(false, buyOneGetOneFreeStatus);
    }

    @Test
    public void canChangeBuyOneGetOneFreeStatus() throws Exception {
        item.setBuyOneGetOneFreeStatus(true);
        assertEquals(true, item.getBuyOneGetOneFreeStatus());
    }

    @Test
    public void itemCanBeDiscountedByPassedAmount() throws Exception {
        Item testItem1 = new Item("BBQ", 100, false);
        Item testItem2 = new Item("Bottle of Wine", 10, false);

        testItem1.setDiscountAmount(50);
        testItem2.setDiscountAmount(10);

        double item1Price = testItem1.getPrice();
        double item2Price = testItem2.getPrice();
        assertEquals(50.0, item1Price, 0.1);
        assertEquals(9.0, item2Price, 0.1);
    }

}
