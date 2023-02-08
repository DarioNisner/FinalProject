package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    private LocalePage locale;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]")
    WebElement goToLogInPage;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]")
    WebElement goToSignUpPage;

    @FindBy(className = "btnLocaleActivation")
    WebElement localeBtn;

    @FindBy(xpath = "/html/body/div/div[1]/div/header/div/div[3]/a[3]")
    WebElement toMyProfilePage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]")
    WebElement toAdminPage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]")
    WebElement logOutBtn;

    @FindBy(className = "btnEN")
    private WebElement english;

    @FindBy(className = "btnES")
    private WebElement spanish;

    @FindBy(className = "btnFR")
    private WebElement french;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement header;


    public void goToLogIn() {
        goToLogInPage.click();
    }

    public void goTosignUp() {
        goToSignUpPage.click();
    }

    public void logOut() {
        logOutBtn.click();
    }

    public void goToAdminPage() {
        toAdminPage.click();
    }
        public String getHeader () {
            return header.getText();
        }
public void goToProfilePage(){
        driverWait.until(ExpectedConditions.elementToBeClickable(toMyProfilePage));
        toMyProfilePage.click();
}



    }
