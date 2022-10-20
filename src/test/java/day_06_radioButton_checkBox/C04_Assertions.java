package day_06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class C04_Assertions {
    WebDriver driver;
    @Before
    public void setup (){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        //eger Test methodumuzda hic bir test yoksa, test calistiktan sonra
        //hic bir problemle karsilasilmadigini raporlamak icin
        // "test passed yazisi cikar"
        //eger testleri if ile yaparsak test failed olsa bile
        //kodlar problemsiz calistigi icin kod calismasi bittiginde
        //ekranin sol alt kisminda passed yazacaktir

        driver.get("https://www.amazon.com");
        //url in https://www.facebook.com oldugunu test edin

        String expectedUrl="https://www.facebook.com";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertEquals("URL beklenenden farkli",expectedUrl,actualUrl);


    }











}
