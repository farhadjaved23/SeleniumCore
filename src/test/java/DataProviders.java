import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.util.List;

public class DataProviders {
    public WebDriver driver;

    @Test(dataProvider ="userInfo")
    public void userInfo(String name, String email, String message){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/contactus.html");
        WebElement userName = driver.findElement(By.name("name"));
        userName.sendKeys(name);
        WebElement userMail = driver.findElement(By.name("email"));
        userMail.sendKeys(email);
        WebElement userMsg = driver.findElement(By.className("contact-form-email-message"));
        userMsg.sendKeys(message);
        WebElement submitBtn = driver.findElement(By.id("ContactForm1_contact-form-submit"));
        submitBtn.click();
        driver.close();
    }

    @DataProvider(name = "userInfo")
    public Object[][] dpMethod() {
        return new Object [][]
                {
                        {"Alex", "Alex@abc.com","Alex is a good boy"},
                        {"Ales", "Ales@abc.com","Ales is a good boy"}
                };
    }
}
