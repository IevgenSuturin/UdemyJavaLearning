package com.yevhensuturin;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item){
        if(item != null){
            //check if we already have quantity for this item
            StockItem inStock = list.getOrDefault(item.getName(), item);
            //If there are already stocks on this item, adjust quantity
            if(inStock != item){
                item.addQuantityToStock(inStock);
            }

            list.put(item.getName(), item);
            return item.availableQuantity();
        }
        return 0;
    }

    public int reserveStock(String item, int quantity){
        StockItem inStock = list.get(item);

        if(inStock != null && quantity>0){
            return inStock.reserveItemInStock(quantity);
        }
        return 0;
    }

    public int unreserveStock(String item, int quantity){
        StockItem inStock = list.get(item);

        if(inStock != null && quantity>0){
            return inStock.unreserveItemInStock(quantity);
        }
        return 0;
    }

    public int sellStock(String item, int quantity){
         StockItem inStock = list.get(item);
         if (inStock != null && quantity > 0){
             return inStock.finaliseStock(quantity);
         }
         return 0;
    }

    public StockItem get(String key){
        return list.get(key);
    }

    public  Map<String, Double> priceList(){
        Map<String, Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> item:list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrise());
        }
        return Collections.unmodifiableMap(prices);
    }

    public Map<String, StockItem> Items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("\nStock List\n");

        double totalCost =0.0;
        for(Map.Entry<String, StockItem> item: list.entrySet()){
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrise() * stockItem.availableQuantity();
            stringBuilder.append(stockItem+". There are "+stockItem.availableQuantity()+" in stock. Value of items: "+ String.format("%.2f", itemValue) + "\n");
            totalCost += itemValue;
        }

        stringBuilder.append("Total stock value " + String.format("%.2f", totalCost));

        return stringBuilder.toString();
    }
}
