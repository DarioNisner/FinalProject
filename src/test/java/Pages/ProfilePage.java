package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;

public class ProfilePage extends BasePage {

    Faker faker = new Faker();

    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "phone")
    private WebElement phoneField;
    @FindBy(id = "city")
    private WebElement cityField;
    @FindBy(id = "country")
    private WebElement countryField;

    @FindBy(id = "urlTwitter")
    private WebElement twitterField;

    @FindBy(id = "urlGitHub")
    private WebElement gitField;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button")
    private WebElement saveBtn;
@FindBy(className = "v-input__append-inner")
private WebElement arrow;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement message;





    public void fillAll() {
        nameField.sendKeys(Keys.CONTROL + "a");
        nameField.sendKeys(faker.name().fullName());
        phoneField.sendKeys(Keys.CONTROL + "a");
        phoneField.sendKeys(faker.phoneNumber().phoneNumber());
        cityField.sendKeys(Keys.CONTROL + "a");
        cityField.sendKeys("New York");
        cityField.sendKeys(Keys.CONTROL + "a");
        countryField.sendKeys(faker.country().name());
        twitterField.sendKeys(Keys.CONTROL + "a");
        twitterField.sendKeys("https://" +faker.internet().url());
        gitField.sendKeys(Keys.CONTROL + "a");
        gitField.sendKeys("https://" +faker.internet().url());
    }

    public void saveInfo() {
        saveBtn.click();
    }

    public WebElement getMessage() {
        return message;
    }

}



