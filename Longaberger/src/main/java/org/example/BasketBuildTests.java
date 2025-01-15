package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BasketBuildTests {

    @Test
    public void testDealerDiscount() {
        BasketBuild basket = new BasketBuild('C', "A1", 1, "IA");
        basket.calculate();
        assertEquals(9.38, basket.getTotalCost(), 0.01);
    }

    @Test
    public void testWalkInNoTax() {
        BasketBuild basket = new BasketBuild('W', "A2", 2, "IL");
        basket.calculate();
        assertEquals(65.22, basket.getTotalCost(), 0.01);
    }

    @Test
    public void testBusDiscountWithTax() {
        BasketBuild basket = new BasketBuild('K', "A3", 3, "MO");
        basket.calculate();
        assertEquals(30.79, basket.getTotalCost(), 0.01);
    }
}
