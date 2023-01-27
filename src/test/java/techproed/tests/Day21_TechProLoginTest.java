package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TechproLoginPage;
import techproed.utilities.Driver;

public class Day21_TechProLoginTest {

    @Test
    public void loginTest(){
        Driver.getDriver().get("https://testcenter.techproeducation.com/index.php?page=form-authentication");
        TechproLoginPage techproLoginPage = new TechproLoginPage();
        techproLoginPage.username.sendKeys("techproed");
        techproLoginPage.password.sendKeys("SuperSecretPassword");
        techproLoginPage.submitButton.click();
    }
}
