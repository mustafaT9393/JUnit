package day_10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C06_KeyBoardActions extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {
        //facebook ana sayfaya gidin
        driver.get("https://www.facebook.com");
        //yeni kayit olustur butonuna basin
        WebElement kayitButonu=driver.findElement(By.xpath("(//a[@role='button'])[2]"));
        kayitButonu.click();
        //isim kutusunu locate edip
        WebElement isimKutusu= driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        isimKutusu.click();

        Actions actions=new Actions(driver);


        actions.click(isimKutusu)
                .sendKeys("mustafa")
                .sendKeys(Keys.TAB)
                .sendKeys("Kirazci")
                .sendKeys(Keys.TAB)
                .sendKeys("mustafa@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("mustafa@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("125478")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("23")
                .sendKeys(Keys.TAB)
                .sendKeys("05")
                .sendKeys(Keys.TAB)
                .sendKeys("2002")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

         //aciklama =>>  istedigimiz tusa bir kere basmak isin veya
         //bulundugumuz yere yazi gondermek icin .sendKeys() kullaniriz


        Thread.sleep(2000);
        //geriye kalan alanlari tab ile dolasarak formu doldurun






    }
}
