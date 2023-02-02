package Tests;

import Pages.HomePage;
import Pages.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    private HomePage homePage;
    private SignUpPage signUpPage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage(driver, driverWait);
        signUpPage = new SignUpPage(driver, driverWait);
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
    public void signUpUrlRouteTest() {
        homePage.goTosignUp();
        driverWait.until(ExpectedConditions.
                elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button")));
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }

    @Test(dependsOnMethods = "signUpUrlRouteTest")
    public void inputTypesTest() {
        homePage.goTosignUp();
        driverWait.until(ExpectedConditions.
                elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button")));
        Assert.assertTrue(driver.findElement(By.id("email")).getAttribute("type").contains("email"));
        Assert.assertTrue(driver.findElement(By.id("password")).getAttribute("type").contains("password"));
        Assert.assertTrue(driver.findElement(By.id("confirmPassword")).getAttribute("type").contains("password"));
    }

    @Test(priority = 4)
    public void existentUserTest() {

        homePage.goTosignUp();
        driverWait.until(ExpectedConditions.
                elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button")));
        signUpPage.SignUp("Test Test", "admin@admin.com", "123654", "123654");
        driverWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/button")));
        Assert.assertTrue(driver.findElement(By.className("v-snack__content")).getText().contains("E-mail already exists"));
    }

    @Test(priority = 5)
    public void validInputSignUp() {


        homePage.goTosignUp();
        driverWait.until(ExpectedConditions.
                elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button")));
        signUpPage.SignUp("Dario Nisner Bajin", faker.internet().emailAddress(), "12345", "12345");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("#app > div.v-dialog__content.v-dialog__content--active > div > div")));
        WebElement verifyMsg = driver.findElement
                (By.cssSelector("#app > div.v-dialog__content.v-dialog__content--active > div > div > div.v-card__title.headline.grey.lighten-2.black--text.dlgVerifyAccount"));
        Assert.assertTrue(verifyMsg.getText().contains("IMPORTANT: Verify your account"));
    }


}