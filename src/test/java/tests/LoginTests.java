package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
//adding loingtest and modifiying the code
//without commiting
public class LoginTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void loginTest1(){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test"+ Keys.ENTER);
        Assert.assertEquals(driver.getTitle(), "Web Orders");
    }
    @Test
    public void LogOutTest(){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test"+ Keys.ENTER);
        driver.findElement(By.id("ct100_logout")).click();
        Assert.assertEquals(driver.getTitle(), "Web Orders Login");

    }



    @Test
    public void logOutTest(){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test"+ Keys.ENTER);
        driver.findElement(By.id("ctl00_logout")).click();
        Assert.assertEquals(driver.getTitle(), "Web Orders Login");

    }

        @Test
        public void NameVerification() {
            driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
            driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
            driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test" + Keys.ENTER);

            WebElement nameVerify = driver.findElement(By.xpath("//td[.='Susan McLaren']"));
            if (nameVerify.getText().equals("Susan McLaren")) {
                System.out.println("Order verified");
            } else {
                System.out.println("Order did not verify");
            }
            verifyOrder(driver, "Bob Feather");
        }
            public static void verifyOrder(WebDriver driver, String orderName){


                List<WebElement> allNames= driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
                for(WebElement n:allNames){
                    System.out.println(n.getText());
                    if(n.getText().equals(orderName)){
                        System.out.println(orderName+"'s order verified");
                        break;
                    }
                }
        }
    @AfterMethod
    public void cleanUp(){
    driver.close();
=======
    @AfterMethod
    public void cleanUp(){
        driver.close();

>>>>>>> feature
    }
}
