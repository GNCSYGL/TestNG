package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TechproHomePage;
import techproed.pages.TechproLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day21_TechProLoginTest {

    @Test
    public void loginTest(){
        TechproLoginPage techproLoginPage = new TechproLoginPage();
        TechproHomePage techproHomePage = new TechproHomePage();

        Driver.getDriver().get(ConfigReader.getProperty("techpro_test_url"));

        techproLoginPage.username.sendKeys(ConfigReader.getProperty("techpro_test_username"));
        techproLoginPage.password.sendKeys(ConfigReader.getProperty("techpro_test_password"));
        techproLoginPage.submitButton.click();

        //ASSERT
        //Login yapildi. Driver suan homepage'te

        Assert.assertTrue(techproHomePage.homeHeader.isDisplayed());

        // Sayfadan cikis yap ve cikis yapildigini test et
        techproHomePage.homeLogoutButton.click();

        //cikis olduguna dair kanit goster (submit butonunun varligini gosterdik)
        Assert.assertTrue(techproLoginPage.submitButton.isDisplayed());

        //Driver'i kapattik
        Driver.closeDriver();
    }
    /*
    SMOKE TEST
Smoke Test nedir? : Uygulamanin stabil durumda oldugunu, ve onemli özelliklerin calisir oldugunu test edilir
Login
Checkin
Checkout
Add to card
Make payment
Sign out
……
Ne sıklıkla yapılır?
Her sabah 8 am civarı
Ne kadar surer?
15-20 dakika
Smoke Test I nasıl yaparsın?
Smoke test suite klasorumuz var. Bu klasordeki test leri hergun calistiririz.
Aslinda jenkins her sabah 8 am de smoke testleri calistirir ve raporları takıma email atar. Testerlar bu raporu inceler ve fail varsa takıma email atar.
Virtual Machine(VM-Sanal Bilgisayar) test caselerin calismasi icin kullanilabilir.
Smoke test suite de kac test case iniz var
18 tane
Tum smoke test caseleriniz automate edilmismidir? Manual de varmidir?
Tum onemli test casesler automate edilmiştir.
Hangi testlerin smoke test e eklenecegine Kim karar verir?
Test Lead, Sr. Automation Testers. En kidemli tester.
     */
}
