import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class SauceDemoTest {

    ChromeDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    private final String DEMO_URL = "https://www.saucedemo.com/v1/";

    @Test
    public void loginSauceDemoTest() {
        driver.get(DEMO_URL);
        WebElement userNameField = driver.findElement(By.id("user-name"));
        userNameField.sendKeys("problem_user");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement inventoryItemName = driver.findElement(By.className("inventory_item_name"));
        Assertions.assertThat(inventoryItemName.getText()).isEqualTo("Sauce Labs Backpack");
        driver.findElement(By.className("bm-burger-button")).click();
        WebElement logout = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        wait.until(ExpectedConditions.elementToBeClickable(logout));
        logout.click();


//    @Test
//    public void invalidLoginSauceDemo() {
//        driver.get(DEMO_URL);
        WebElement userField = driver.findElement(By.id("user-name"));
        userField.sendKeys("problemuser");
        WebElement validPasswordField = driver.findElement(By.id("password"));
        validPasswordField.sendKeys("secret_sauce");
        WebElement invalidLoginButton = driver.findElement(By.id("login-button"));
        invalidLoginButton.click();
        WebElement notificationMessage = driver.findElement(By.className("login-box"));
        Assertions.assertThat(notificationMessage.getText()).isEqualTo("Epic sadface: Username and password do not match any user in this service");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
