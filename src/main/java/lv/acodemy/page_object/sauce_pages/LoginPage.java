package lv.acodemy.page_object.sauce_pages;

import lv.acodemy.utils.LocalDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.openqa.selenium.support.How.*;

public class LoginPage {

    public LoginPage() {
        WebDriver driver = LocalDriverManager.getInstance();
        PageFactory.initElements(driver, this);
    }


    @FindBy( how = XPATH ,xpath = "//input[@data-test='username']")
    WebElement usernameField;
    @FindBy(how = ID,id = "password")
    WebElement passwordField;
    @FindBy(how = NAME,name = "login-button")
    WebElement loginButton;

    public void authorize(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
