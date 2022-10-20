package day_09_handleWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_HandleWindows {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @After
    public void tearDown(){
       driver.close();
    }

    @Test
    public void test1() {
     driver.get("https://amazon.com");
        System.out.println(driver.getWindowHandle());//CDwindow-199310BB4BC160CD4BC257B3106D168B
        /*Bu kod acilan sayfanin unique hash kodudur
        Selenium sayfalar arasi geciste bu window hande degerini kullanir
        sayfalar arasi geziniyorsak ve herhangi bir sayfadan suanki
        sayfaya gecmek istersek
        driver.switchTo().window("CDwindow-199310BB4BC160CD4BC257B3106D168B");
        o sayfanin window handle degerini girerek o sayfaya
         gecisi saglaya biliriz
         * */
        //amzona gidip nutellla icin arama yaptirin
       String ilkSayfaHandleDegeri= driver.getWindowHandle();
       driver.findElement(By.id("twotabsearchtextbox")).
               sendKeys("nutella"+ Keys.ENTER);

       //ilk urunun resmini tiklayarak farkli bir tab olarak acin
       WebElement ilkUrunResmi =driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
       driver.switchTo().newWindow(WindowType.TAB);
       //bu komutu kullandigimizda driver otomatik olarak olusturulan
        //new taba gecer yani tabda gorevi gerceklestirmek icin
        //adimlari bastan almamiz gerekir
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).
                sendKeys("nutella"+ Keys.ENTER);
        WebElement ilkUrunResmi1=driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
        ilkUrunResmi1.click();


        //yeni tabda acilan urunun basligini yazdirin
        WebElement urunBasligi=driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println("urunBasligi = " + urunBasligi.getText());
        //ilk sayfaya gecip url i yazdiralim
        driver.switchTo().window(ilkSayfaHandleDegeri);
        System.out.println(driver.getCurrentUrl());







    }
}
