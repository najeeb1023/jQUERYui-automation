package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Resizable extends PageObject{


    @FindBy(xpath = "//a[contains(text(),'Resizable')]")
    private WebElement resizable_option;

    @FindBy(xpath = "//body/div[@id='resizable']/div[3]")
    private WebElement resize_element;


    public Resizable (WebDriver driver){
        super(driver);
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
