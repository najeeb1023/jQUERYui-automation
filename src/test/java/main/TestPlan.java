package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestPlan {

    private final WebDriver driver = new ChromeDriver();
    HomePage home = new HomePage(driver);

    @BeforeTest
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);

    }

    @Test(testName = "Dragging the box.", priority = 1)
    public void firstTest(){

        driver.manage().window().maximize();
        driver.get(Utils.BASE_URL);
        home.clickDraggable();

    }

    @Test(testName = "Dropping element in drop box.", priority = 2)
    public void secondTest(){

        home.clickDroppable();

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
