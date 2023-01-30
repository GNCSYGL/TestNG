package techproed.tests.excelautomation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Day23_ExcelLogin {

    BlueRentalHomePage blueRentalHomePage = new BlueRentalHomePage();
    BlueRentalLoginPage blueRentalLoginPage = new BlueRentalLoginPage();
    ExcelUtils excelUtils;
    List<Map<String, String>> excelDatalari;

    //Bu metod login sayfasina gitmek icin kullanilacak
    public void login(){
//        Sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
//        home page logine tikla
        blueRentalHomePage= new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();

//        ------SADECE ILK GIRIS---------
//        loginLink butonu sadece ilk girisde sayfada gorunur
//        ikinci ve ucunci girislerde sayfada gorunmeyeceginden NOSUCHELEMENTEXCEPTION alinir
//        Biz bu exception u try catch kullanarak yakalariz ve test cases calismaya devam eder
        try {
            blueRentalHomePage.loginLink.click();
            ReusableMethods.waitFor(1);// 1 saniye bekle
//        LOGIN SAYFASINDAYIZ
        }catch (Exception e){
        }
//      -------------SONRAKI GIRISLER------
        try{
//            kullanici ID ye tikla      --->>> try catch
            blueRentalHomePage.userID.click();
            ReusableMethods.waitFor(1);
//            Logout linkine tikla       --->>> try catch
            blueRentalHomePage.logOutLink.click();
            ReusableMethods.waitFor(1);
//            OK e tikla                --->>> try catch
            blueRentalHomePage.OK.click();
            ReusableMethods.waitFor(1);
//            home page logine tikla    --->>> try catch
            blueRentalHomePage.loginLink.click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){
        }


    }
    @Test
    public void customerLogin() throws IOException {
        String path="./src/test/java/resources/mysmoketestdata.xlsx";
//      ./ --> bu sembol ONCEKI TUM DOSYALARI ICER. RELATIVE PATH
        String sayfa = "customer_info"; //--> Excel dosyasindaki sayfanin adini aliriz.
//       DATALARI EXCEL UTILS METODLARI KULLANARAK BURAYA ALACAGIZ.
        excelUtils = new ExcelUtils(path, sayfa);
//       excel datalarini getDataList metodu ile cekelim.
        excelDatalari = excelUtils.getDataList();
//       LOOP KULLANARAK DATALARI TEK TEK TEST CASE'DE KULLANALIM.
        for (Map<String, String> data : excelDatalari){
            login();//Her loop'ta Login sayfasina goturecek
//       kullanici adini gir
            blueRentalLoginPage.emailBox.sendKeys(data.get("username"));
//       kullanici sifresi gir
            blueRentalLoginPage.passwordBox.sendKeys(data.get("password"));
//       login butonuna tikla
            ReusableMethods.waitFor(1);
            blueRentalLoginPage.loginButton.click();
            ReusableMethods.waitFor(1);
//       giris isleminin basarili oldugunu gostermek icin assertion yaptik
            ReusableMethods.verifyElementDisplayed(blueRentalHomePage.userID);
            ReusableMethods.waitFor(1);
//       her bir giristen sonra ekran goruntusu aldik
            ReusableMethods.getScreenshot("EkranGoruntusu");
        }

    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
/*
sam.walker@bluerentalcars.com	c!fas_art
kate.brown@bluerentalcars.com	tad1$Fas
raj.khan@bluerentalcars.com	v7Hg_va^
pam.raymond@bluerentalcars.com	Nga^g6!

 ----------

    ------ILK GIRIS-----
    home page logine tıkla ---> try catch
    LOGIN PAGE DEYİZ
    kullanıcı adını gir(excelden al)
    kullanıcı şifresini gir(excelden al)
    login page login butonuna tıkla
    -------------
    HOME PAGE DEYİZ
    kullanıcı ID ye tıkla
    Logout linkine tıkla
    OK e tıkla
    home page logine tıkla
    LOGIN PAGE DEYIZ
    kullanıcı adını gir(excelden al)
    kullanıcı şifresini gir(excelden al)
    login page login butonuna tıkla
    -------------
    HOME PAGE DEYİZ
    kullanıcı ID ye tıkla
    Logout linkine tıkla
    OK e tıkla
    home page logine tıkla
    LOGIN PAGE DEYIZ
    kullanıcı adını gir(excelden al)
    kullanıcı şifresini gir(excelden al)
    login page login butonuna tıkla
    ---------------
    HOME PAGE DEYİZ
    kullanıcı ID ye tıkla
    Logout linkine tıkla
    OK e tıkla
    home page logine tıkla
    LOGIN PAGE DEYIZ
    kullanıcı adını gir(excelden al)
    kullanıcı şifresini gir(excelden al)
    login page login butonuna tıkla
    ---------------
    HOME PAGE DEYİZ
    kullanıcı ID ye tıkla
    Logout linkine tıkla
    OK e tıkla
    home page logine tıkla
    LOGIN PAGE DEYIZ
    kullanıcı adını gir(excelden al)
    kullanıcı şifresini gir(excelden al)
    login page login butonuna tıkla
     */
