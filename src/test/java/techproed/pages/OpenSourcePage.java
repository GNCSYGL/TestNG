package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage {


    //Page objelerini bu sinifta buluruz.

    // 1. constructer olusturmak zorundayiz.
    public OpenSourcePage(){
        //PageFactory selenium'dan gelen be bu sayfa elementlerini intantiate etmek icin kullanilir.
        //Sayfa objeleri cagirildiginda NullPointerException alinmaz.
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //PAGE OBJELERINI OLUSTUR.
    //    GELENEKSEL  : public WebElement username = Driver.getDriver().findElement(By.name("username"));
    @FindBy(name = "username")
    public WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;


}
