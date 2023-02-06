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

    @FindBy(id = "edit")
    private WebElement editCity;
@FindBy (id = "search")
WebElement searchCityField;


@FindBy(xpath = "//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]")
private WebElement saveBtn;


@FindBy(id = "delete")
private WebElement deleteBtn;
@FindBy(xpath = "//*[@id=\"app\"]/div[5]/div/div/div[2]/button[2]")
private WebElement confirmDelete;

    public void goToCityMenu(){
        cityBtn.click();
    }
public void createCity(){
        addItemBtn.click();
}
public void editCity(){

        editCity.click();
}
public void searchCity(String cityName){
        searchCityField.sendKeys(cityName);

}
public void saveCity(){
        saveBtn.click();
}

public void deleteCity(){
        deleteBtn.click();
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[2]/button[2]")));
        confirmDelete.click();
}
}
