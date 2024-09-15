package CodeAlpha.Task_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Stock {
    String symbol;
    double price;
    int sharesOwned;

    Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
        this.sharesOwned = 0;
    }

    void buyShares(int shares) {
        sharesOwned += shares;
    }

    void sellShares(int shares) {
        sharesOwned = (shares <= sharesOwned) ? sharesOwned - shares : sharesOwned;
    }
}

class Portfolio {
    Map<String, Stock> stocks = new HashMap<>();

    void addStock(String symbol, double price) {
        stocks.put(symbol, new Stock(symbol, price));
    }

    void buyStock(String symbol, int shares) {
        if (stocks.containsKey(symbol)) stocks.get(symbol).buyShares(shares);
        else System.out.println("Stock not found.");
    }

    void sellStock(String symbol, int shares) {
        if (stocks.containsKey(symbol)) stocks.get(symbol).sellShares(shares);
        else System.out.println("Stock not found.");
    }

    void displayPortfolio() {
        stocks.forEach((symbol, stock) ->
                System.out.println("Stock: " + symbol + ", Shares: " + stock.sharesOwned + ", Price: $" + stock.price));
    }

    double getTotalValue() {
        return stocks.values().stream().mapToDouble(stock -> stock.price * stock.sharesOwned).sum();
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {
        Portfolio portfolio = new Portfolio();
        portfolio.addStock("AAPL", 150.0);
        portfolio.addStock("GOOGL", 2800.0);
        portfolio.addStock("AMZN", 3500.0);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Buy Stock\n2. Sell Stock\n3. View Portfolio\n4. Exit");
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.print("Enter stock symbol: ");
                    portfolio.buyStock(scanner.next().toUpperCase(), scanner.nextInt());
                }
                case 2 -> {
                    System.out.print("Enter stock symbol: ");
                    portfolio.sellStock(scanner.next().toUpperCase(), scanner.nextInt());
                }
                case 3 -> {
                    portfolio.displayPortfolio();
                    System.out.println("Total Value: $" + portfolio.getTotalValue());
                }
                case 4 -> running = false;
                default -> System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}
