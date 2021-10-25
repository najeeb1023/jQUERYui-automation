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

    @FindBy(xpath = "//a[contains(text(),'Resizable')]")
    private WebElement resizable_option;

    @FindBy(xpath = "/html/body/div[2]")
    private WebElement drop_box;

    @FindBy(xpath = "//body/div[@id='resizable']/div[3]")
    private WebElement resize_element;

    @FindBy(xpath = "/html/body/div[1]/div[3]")
    private WebElement change;

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

    public void clickResizable(){

        driver.switchTo().defaultContent();
        resizable_option.click();
        Actions resize = new Actions(driver);
        driver.switchTo().frame(0);
        resize.dragAndDropBy(resize_element, 156,15).perform();



    }

    public void myWaitMethod(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
