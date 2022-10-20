package day_09_handleWindows;

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
import java.util.Set;

public class C03_WindowHandels {

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
        //driver.quit();
    }
    @Test
    public void test1() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text=driver.findElement(By.xpath("//*[text()='Opening a new window']"));
        String texyYaziIcerigi=text.getText();
        String expectedText="Opening a new window";
        Assert.assertEquals(texyYaziIcerigi,expectedText);
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String sayfaBasligi=driver.getTitle();
        String expectedSayfaBasligi="The Internet";
        Assert.assertEquals(sayfaBasligi,expectedSayfaBasligi);
        //● Click Here butonuna basın.

        String ilkSayfaninHandleKodu=driver.getWindowHandle();


        driver.findElement(By.xpath("(//a[@target='_blank'])[1]")).click();
        Set<String> tumPencerelerinHasKodu=driver.getWindowHandles();

        String ikinciSayfaninHandleKodu="";

        /*acik olan tum sayfalarin has kodunu aldik.direk
        alamadigimiz ikinci sayfanin handle kodunu for each yaparak
        aldik
        * */

        for (String each:tumPencerelerinHasKodu)
              {
           if(!each.equals(ilkSayfaninHandleKodu)){
                ikinciSayfaninHandleKodu=each;

              }
        }

        driver.switchTo().window(ikinciSayfaninHandleKodu);
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        /*
        * swichTo().newWindow() demeden link tiklayarak yeni tab veya
        * window olustugunda biz driver a yeni sayfaya gec demedikce
        * driver eski sayfada kalir.yeni sayfada driver i calistirmak
        * isterseniz once driveri yeni sayfaya yollamalisiniz.
        * */
        String yeniPencereBaslik=driver.getTitle();

        String expectedYeniBaslik="New Window";
        Assert.assertEquals(yeniPencereBaslik,expectedYeniBaslik);
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement yazi=driver.findElement(By.tagName("h3"));
        String yazi1=yazi.getText();
        String expectedYazi="New Window";
        Assert.assertEquals(yazi1,expectedYazi);


        //● Bir önceki pencereye geri döndükten sonra sayfa
        // başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(ilkSayfaninHandleKodu);

         sayfaBasligi=driver.getTitle();
        expectedSayfaBasligi="The Internet";
        Assert.assertEquals(sayfaBasligi,expectedSayfaBasligi);






    }
}
