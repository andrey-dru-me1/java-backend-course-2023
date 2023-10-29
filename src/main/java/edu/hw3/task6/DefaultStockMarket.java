package edu.hw3.task6;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DefaultStockMarket implements StockMarket {
    private final PriorityQueue<Stock> stocks;

    public DefaultStockMarket() {
        this.stocks = new PriorityQueue<>(Comparator.comparingInt(Stock::cost).reversed());
    }

    @Override
    public void add(Stock stock) {
        stocks.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stocks.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stocks.peek();
    }
}
