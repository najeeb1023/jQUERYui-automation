package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Droppable extends PageObject{


    @FindBy(linkText = "Droppable")
    private WebElement droppable_option;




    public Droppable(WebDriver driver){
        super(driver);
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
