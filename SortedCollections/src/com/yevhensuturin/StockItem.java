package com.yevhensuturin;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double prise;
    private int quantityStock = 0;

    public StockItem(String name, double prise) {
        this.name = name;
        this.prise = prise;
        this.quantityStock = 0;
    }

    public StockItem(String name, double prise, int quantityStock) {
        this.name = name;
        this.prise = prise;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrise() {
        return prise;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    public void setPrise(double prise) {
        if(prise > 0.0) {
            this.prise = prise;
        }
    }

    public void adjustStock(int quantityStock){
        int newQuantity = this.quantityStock + quantityStock;
        if (newQuantity >= 0 ){
            this.quantityStock = newQuantity;
        }
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals");
        if(this == obj){
            return true;
        }

        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }

        return this.name.equals(((StockItem) obj).getName());
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("Entering StockItem.CompareTo");
        if(this == o){
            return 0;
        }

        if(o != null){
            return this.name.compareTo(o.getName());
        }

        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + ": price "+this.prise;
    }
}
