package com.yevhensuturin;

import java.util.Map;

public class SortedCollectionsMain {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.1, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.5, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.5, 200);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.5, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.4, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        for (String key: stockList.Items().keySet()){
            System.out.println(key);
        }

        Basket yevhensBasket = new Basket("Yevhen");
        sellItem(yevhensBasket, "car", 1);
        System.out.println(yevhensBasket);

        sellItem(yevhensBasket, "car", 1);
        System.out.println(yevhensBasket);

        if(sellItem(yevhensBasket, "car", 1) != 1){
            System.out.println("There are no cars in the stock!");
        }

        sellItem(yevhensBasket, "spanner", 1);
//        System.out.println(yevhensBasket);

        sellItem(yevhensBasket, "juice", 4);
        sellItem(yevhensBasket, "cup", 12);
        sellItem(yevhensBasket, "bread", 1);
//        System.out.println(yevhensBasket);
//        System.out.println(stockList);

        Basket basket = new Basket("customer");
        sellItem(basket, "cup", 100);
        sellItem(basket, "juice", 5);
        sellItem(basket, "cup", 1);
        System.out.println(basket);

        removeItem(yevhensBasket, "car", 1);
        removeItem(yevhensBasket, "cup", 9);
        removeItem(yevhensBasket, "car", 1);
        System.out.println("Cars removed: " + removeItem(yevhensBasket, "car", 1));
        System.out.println(yevhensBasket);



        for (Map.Entry<String, Double> price: stockList.priceList().entrySet()) {
            System.out.println(price.getKey() + " costs " + price.getValue());
        }


    }

    public static int sellItem(Basket basket, String item, int quantity){
        //retrieve the item from the stock list
        StockItem stockItem = stockList.get(item);
        if (stockItem == null){
            System.out.println("We don't sell " + item);
            return 0;
        }

        if(stockList.reserveStock(item, quantity) !=0 ){
            return basket.addToBasket(stockItem, quantity);
        }

        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity){
        //retrieve the item from the stock list
        StockItem stockItem = stockList.get(item);
        if (stockItem == null){
            System.out.println("We don't sell " + item);
            return 0;
        }

        if(basket.removeFromBasket(stockItem, quantity) == quantity ){
            return stockList.unreserveStock(item, quantity);
        }

        return 0;
    }

    public static void checkOut(Basket basket){
        for(Map.Entry<StockItem, Integer> item: basket.Items().entrySet()){
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }
}
