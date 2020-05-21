package com.yevhensuturin;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public int addToBasket(StockItem item, int quantity){
        if(item != null && quantity>0){
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public Map<StockItem, Integer> Items(){
        return Collections.unmodifiableMap(this.list);
    }

    public void clearBasket(){
        list.clear();
    }

    public int removeFromBasket(StockItem item, int quantity){
        if(item != null && quantity > 0) {
            int inBasket = list.getOrDefault(item, 0);
            int newQuantity = inBasket - quantity;

            if (newQuantity > 0) {
                list.put(item, newQuantity);
                return quantity;
            } else if (newQuantity == 0) {
                list.remove(item);
                return quantity;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\nShopping basket " + name + " contains "+list.size() + ((list.size()==1)?" item\n":" items\n"));
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item: list.entrySet() ) {
            s.append(item.getKey() + ". " + item.getValue() + " purchased\n");
            totalCost += item.getKey().getPrise() * item.getValue();
        }
        s.append("Totoal cost " + totalCost);
        return s.toString();
    }
}
