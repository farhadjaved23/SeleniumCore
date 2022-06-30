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

public class promptAlert {
    public WebDriver driver;
    int sizee = 0;

    @Test(priority =-1)
    public void simpleAlert() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Select select = new Select(driver.findElement(By.xpath("(//select[@class=\"selectnav\"])[2]")));
        List<WebElement> op = select.getOptions();
        sizee = op.size();
        for(int i =0; i<sizee ; i++){
            String options = op.get(i).getText();
            sizee = op.size();
            //System.out.println(options);
            //System.out.println("Size of Dropdown is "+sizee);
            if(options.equals("- Alerts"))
            {
                select.selectByValue("https://www.hyrtutorials.com/p/alertsdemo.html");
                //System.out.println("Done");
                break;
            }
            else {
                continue;
            }
        }
        WebElement simpleAlertBtn = driver.findElement(By.id("alertBox"));
        simpleAlertBtn.click();
        driver.switchTo( ).alert( ).accept();
        WebElement getSimpleAlert =driver.findElement(By.id("output"));
        getSimpleAlert.getText();
        System.out.println(getSimpleAlert.getText());
        Assert.assertEquals(getSimpleAlert.getText(),"You selected alert popup");
    }
    @Test(priority =0)
    public void confirmAlert() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Select select = new Select(driver.findElement(By.xpath("(//select[@class=\"selectnav\"])[2]")));
        List<WebElement> op = select.getOptions();
        sizee = op.size();
        for(int i =0; i<sizee ; i++){
            String options = op.get(i).getText();
            sizee = op.size();
            System.out.println(options);
            System.out.println("Size of Dropdown is "+sizee);
            if(options.equals("- Alerts"))
            {
                select.selectByVisibleText("- Alerts");
                System.out.println("Done");
                break;
            }
            else {
                continue;
            }
        }
        WebElement confirmAlertBtn = driver.findElement(By.id("confirmBox"));
        confirmAlertBtn.click();
        driver.switchTo( ).alert( ).accept();
        WebElement getConfirmAlert =driver.findElement(By.id("output"));
        getConfirmAlert.getText();
        Assert.assertEquals(getConfirmAlert.getText(),"You pressed OK in confirmation popup");
    }
    @Test(priority =-1)
    public void promptAlert() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Select select = new Select(driver.findElement(By.xpath("(//select[@class=\"selectnav\"])[2]")));
        List<WebElement> op = select.getOptions();
        sizee = op.size();
        for(int i =0; i<sizee ; i++){
            String options = op.get(i).getText();
            sizee = op.size();
            System.out.println(options);
            System.out.println("Size of Dropdown is "+sizee);
            if(options.equals("- Alerts"))
            {
                select.selectByVisibleText("- Alerts");
                System.out.println("Done");
                break;
            }
            else {
                continue;
            }
        }
        WebElement promptAlertBtn = driver.findElement(By.id("promptBox"));
        promptAlertBtn.click();
        driver.switchTo().alert().sendKeys("Farhad Javed");
        driver.switchTo( ).alert( ).accept();
        WebElement getPromptAlert =driver.findElement(By.id("output"));
        getPromptAlert.getText();
        Assert.assertEquals(getPromptAlert.getText(),"You entered text Farhad Javed in propmt popup");
    }
    @AfterTest
    public void quit(){
        driver.quit();
    }
}
