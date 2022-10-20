package day_05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Before_After {

   WebDriver driver;
    @Before
    public void setop(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        driver.close();
    }

    @Test
        //Before method coll
    public void method1(){
        driver.get("http://amazon.com");
        //After method coll

    }
    @Test
    public void method2(){
        driver.get("http://techproeducation.com");
    }
    @Test
    public void method3(){
        driver.get("http://facebook.com");
    }
}
