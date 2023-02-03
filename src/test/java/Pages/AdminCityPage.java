package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AdminCityPage extends BasePage{

    public AdminCityPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

  @FindBy(xpath = "/html/body/div/div[3]/div/a[1]")
private WebElement cityBtn;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button")
private WebElement addItemBtn;
    public void goToCityMenu(){
        cityBtn.click();
    }



}
