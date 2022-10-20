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

public class C04_Iframe {


    // Bir class olusturun: IframeTest
// https://the-internet.herokuapp.com/iframe adresine gidin.
// ● Bir metod olusturun: iframeTest
// “An IFrame containing….” textinin erisilebilir oldugunu
// test edin ve konsolda yazdirin.
// ○Text Box’a “Merhaba Dunya!” yazin.
//TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
// dogrulayin ve konsolda yazdirin
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
    public void test01() {
     driver.get("https://the-internet.herokuapp.com/iframe");
          WebElement yazi=driver.findElement(By.xpath("//h3"));
          Assert.assertTrue(yazi.isEnabled());
          System.out.println(yazi.getText());
          WebElement iFrameElementi=driver.findElement(By.id("mce_0_ifr"));


          driver.switchTo().frame(iFrameElementi);


          WebElement box=driver.findElement(By.xpath("//p"));
          box.clear();
          box.sendKeys("Hello, world!");
          //box'i dogru locate etmemize ragmen driver bulamadi
          //bunun uzerine HTML kodlari inceleyince box'in aslinda bir
          //iframe icerisinde oldugunu goduk.bu durumda once
          //ifram'i locate edip switchTo() ile ifram'e gecmeliyiz

          driver.switchTo().parentFrame();

          //yazi1 elemanini dogru locate etmemize ragmen yazdirmadi
          //cunku yukarida ifram'e gecis yapmistik, once oradan cikmaliyiz
          //driver.switchTo().defaultContent();(ana sayfaya doner) veya
          //driver.switchTo().parentFrame();(bir onceki ifram'e gec demek)
          //yaparak onceki ifram'e doneriz
          WebElement yazi1= driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
          Assert.assertTrue(yazi1.isDisplayed());
          System.out.println(yazi1.getText());



      }



}