package Tests;

import Pages.AdminCityPage;
import Pages.HomePage;
import Pages.LogInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class AdminCitiesTest extends BaseTest {
    private HomePage homePage;
    private LogInPage logInPage;
    private AdminCityPage adminCityPage;
    private WebElement newCityName;
    private String createdCityName;
    private WebElement message;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage(driver, driverWait);
        logInPage = new LogInPage(driver, driverWait);
        adminCityPage = new AdminCityPage(driver, driverWait);
        createdCityName = "KaoNekiGrad120";   //IF DATABASE DID NOT RESTART,CHANGE VARIABLE VALUE!!!

    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.goToLogIn();
        driverWait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")));
        logInPage.logIn("admin@admin.com", "12345");
        driverWait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]")));
        homePage.goToAdminPage();
        adminCityPage.goToCityMenu();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

    @AfterMethod
    public void afterMethod() {
        homePage.logOut();
    }

    @AfterClass
    @Override
    public void afterClass() {
        super.afterClass();
    }


    @Test(priority = 1)
    public void adminCitiesTest() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/admin/cities"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]")).isDisplayed());
    }

    @Test(priority = 2)
    public void createCityTest() {

//    Podaci: random grad korisćenjem faker library-ja
//    assert:
//	Verifikovati da poruka sadrzi tekst Saved successfully

        adminCityPage.createCity();
        driverWait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[1]")));
        newCityName = driver.findElement(By.id("name"));
        newCityName.sendKeys(createdCityName);

        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]")));
        adminCityPage.saveCity();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        message = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div"));
        Assert.assertTrue(message.getText().contains("Saved successfully"));
    }

    @Test(priority = 3)
    public void editCityTest() {
//    Podaci: edituje se grad koji je u testu 2 kreiran na isto ime + - edited (primer: Beograd – Beograd edited)
//    assert:
//	Verifikovati da poruka sadrzi tekst Saved successfully

        adminCityPage.searchCity(createdCityName);
        driverWait.until(ExpectedConditions.elementToBeClickable(By.id("edit")));
        adminCityPage.editCity();
        newCityName = driver.findElement(By.id("name"));
        newCityName.sendKeys(createdCityName + "-edited");
        adminCityPage.saveCity();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        message = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div"));
        Assert.assertTrue(message.getText().contains("Saved successfully"));
    }

    @Test(priority = 4)
    public void deleteCityTest(){
//        Test #5: Delete city
//        Podaci: editovani grad iz testa #3
//        assert:
//	U polje za pretragu uneti staro ime grada
//	Sacekati da broj redova u tabeli bude 1
//	Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
//	Kliknuti na dugme Delete iz prvog reda
//	Sacekati da se dijalog za brisanje pojavi
//	Kliknuti na dugme Delete iz dijaloga
//	Sacekati da popu za prikaz poruke bude vidljiv
//	Verifikovati da poruka sadrzi tekst Deleted succ

adminCityPage.searchCity(createdCityName+"-edited");
driverWait.until(ExpectedConditions.elementToBeClickable(By.id("delete")));
adminCityPage.deleteCity();
driverWait.until(ExpectedConditions.visibilityOfElementLocated
        (By.cssSelector("#app > div.v-application--wrap > main > div > div.container.container--fluid > div > div:nth-child(3) > div > div > div > div > div.v-snack__content > button")));
WebElement deleteMsg= driver.findElement(By.cssSelector
        ("#app > div.v-application--wrap > main > div > div.container.container--fluid > div > div:nth-child(3) > div > div > div"));
Assert.assertTrue(deleteMsg.getText().contains("Deleted successfully"));


    }
}
