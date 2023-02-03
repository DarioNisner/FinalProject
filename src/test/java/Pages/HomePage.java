package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]")
    WebElement goToLogInPage;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]")
    WebElement goToSignUpPage;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/button")
    WebElement localeBtn;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]")
    WebElement toMyProfilePage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]")
    WebElement toAdminPage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]")
    WebElement logOutBtn;

    public void goToLogIn (){
        goToLogInPage.click();
    }
    public void goTosignUp(){
        goToSignUpPage.click();
    }
    public void changeLocale(){
        localeBtn.click();
    }
    public void logOut(){
        logOutBtn.click();
    }
    public void goToAdminPage(){
        toAdminPage.click();
    }


}
