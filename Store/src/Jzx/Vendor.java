package Jzx;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vendor {
    private String name;
    private List<Product>  products = new ArrayList<Product>();

    Vendor(String name){
        this.name = name;
    }

    public boolean equals(Object object){
        Vendor v = (Vendor) object;
        return v.name.equals(name);
    }

    void setProduct(Product product){
        products.add(product);
//        product.jan = jan;
//        product.janName = janName;
    }

    List<Product> getProducts(){
        return products;
    }

    Product getProduct(Long jan){
        Product p = null;
        for(Product product : products) {
            p = product.jan == jan ? product : null;
            if(Objects.nonNull(p)) {
                break;
            }
        }
        return p;
    }
}
