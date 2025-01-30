import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;


public class superAdminLogin {

    WebDriver driver;

    @BeforeMethod
    public void openHomePage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://apidm.sanmark.dev/login");
    }

    @Test
    public void adminLogin() throws InterruptedException {

        WebElement email = driver.findElement(By.xpath("(//input[@id='email'])[1]"));
        email.sendKeys("admin@mail.com");

        WebElement password = driver.findElement(By.xpath("(//input[@id='pass'])[1]"));
        password.sendKeys("12345678");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2500)");

        Thread.sleep(2000); // if this time doesn't have, give no element error.

        WebElement loginButton = driver.findElement(By.xpath("//button[@id='loginBtn']"));
        loginButton.click();

        driver.get("https://apidm.sanmark.dev/dashboard");
        String expectedTitle = "APIDM - dashboard";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)) { //this also can write as actualTitle.equals(expexctedTitle)
            System.out.println("successfully logged to the system");

        }
    }

   }
