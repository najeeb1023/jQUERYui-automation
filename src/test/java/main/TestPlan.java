package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Draggable;
import pages.Droppable;
import pages.Resizable;

public class TestPlan {

    private final WebDriver driver = new ChromeDriver();

    @BeforeTest
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);

    }

    @Test(testName = "Dragging the box.", priority = 1)
    public void didDraggableWork(){

        driver.manage().window().maximize();
        driver.get(Utils.BASE_URL);
        Draggable drag_function = new Draggable(driver);
        drag_function.clickDraggable();

    }

    @Test(testName = "Dropping element in drop box.", priority = 2)
    public void didDroppableWork(){

        Droppable drop_function = new Droppable(driver);
        drop_function.clickDroppable();

    }

    @Test(testName = "Resizable option.", priority = 3)
    public void didResizableWork(){

        Resizable resize_function = new Resizable(driver);
        resize_function.clickResizable();


    }

    @AfterTest
    public void endTest(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }





}
