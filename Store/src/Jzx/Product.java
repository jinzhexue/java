package Jzx;


public class Product {
    String janName;
    long jan;
    private int costPrice;
    private int salesPrice;

    Product(long jan, String name){
        this.jan = jan;
        this.janName = name;
    }

    public void setCostPrice(int costPrice) {
        this.costPrice = costPrice;
    }

    public int getCostPrice() {
        return costPrice;
    }

    public void setSalesPrice(int salesPrice) {
        this.salesPrice = salesPrice;
    }

    public int getSalesPrice() {
        return salesPrice;
    }

    public boolean equals(Object object){
        Product p = (Product) object;
        return p.jan == jan && p.janName.equals(janName);
    }
}
