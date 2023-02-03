package Tests;

import Pages.AdminCityPage;
import Pages.HomePage;
import Pages.LogInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdminCitysTest extends BaseTest {
    private HomePage homePage;
    private LogInPage logInPage;
    private AdminCityPage adminCityPage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage(driver, driverWait);
        logInPage = new LogInPage(driver, driverWait);
        adminCityPage = new AdminCityPage(driver, driverWait);
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
    public void adminCitiesTest() {
        homePage.goToLogIn();
        driverWait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")));
        logInPage.logIn("admin@admin.com", "12345");
        driverWait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]")));
        homePage.goToAdminPage();
       adminCityPage.goToCityMenu();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/admin/cities"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]")).isDisplayed());
    }
@Test(dependsOnMethods = "adminCitiesTest")
    public void createCityTest(){

//    Podaci: random grad korisćenjem faker library-ja
//    assert:
//	Verifikovati da poruka sadrzi tekst Saved successfully




}




}
