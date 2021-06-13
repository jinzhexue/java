package Jzx;

public class CoinCase {
    private int Yen500 = 0;
    private int Yen100 = 0;
    private int Yen50 = 0;
    private int Yen10 = 0;

    private int Yen5 = 0;
    private int Yen1 = 0;

    public void AddCoins(int kind, int count) {
        switch (kind){
        case 500:
        Yen500 += count;
        break;
        case 100:
        Yen100 += count;
        break;
        case 50:
        Yen50 += count;
        break;
        case 10:
        Yen10 += count;
        break;
        case 5:
        Yen5 += count;
        break;
        case 1:
        Yen1 += count;
        break;
    }
}
public  int GetCount(int kind) {
    switch (kind) {
        case 500:
            return Yen500;
        case 100:
            return Yen100;
        case 50:
            return Yen50;
        case 10:
            return Yen10;
        case 5:
            return Yen5;
        case 1:
            return Yen1;
    }
    return 0;
}
public int GetAmount() {
    return (Yen500 * 500) + (Yen100 * 100)
            + (Yen50 * 50) + (Yen10 * 10) +
            (Yen5 * 5) + (Yen1 * 1);
}


}








    }
    public void GetCoins(int type,int sum) {
        this.moneytype=type;
        this.count=sum


    }
    public void GetAmount() {

    }
    public static void main (String[] args) {
        CoinCase c =new CoinCase();
        c.AddCoins();

    }





}
