package day_09_handleWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HandleWindows {
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
       driver.quit();
}

    @Test
    public void test1() throws InterruptedException {
        //amazon ana sayfaya gidelim
        driver.get("https://www.amazon.com");
        String ilkSayfaHasKodu=driver.getWindowHandle();
        //url in amazon icerdigini test edelim
        String url=driver.getCurrentUrl();
        String arananKelime="amazon";
        Thread.sleep(2000);
        Assert.assertTrue(url.contains(arananKelime));
        //yeni bir pencere acip bestbuy ana sayfasina gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.bestbuy.com");
        Thread.sleep(2000);
        String ikinciSyfaHasKodu=driver.getWindowHandle();
        //titlenin bestbuy icerdigini test edelim
        String actualTitle= driver.getTitle();
        String expectedTitle="Best Buy";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //ilk sayfaya donup sayfada Java aratalim
        driver.switchTo().window(ilkSayfaHasKodu);
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);
        Thread.sleep(2000);
        //arama sonuclarinin Java icerdigini test edelim
        WebElement aramaSonuclari= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String aramaSonuclariii=aramaSonuclari.getText();
        String arananKelime1="Java";
        Assert.assertTrue(aramaSonuclariii.contains(arananKelime1));
        //yeniden bestbuy in acik oldugu sayfaya gidelim
        driver.switchTo().window(ikinciSyfaHasKodu);
        //logonun gorundugunu test edelim
        WebElement logo= driver.findElement(By.xpath("(//img[@width='80'])[1]"));
        Assert.assertTrue(logo.isDisplayed());





    }
}
