package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day20_DependsOnMethods {
    /*
    TestNG'de tum @Test metodlari birbirinden bagimsiz olarak calisirlar. Eger metodlari bagimli hale getirmek istersek
    "dependsOnMethods" parametresi kullanilir. "dependsOnMethods" metodu bagimli oldugu @Test'i once calistirir. Eger o test
    pass olursa iki testi de calistirir. Eger bagimli test fail olursa bagimli @Test Ignore olur calismaz.
    (Burdaki ornekde, searchTest methodu homeTest methoduna bagimlidir
    searchTest den once homeTest calisir
    Eger homeTest basarili ise searchTest calisir.
    Eget homeTest basarisiz ise, searchTest IGNORE edilir)
     */
    @Test
    public void homeTest(){
        System.out.println("Home Test");
        Assert.assertTrue(false);
    }
    @Test(dependsOnMethods = "homeTest")
    public void searchTest(){
        System.out.println("Search Test");
    }
    @Test
    public void paymentTest(){
        System.out.println("Payment Test");
    }
}
