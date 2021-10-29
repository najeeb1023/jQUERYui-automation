package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SortablePage extends PageObject{




    @FindBy(xpath = "//a[contains(text(),'Sortable')]")
    private WebElement sortable_option;

    @FindBy(xpath = "//body/ul[@id='sortable']/li[1]")
    private WebElement item_1;




    public SortablePage(WebDriver driver){
        super(driver);
    }


    public void sortElements(){

        driver.switchTo().defaultContent();
        sortable_option.click();
        driver.switchTo().frame(0);
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);",item_1);
        Actions drag_item = new Actions(driver);
        drag_item.dragAndDropBy(driver.findElement(By.xpath("//body/ul[@id='sortable']/li[5]")), 300, 15 ).perform();

    }


}
