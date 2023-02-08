package Tests;

import Pages.HomePage;
import Pages.LogInPage;
import Pages.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class ProfileTest extends BaseTest {
    private HomePage homePage;
    private LogInPage logInPage;
    private ProfilePage profilePage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage(driver, driverWait);
        logInPage = new LogInPage(driver, driverWait);
        profilePage = new ProfilePage(driver, driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.goToLogIn();
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")));
        logInPage.logIn("admin@admin.com", "12345");
        homePage.goToProfilePage();
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button"))); //save btn
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


    @Test
    public void changeProfileInfoTest() {
        profilePage.fillAll();
        profilePage.saveInfo();
        driverWait.until    //close btn on msg
                (ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/button")));
        Assert.assertTrue(profilePage.getMessage().getText().contains("Profile saved successfuly"));

    }

    @Test
    public void attributeValueTest() {
        Assert.assertTrue(driver.findElement(By.id("name")).getAttribute("type").contains("text"));
        Assert.assertTrue(driver.findElement(By.id("phone")).getAttribute("type").contains("tel"));
        Assert.assertTrue(driver.findElement(By.id("city")).getAttribute("type").contains("text"));
        Assert.assertTrue(driver.findElement(By.id("country")).getAttribute("type").contains("text"));
        Assert.assertTrue(driver.findElement(By.id("urlTwitter")).getAttribute("type").contains("url"));
        Assert.assertTrue(driver.findElement(By.id("urlGitHub")).getAttribute("type").contains("url"));


    }

}
