package day_06_radioButton_checkBox;

import dev.failsafe.internal.util.Durations;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {
    WebDriver driver;
//    1. Bir class oluşturun : RadioButtonTest
//2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
//- https://www.facebook.com adresine gidin
// - Cookies’i kabul edin
//- “Create an Account” button’una basin
//- “radio buttons” elementlerini locate edin
//- Secili degilse cinsiyet butonundan size uygun olani secin
    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        WebElement kadinButton = driver.findElement(By.xpath("(//label[@class='_58mt'])[1]"));
        WebElement erkekButton = driver.findElement(By.xpath("(//label[@class='_58mt'])[2]"));
        WebElement ozelButton = driver.findElement(By.xpath("(//label[@class='_58mt'])[3]"));
        Thread.sleep(5000);

        if (!erkekButton.isSelected()){
            erkekButton.click();
        }
    }





    @Before
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public  void tearDown(){

       driver.close();
    }













}
