package Tests;

import Pages.HomePage;
import Pages.LogInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginTest extends BaseTest {

    private LogInPage logInPage;
    private HomePage homePage;
    private WebElement errorMsg;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        logInPage = new LogInPage(driver, driverWait);
        homePage = new HomePage(driver, driverWait);
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
    public void urlRouteTest() {

        homePage.goToLogIn();
        driverWait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login"));
    }


    @Test(dependsOnMethods = "urlRouteTest")
    public void attributeValueTest() {

        homePage.goToLogIn();
        driverWait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")));
        WebElement loginfield = driver.findElement(By.id("email"));
        WebElement passwordfield = driver.findElement(By.id("password"));
        Assert.assertTrue(loginfield.getAttribute("type").contains("email"));
        Assert.assertTrue((passwordfield.getAttribute("type").contains("password")));
    }


    @Test(dependsOnMethods = "urlRouteTest")
    public void wrongInputTest() {

        homePage.goToLogIn();
        driverWait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")));
        logInPage.logIn(faker.internet().emailAddress(), faker.internet().password());
        driverWait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/button")));
        errorMsg = driver.findElement(By.className("v-snack__content"));
        Assert.assertTrue(errorMsg.getText().contains("User does not exists"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test(priority = 3)
    public void wrongPasswordTest() {

        homePage.goToLogIn();
        driverWait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")));
        logInPage.logIn("admin@admin.com", faker.internet().password());
        driverWait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/button")));
        errorMsg = driver.findElement(By.className("v-snack__content"));
        Assert.assertTrue(errorMsg.getText().contains("Wrong password"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));

    }

    @Test(priority = 4)
    public void correctInputTest() {

        homePage.goToLogIn();
        driverWait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")));
        logInPage.logIn("admin@admin.com", "12345");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]")));
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"));

    }

    @Test(dependsOnMethods = "correctInputTest")
    public void logOutTest() {


        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]")));
        WebElement logoutBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]"));
        Assert.assertTrue(logoutBtn.isDisplayed());
        homePage.logOut();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        Assert.assertEquals(driver.getCurrentUrl(), "https://vue-demo.daniel-avellaneda.com/login");
    }
}
