package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

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
        DraggablePage drag_function = new DraggablePage(driver);
        drag_function.clickDraggable();

    }

    @Test(testName = "Dropping element in drop box.", priority = 2)
    public void didDroppableWork(){

        DroppablePage drop_function = new DroppablePage(driver);
        drop_function.clickDroppable();

    }

    @Test(testName = "Resize element.", priority = 3)
    public void didResizableWork(){

        ResizablePage resize_function = new ResizablePage(driver);
        resize_function.clickResizable();


    }

    @Test(testName = "Select multiple elements", priority = 4)
    public void didSelectMultipleItems(){

        SelectablePage select_function = new SelectablePage(driver);
        select_function.selectItem347();

    }

    @Test(testName = "Sort elements.", priority = 5)
    public void didSortElements(){

        SortablePage sortable_function = new SortablePage(driver);
        sortable_function.sortElements();
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
