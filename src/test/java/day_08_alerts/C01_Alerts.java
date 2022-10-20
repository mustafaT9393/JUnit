package day_08_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
      driver.close();

    }
    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        //alert te ok tusuna basiniz.
        driver.switchTo().alert().accept();
        //result kisminda  "You successfully clicked an alert" yazdigini test ediniz
        WebElement resulYazisi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualYazi=resulYazisi.getText();
        String expectedYazi="You successfully clicked an alert";
        Assert.assertEquals(actualYazi, expectedYazi);
    }


}