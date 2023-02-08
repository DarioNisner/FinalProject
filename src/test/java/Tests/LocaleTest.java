package Tests;

import Pages.HomePage;
import Pages.LocalePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocaleTest extends BaseTest{
    private HomePage homePage;
private LocalePage locale;


    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        homePage=new HomePage(driver,driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
    }

    @AfterClass
    @Override
    public void afterClass() {
        super.afterClass();
    }

    @Test
    public void setLocaleToSpanish(){
        homePage.chooseLocale(locale.ES);
        Assert.assertTrue(homePage.getHeader().contains("Página de aterrizaje"));
    }

    @Test
    public void setLocaleToEnglish(){
        homePage.chooseLocale(locale.EN);
        Assert.assertTrue(homePage.getHeader().contains("Landing"));
    }
    @Test
    public void setLocaleToFrench(){
        homePage.chooseLocale(locale.FR);
        Assert.assertTrue(homePage.getHeader().contains("Page d'atterrissage"));
    }


}
