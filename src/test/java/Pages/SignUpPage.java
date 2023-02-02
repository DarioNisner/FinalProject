package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage{

    public SignUpPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    @FindBy(id = "name")
  private  WebElement registerNameField;

    @FindBy(id = "email")
private WebElement registerEmailField;

    @FindBy(id = "password")
    private WebElement registerPassword;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button")
    private WebElement signMeUpBtn;


    public void SignUp (String name,String email,String password,String confirmPassword){
        registerNameField.sendKeys(name);
        registerEmailField.sendKeys(email);
        registerPassword.sendKeys(password);
        confirmPasswordField.sendKeys(confirmPassword);
        signMeUpBtn.click();

    }


}
