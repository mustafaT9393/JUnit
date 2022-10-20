package day_07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05_DropDownOptions {
    /*
     * amazon ana sayfaya gidip dropdown menuden books u secelim
     * sectigimiz option u yazdiralim.dropdowndaki opsiyonlarin
     * toplam sayisinin 20 oldugunu test edin.
     */
   WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.close();
    }
    @Test
    public void method1(){
        driver.get("http://amazon.com");
        WebElement buton=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(buton);
        select.selectByVisibleText("Books");

        //bir drop down ile calisiyorken son secilen optiona ulasmak
        //isterseniz select.getFirstSelectedOption() metodunu kullanmalisiniz
        //bu method bize webelement dondurur.uzerindeki yaziyi yazdirmak icin
        //getText() unutulmamalidir
        System.out.println(select.getFirstSelectedOption().getText());

        List<WebElement> optionlarListesi=select.getOptions();

        int actualOptionSayisi=optionlarListesi.size();
        System.out.println("===========================");
        System.out.println(actualOptionSayisi);
        System.out.println("===========================");
        int expectedOptionSayisi=28;

        //Assert.assertTrue(actualOptionSayisi==expectedOptionSayisi);
        Assert.assertEquals(actualOptionSayisi, expectedOptionSayisi);












    }
}