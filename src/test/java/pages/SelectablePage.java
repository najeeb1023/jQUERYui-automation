package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SelectablePage extends PageObject{

    @FindBy(linkText = "Selectable")
    private WebElement selectable_option;

    @FindBy(xpath = "//li[contains(text(),'Item 3')]")
    private WebElement item_3;

    @FindBy(xpath = "//li[contains(text(),'Item 4')]")
    private WebElement item_4;

    @FindBy(xpath = "//li[contains(text(),'Item 7')]")
    private WebElement item_7;


    public SelectablePage(WebDriver driver){
        super(driver);
    }

    public void selectItem347(){

        driver.switchTo().defaultContent();
        selectable_option.click();
        Actions hold_key = new Actions(driver);
        hold_key.keyDown(Keys.CONTROL).perform();
        driver.switchTo().frame(0);
        item_3.click();
        item_4.click();
        item_7.click();



    }

}
