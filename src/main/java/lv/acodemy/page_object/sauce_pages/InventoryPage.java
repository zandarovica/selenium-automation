package lv.acodemy.page_object.sauce_pages;

import lombok.Getter;
import lv.acodemy.utils.LocalDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.openqa.selenium.support.How.CLASS_NAME;

public class InventoryPage {

    public InventoryPage() {
        WebDriver driver = LocalDriverManager.getInstance();
        PageFactory.initElements(driver, this);
    }

    @Getter
    @FindBy(how = CLASS_NAME, className = "inventory_item")
    List<WebElement> inventoryItems;
}
