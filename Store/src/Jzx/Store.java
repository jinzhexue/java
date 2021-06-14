package Jzx;


public class Store {
    private int capital = 10000;
    private int stock;
    private int cash = capital;


    public void order(int stock, Product product){
        this.stock = this.stock + stock;
        this.cash = this.cash - (stock * product.getCostPrice());
    }
    public int getStock(){
        return stock;
    }
    public void setStock(int stock){
        this.stock = stock;
    }
    public int getCapital(){
        return capital;
    }
    public void setCapital(int capital){
        this.capital = capital;
    }
    public int getCash(){
        return cash;
    }
    public void setCash(){
        this.cash = cash;
    }





}
