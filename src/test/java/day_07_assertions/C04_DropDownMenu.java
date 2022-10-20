package day_07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownMenu {
    //amazon a gidip dropdowndan books secenegini secip
    //java aratalim ve arama sonuclarinin Java icerdigini test ediniz
    WebDriver driver;

    @Before
    public void setup(){
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
    public void test() throws InterruptedException {
        driver.get("http://amazon.com");
        //1 secim yapmak istedigimiz butonu locate edelim
        WebElement buton=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        //2 Select objesi olusturalim ve icine locate ettigimiz elementi yazalim
        Select select=new Select(buton);
        //3 dropdown da var olan opsionlardan bir tanesini secelim
          select.selectByVisibleText("Books");
        //select.selectByIndex(5);//index
        //select.selectByValue("search-alias=stripbooks-intl-ship");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("java"+ Keys.ENTER);
        Thread.sleep(2000);
        WebElement aramaSonuclari=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String arananKelime="java";
        String sonucYazisi=aramaSonuclari.getText();
        Thread.sleep(2000);
        Assert.assertTrue(sonucYazisi.contains(arananKelime));



    }








}
