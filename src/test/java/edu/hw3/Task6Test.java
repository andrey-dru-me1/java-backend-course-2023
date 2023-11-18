package edu.hw3;

import edu.hw3.task6.DefaultStockMarket;
import edu.hw3.task6.Stock;
import edu.hw3.task6.StockMarket;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task6Test {

    @Test
    void testStockMarket() {
        StockMarket stockMarket = new DefaultStockMarket();
        stockMarket.add(new Stock(3));
        stockMarket.add(new Stock(5));
        stockMarket.add(new Stock(4));
        stockMarket.add(new Stock(2));
        stockMarket.remove(new Stock(5));
        assertThat(stockMarket.mostValuableStock()).isEqualTo(new Stock(4));
    }
}