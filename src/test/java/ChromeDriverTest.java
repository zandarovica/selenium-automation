import lv.acodemy.utils.LocalDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ChromeDriverTest {
    WebDriver driver = LocalDriverManager.getInstance();

    @Test
    public void chromeDriverTest() {
        driver.get("https://google.lv");
        WebElement acceptButton = driver.findElement(By.xpath("//div[text()='Accept all']//parent::button"));
        acceptButton.click();
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("deo.lashes");
        searchField.sendKeys(Keys.ENTER);

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
