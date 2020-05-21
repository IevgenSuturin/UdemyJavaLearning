package com.yevhensuturin;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double prise;
    private int quantityInStock = 0;
    private int reservedStock = 0;

    public StockItem(String name, double prise) {
        this.name = name;
        this.prise = prise;
        this.quantityInStock = 0;
        this.reservedStock = 0;
    }

    public StockItem(String name, double prise, int quantityInStock) {
        this(name, prise);
        this.quantityInStock = quantityInStock;
    }

    public String getName() {
        return name;
    }

    public double getPrise() {
        return prise;
    }

    public int availableQuantity() {
        return quantityInStock - reservedStock;
    }

    public int reservedInStock() {
        return reservedStock;
    }

    public void setPrise(double prise) {
        if(prise > 0.0) {
            this.prise = prise;
        }
    }

    public int reserveItemInStock(int quantity){
        if ( quantity <= availableQuantity()){
            reservedStock += quantity;
            return quantity;
        }
        return 0;
    }

    public int unreserveItemInStock(int quantity){
        if(quantity <= reservedStock){
            reservedStock -= quantity;
            return quantity;
        }
        return 0;
    }

    public void addQuantityToStock(StockItem item){
        this.quantityInStock += item.availableQuantity();
        this.reservedStock += item.reservedInStock();
    }

    public void adjustStock(){
        this.quantityInStock -= reservedStock;
    }

    public int finaliseStock(int quantity){
        if( quantity >= reservedStock ) {
            quantityInStock -= quantity;
            reservedStock -= quantity;
            return quantity;
        }
        return 0;
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
//        System.out.println("Entering StockItem.CompareTo");
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
        return this.name + ": price "+this.prise + ". Reserved: " + this.reservedStock;
    }
}
