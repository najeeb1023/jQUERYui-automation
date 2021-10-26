package pages;

import com.sun.source.tree.AssertTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DraggablePage extends PageObject{


    @FindBy(xpath = "//a[contains(text(),'Draggable')]")
    private WebElement draggable_option;

    @FindBy(xpath = "/html/body/div[2]")
    private WebElement drop_box;




    public DraggablePage(WebDriver driver){
        super(driver);
    }


    public void clickDraggable(){

        draggable_option.click();
        myWaitMethod();
        Actions hold_drag = new Actions(driver);
        driver.switchTo().frame(0);
        hold_drag.dragAndDropBy(driver.findElement(By.xpath("//div[@id='draggable']")), 216, 106).perform();


    }

    public void myWaitMethod(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
