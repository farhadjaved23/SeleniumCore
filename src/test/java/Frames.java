import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Frames {
    public WebDriver driver;


    @Test(priority =-1)
    public void simpleAlert() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
        WebElement f = driver.findElement(By.id("frm1"));
        driver.switchTo().frame("frm1");
        Select select = new Select(driver.findElement(By.id("selectnav2")));
        List<WebElement> op = select.getOptions();
        select.selectByVisibleText("Contact");
        Thread.sleep(5000);
    }

    @AfterTest
    public void quit(){
        driver.quit();
    }
}
