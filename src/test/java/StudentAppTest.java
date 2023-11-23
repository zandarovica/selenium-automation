import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import lv.acodemy.page_object.AddStudentPage;
import lv.acodemy.page_object.MainPage;
import lv.acodemy.page_object.Notifications;
import lv.acodemy.utils.LocalDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static java.time.Duration.ofSeconds;
import static lv.acodemy.utils.ConfigurationProperties.getConfiguration;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@Slf4j
public class StudentAppTest {

    Faker fakeData = new Faker();
    WebDriverWait wait = new WebDriverWait(LocalDriverManager.getInstance(),
            ofSeconds(getConfiguration().getLong("wait.time")));
    MainPage mainPage = new MainPage();
    AddStudentPage addStudentPage = new AddStudentPage();
    Notifications notifications = new Notifications(wait);



    @Test
    public void createStudentTest() {
        LocalDriverManager.getInstance().manage()
                .timeouts()
                .implicitlyWait(ofSeconds(getConfiguration().getLong("wait.time")));
        logger.info("Will open now: " + getConfiguration().getString("app.url"));

        LocalDriverManager.getInstance().get(getConfiguration().getString("app.url"));
        mainPage.openAddStudentForm();

        //Finding NAME field
//        WebElement nameInputField = driver.findElement(By.id("name"));
//        nameInputField.sendKeys(fakeData.name().fullName());
        addStudentPage.setNameField(fakeData.name().fullName());

        //Finding EMAIL field
//        WebElement emailInputField = driver.findElement(By.id("email"));
//        emailInputField.sendKeys(fakeData.internet().emailAddress());
        addStudentPage.setEmailField(fakeData.internet().emailAddress());

        //Gender
//        driver.findElement(By.id("gender")).click();
//        driver.findElement(By.xpath("//div[@class='rc-virtual-list-holder-inner']//div[text()='FEMALE']")).click();
        addStudentPage.setGender("female");

        //Submit
//        WebElement submitButton = driver.findElement(By.xpath("//span[text()='Submit']//parent::button"));
//        submitButton.click();
        addStudentPage.submitStudent();

//        WebElement notificationMessage = driver.findElement(By.className("ant-notification-notice-message"));
//        wait.until(ExpectedConditions.textToBePresentInElement(notificationMessage, "Student successfully added"));
//        notifications.getNotificationLocator();
//        Assertions.

        assertThat(notifications.getNotificationSuccessMessage()).isEqualTo("Student successfully added");


    }

    @AfterMethod
    public void tearDown() {
        LocalDriverManager.closeDriver();
    }
}
