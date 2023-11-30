import lv.acodemy.page_object.sauce_pages.InventoryPage;
import lv.acodemy.page_object.sauce_pages.LoginPage;
import lv.acodemy.utils.ConfigurationProperties;
import lv.acodemy.utils.LocalDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static lv.acodemy.utils.ConfigurationProperties.*;
import static lv.acodemy.utils.LocalDriverManager.closeDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class SauceDemoTestSecond {

    WebDriver driver = LocalDriverManager.getInstance();
    LoginPage loginPage = new LoginPage();
    InventoryPage inventoryPage = new InventoryPage();
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @Test(description = "Test successful login")
    public void testLogin() {
        driver.get(getConfiguration().getString("sauce.demo.url"));
        loginPage.authorize("problem_user", "secret_sauce");
        wait.until(visibilityOfAllElements(inventoryPage.getInventoryItems()));
        assertThat(inventoryPage.getInventoryItems()).hasSize(6);
    }

    @AfterMethod
    public void after() {
        closeDriver();
    }

}
