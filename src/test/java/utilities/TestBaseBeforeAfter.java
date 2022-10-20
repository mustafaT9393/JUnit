package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBaseBeforeAfter {//abstract yaparak ıse bu classtan
    //obje uretılmesının onune gecmektır

    protected WebDriver driver;//protected yaparak farklı paketlerınde ulasmasına ızın verıyoruz

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @After
    public void tearDown(){

        //driver.close();
    }



}
