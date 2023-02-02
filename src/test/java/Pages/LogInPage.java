package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage extends BasePage {

    public LogInPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    @FindBy(id = "email")
    private WebElement inputEmailField;

    @FindBy(id = "password")
    private WebElement inputPasswordField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")
    private WebElement logInBtn;


    public void logIn(String email, String password) {
        inputEmailField.sendKeys(email);
        inputPasswordField.sendKeys(password);
        logInBtn.click();

    }


}
