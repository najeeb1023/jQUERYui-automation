package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject{

    @FindBy(xpath = "//a[contains(text(),'Draggable')]")
    private WebElement draggable_option;

    @FindBy(linkText = "Droppable")
    private WebElement droppable_option;

    @FindBy(xpath = "/html/body/div[2]")
    private WebElement drop_box;

    public HomePage(WebDriver driver){
        super(driver);

    }

    public void clickDraggable(){

        draggable_option.click();
        myWaitMethod();
        Actions hold_drag = new Actions(driver);
        driver.switchTo().frame(0);
        hold_drag.dragAndDropBy(driver.findElement(By.xpath("//div[@id='draggable']")), 216, 106).perform();


    }

    public void clickDroppable(){

        driver.switchTo().defaultContent();
        droppable_option.click();
        Actions drag_drop = new Actions(driver);
        driver.switchTo().frame(0);
        drag_drop.dragAndDropBy(driver.findElement(By.xpath("/html/body/div[1]")),156,15).perform();

    }

    public void myWaitMethod(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
