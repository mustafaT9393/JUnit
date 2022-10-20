package day05_practis;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

public class C02_Deneme extends TestBaseBeforeAfter {
    @Test
    public void test() {
        // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
// 2. JavaScript alertin "CLICK ME!" seçeneğine tıklayın
        driver.findElement(By.xpath("//span[@id='button1']")).click();
// 3. Açılır metni alın
      String actualAllertMetin=  driver.switchTo().alert().getText();
      String expectedData="I am an alert box!";
// 4. Mesajın "I am an alert box!" olduğunu doğrulayın.
        Assert.assertEquals(expectedData,actualAllertMetin);
// 5. Açılır pencereyi kabul edin
        driver.switchTo().alert().accept();
    }
}
