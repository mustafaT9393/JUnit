package day_06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeClass_AfterClass {
   static WebDriver driver;
    /*@Before Class ve @After Class notasyonlari sadece
    static metodlar icin calisir
    */
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
        //Before method coll
    public  void method1(){
        driver.get("http://amazon.com");
        //After method coll

    }
    @Test
    public  void method2(){
        driver.get("http://techproeducation.com");
    }
    @Test
    public  void method3(){
        driver.get("http://facebook.com");
    }
}
