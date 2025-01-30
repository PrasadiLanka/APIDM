import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class createUser {
    WebDriver driver;

    @Test
    public void userCreate() throws InterruptedException {
        superAdminLogin login = new superAdminLogin();
        login.openHomePage();
        login.adminLogin();

        Thread.sleep(2000);

        /*WebElement userBtn = driver.findElement(By.xpath("(//span[normalize-space()='User Management'])[1]"));
        userBtn.click();

        WebElement userCreateBtn = driver.findElement(By.xpath("(//a[normalize-space()='User Create'])[1]"));
        userCreateBtn.click();*/

        WebElement name = driver.findElement(By.xpath("(//input[@id='name'])[1]"));
        name.sendKeys("Lanka");

        WebElement phone = driver.findElement(By.xpath("(//input[@id='phone_number'])[1]"));
        phone.sendKeys("1234567890");

        WebElement email = driver.findElement(By.xpath("(//input[@id='email'])[1]"));
        email.sendKeys("lanka+2@thesanmark.com");

        WebElement password = driver.findElement(By.xpath("(//input[@id='password'])[1]"));
        password.sendKeys("Lanka123#");

        WebElement password2 = driver.findElement(By.xpath("(//input[@id='password-confirm'])[1]"));
        password2.sendKeys("Lanka123#");

    }

}

