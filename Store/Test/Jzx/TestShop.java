package Jzx;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestShop {
    Vendor vendor;
    Product product;

    @BeforeEach
    void setUp() {
        vendor = new Vendor("(株)福豆腐");
        product = new Product(46000003321L, "おいしい豆腐");
        product.setCostPrice(50);
        product.setSalesPrice(60);
        vendor.setProduct(product);

        Product product2 = new Product(46000000000L, "chimpanzee豆腐");
        product2.setCostPrice(30);
        product2.setSalesPrice(50);
        vendor.setProduct(product2);
    }

    @Test
    @DisplayName("豆腐ベンダー会社 (株)福豆腐 を登録する")
    public void testRegisterTofuVendorCompany() {
        assertTrue(new Vendor("(株)福豆腐").equals(vendor));
        assertFalse(new Vendor("(株)おいしい豆腐").equals(vendor));
    }

    @Test
    @DisplayName("商品を登録する")
    public void testRegisterProduct() {
        product.setCostPrice(50);
        product.setSalesPrice(60);

        assertTrue(new Product(46000003321L, "おいしい豆腐").equals(product));

        assertEquals(50, product.getCostPrice());
        assertEquals(60, product.getSalesPrice());
    }

    @Test
    @DisplayName("豆腐ベンダーの商品名 おいしい豆腐（JAN 46000003321）を登録する")
    public void testRegisterProductToVendor() {
        Product product2 = new Product(46000003322L, "超おいしい豆腐");

        product2.setCostPrice(100);
        product2.setSalesPrice(120);

        vendor.setProduct(product);
        vendor.setProduct(product2);

        assertTrue(vendor.getProducts().contains(new Product(46000003321L, "おいしい豆腐")));
        assertFalse(vendor.getProducts().contains(new Product(463321L, "まずい豆腐")));

        assertTrue(vendor.getProducts().contains(new Product(46000003322L, "超おいしい豆腐")));
    }

    @Test
    @DisplayName("豆腐ベンダーから商品100丁5000円で調達する")
    public void testOrderProductFromVendor() {
        Store store = new Store();
        store.order(100, vendor.getProduct(46000003321L));
        assertEquals(100, store.getStock());
        assertEquals(store.getCapital() - (vendor.getProduct(46000003321L).getCostPrice() * 100), store.getCash());
        assertFalse(store.getCapital() - (vendor.getProduct(46000000000L).getCostPrice() * 100) == store.getCash());
    }


    @Test
    @DisplayName("Superチンパンジー店60円棚ラベルを準備する")
    public void aaa() {
        Store store = new Store();
//①代入　jan ,name, salesPrice
        //②値の比較
        //③印刷方法
        //④戻り値の比較
       // store.raberu(46000003321L,"おいしい豆腐",60);
       // assertEquals(46000003321L,



    }
}