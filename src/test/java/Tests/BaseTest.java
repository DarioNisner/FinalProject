package Tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected Faker faker;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Daca\\ITB\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        faker = new Faker();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
        driver.get("https://vue-demo.daniel-avellaneda.com/");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}
