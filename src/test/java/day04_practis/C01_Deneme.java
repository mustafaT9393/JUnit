package day04_practis;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C01_Deneme extends TestBaseBeforeAfter {

    @Test
    public void test() {
        // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

// ikinci emojiye tıklayın (hayvan emojisini seçin)
   WebElement iframe= driver.findElement(By.xpath("//iframe[@id='emoojis']"));
   driver.switchTo().frame(iframe);
driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

// tüm hayvan emojilerine tıklayın
  List<WebElement>tumHayvanlar= driver.findElements(By.xpath("//div[@class='mdl-tabs__panel is-active']//img"));
 //      for (WebElement each:tumHayvanlar) {
 //          each.click();
 //      }

        //2.cozum lambda ile
        tumHayvanlar.forEach(t->t.click());
        driver.switchTo().defaultContent();

      // // formu doldurun (dilediğinizi yazabilirsiniz)
      // Actions actions=new Actions(driver);
      // driver.findElement(By.xpath("(//input[@type='text'])[1]")).click();
      // actions.sendKeys("birinci").
      // sendKeys(Keys.TAB).sendKeys("ikinci").
      // sendKeys(Keys.TAB).sendKeys("ucuncu").
      // sendKeys(Keys.TAB).sendKeys("dorduncu").
      // sendKeys(Keys.TAB).sendKeys("besinci").
      // sendKeys(Keys.TAB).sendKeys("altinci").
      // sendKeys(Keys.TAB).sendKeys("yedinci").
      // sendKeys(Keys.TAB).sendKeys("sekizinci").
      // sendKeys(Keys.TAB).sendKeys("dokuzuncu").
      // sendKeys(Keys.TAB).sendKeys("onuncu").
      // sendKeys(Keys.TAB).sendKeys("on birinci").

// apply butonuna tıklayın

      //  sendKeys(Keys.TAB).sendKeys(Keys.ENTER).
      //          perform();


        //ikinci yol
        List<WebElement> boxes=driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));//bu listte 11 kutucuk var

        List<String> kutularaGonderilecekYazilar=new ArrayList<String>(Arrays.asList("bir","iki","uc","dort","bes","alti","yedi","sekiz","dokuz","on","onbir"));
        for (int i = 0; i < boxes.size(); i++) {
        boxes.get(i).sendKeys(kutularaGonderilecekYazilar.get(i));
        }

        driver.findElement(By.xpath("//button[@id='send']")).click();



    }
}
