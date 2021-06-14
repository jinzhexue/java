package shop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestShop {
    @Test
    public void testRegisterTofuVendorCompany() {
        Vendor vendor = new Vendor("(株)福豆腐");

        assertTrue(new Vendor("(株)福豆腐").equals(vendor));
        assertFalse(new Vendor("(株)おいしい豆腐").equals(vendor));
    }
}
