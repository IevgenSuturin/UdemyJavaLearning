package com.yevhensuturin;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        list = new HashMap<>();
    }

    public int addStock(StockItem item){
        if(item != null){
            //check if we already have quantity for this item
            StockItem inStock = list.getOrDefault(item.getName(), item);
            //If there are already stocks on this item, adjust quantity
            if(inStock != item){
                item.adjustStock(inStock.quantityInStock());
            }

            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return 0;
    }

    public int sellStock(StockItem item, int quantity){
        StockItem inStock = list.getOrDefault(item.getName(), null);

        if(inStock != null && inStock.quantityInStock() >= quantity && quantity>0 ){
            inStock.adjustStock(-quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem get(String key){
        return list.get(key);
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
            double itemValue = stockItem.getPrise() * stockItem.quantityInStock();
            stringBuilder.append(stockItem+". There are "+stockItem.quantityInStock()+" in stock. Value of items: "+ itemValue + "\n");
            totalCost += itemValue;
        }

        stringBuilder.append("Total stock value " + totalCost);

        return stringBuilder.toString();
    }
}
