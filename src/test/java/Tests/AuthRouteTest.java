package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AuthRouteTest extends BaseTest {

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
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


//    Test #1: Forbids visits to home url if not authenticated
//assert:
//    Ucitati /home stranu kada korisnik nije ulogovan
//	Verifikovati da se u url-u stranice javlja ruta /login

@Test
    public void forbidHomePageVisit(){
        driver.navigate().to("https://vue-demo.daniel-avellaneda.com/home");
        driverWait.until(ExpectedConditions.elementToBeClickable  //login button
                (By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")));
    Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
}

//    Test #2: Forbids visits to profile url if not authenticated
//assert:
//    Ucitati /profile stranu
//	Verifikovati da se u url-u stranice javlja ruta /login
@Test
    public void forbidProfilePageVisit(){
    driver.navigate().to("https://vue-demo.daniel-avellaneda.com/profile");
    driverWait.until(ExpectedConditions.elementToBeClickable  //login button
            (By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")));
    Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
}

//    Test #3: Forbids visits to admin cities url if not authenticated
//assert:
//    Ucitati /admin/cities stranu
//	Verifikovati da se u url-u stranice javlja ruta /login

@Test
    public void forbidCitiesPageVisit(){
    driver.navigate().to("https://vue-demo.daniel-avellaneda.com/admin/cities");
    driverWait.until(ExpectedConditions.elementToBeClickable  //login button
            (By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")));
    Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
}
//    Test #4: Forbids visits to admin users url if not authenticated
//assert:
//    Ucitati /admin/users stranu
//  Verifikovati da se u url-u stranice javlja ruta /login
@Test
    public void forbidUserPageVisit(){
    driver.navigate().to("https://vue-demo.daniel-avellaneda.com/admin/users");
    driverWait.until(ExpectedConditions.elementToBeClickable  //login button
            (By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")));
    Assert.assertTrue(driver.getCurrentUrl().contains("/login"));

}

}
