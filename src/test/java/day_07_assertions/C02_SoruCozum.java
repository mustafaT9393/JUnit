package day_07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_SoruCozum {
    static WebDriver driver;
    @BeforeClass
    public static void setup (){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.bestbuy.com/");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test02(){
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.bestbuy.com/";
        Assert.assertTrue(actualUrl.equals(expectedUrl));
    }
    @Test
    public void test03(){
      String  actualTitle=driver.getTitle();
      String arananKelime="Rest";
      Assert.assertFalse(actualTitle.contains(arananKelime));

    }
    @Test
    public void test04(){
        WebElement logo=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }
    @Test
    public void test05(){
        WebElement link=driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(link.isDisplayed());

    }
}
