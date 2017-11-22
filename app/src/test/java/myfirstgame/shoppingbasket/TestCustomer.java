package myfirstgame.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by James on 22/11/2017.
 */

public class TestCustomer {

    Customer customer;
    Basket basket;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("James", false, basket);
    }

    @Test
    public void customerHasName() throws Exception {
        assertEquals("James", customer.getName());
    }

    @Test
    public void customerCanHaveLoyaltyCard__true() throws Exception {
        Customer customer = new Customer("James", true, basket);
        assertEquals(true, customer.loyaltyCardCheck());
    }

    @Test
    public void customerCanHaveLoyaltyCard__false() throws Exception {
        assertEquals(false, customer.loyaltyCardCheck());
    }

}
