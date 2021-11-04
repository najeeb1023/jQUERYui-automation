package pages;

import main.Utils;
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

    @FindBy(xpath = "//body/ul[@id='sortable']/li[2]")
    private WebElement item_2;

    @FindBy(xpath = "//body/ul[@id='sortable']/li[5]")
    private WebElement item_5;




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
        drag_item
                .clickAndHold(item_5)
                .moveToElement(driver.findElement(By.xpath("//body/ul[@id='sortable']/li[5]")), 0, -115 )
                .build()
                .perform();







    }

    public void myWaitMethod(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
