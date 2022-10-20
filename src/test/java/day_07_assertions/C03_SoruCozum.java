package day_07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
       //Bir Class olusturalim YanlisEmailTesti
       //2. http://automationpractice.com/index.php sayfasina gidelim
       //3. Sign in butonuna basalim
       //4. Email kutusuna @isareti olmayan bir mail yazip enter’a
       //bastigimizda “Invalid email address” uyarisi ciktigini test edelim

public class C03_SoruCozum {   static WebDriver driver;
    @BeforeClass
    public static void setup (){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='login']")).click();

    }
    @Test
    public void test02(){
        WebElement eMailButton = driver.findElement(By.xpath("//input[@id='email_create']"));
        eMailButton.sendKeys("Mustafa.gmail.com="+ Keys.ENTER);
        WebElement uyari= driver.findElement(By.className("fancybox-error"));
        Assert.assertTrue(uyari.isDisplayed());

    }
}
