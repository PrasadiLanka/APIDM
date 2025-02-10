import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class test {

    WebDriver driver;

    @BeforeMethod
    public void openHomePage() {
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

        List<WebElement> dropdown1List = driver.findElements(By.xpath("//ul[@class='vertical-menu in']/li"));
        for(WebElement element : dropdown1List){
            String dropdownValue = element.getText();
            if(dropdownValue.equals("User Management")){
                element.click();
                break;
            }
        }
        WebElement userCreateBtn = driver.findElement(By.xpath("(//a[normalize-space()='User Create'])[1]"));
        userCreateBtn.click();
    }
}
