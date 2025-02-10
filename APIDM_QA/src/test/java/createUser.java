import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class createUser {
    WebDriver driver;
    superAdminLogin superAdmin;


    @Test
    public void userCreate() throws InterruptedException {
        superAdmin = new superAdminLogin();
        superAdmin.openHomePage();
        superAdmin.adminLogin();
        this.driver = superAdmin.driver;

        List<WebElement> dropdown1List = driver.findElements(By.xpath("//ul[@class='vertical-menu in']/li"));
        for (WebElement element : dropdown1List) {
            String dropdownValue = element.getText();
            if (dropdownValue.equals("User Management")) {
                element.click();
                break;
            }
        }

        WebElement userCreateBtn = driver.findElement(By.xpath("(//a[normalize-space()='User Create'])[1]"));
        userCreateBtn.click();


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



