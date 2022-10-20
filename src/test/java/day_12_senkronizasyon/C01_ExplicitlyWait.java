package day_12_senkronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBaseBeforeAfter {
    @Test
    public void implicitWaitTesti() {
 //  2. Iki tane metod olusturun : implicitWait() , explicitWait()
 //  Iki metod icin de asagidaki adimlari test edin.
 //  3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
 //  4. Remove butonuna basin.
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
 //  5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneMesajiElementi=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsGoneMesajiElementi.isDisplayed());
 //  6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

 //  7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackMesajiElementi=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsBackMesajiElementi.isDisplayed());

    }

    @Test
    public void explicitWaitTesti() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();


        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        //WebElement itsGoneMesajiElementi=driver.findElement(By.xpath("//p[@id='message']"));

        /* WebElement itsGoneMesajiElementi=driver.findElement(By.xpath("//p[@id='message']"));
        wait.until(ExpectedConditions.visibilityOf(itsGoneMesajiElementi));

        yazinin gorunur olmasini beklerken yazinin locatini kullanmak
        sorun olusturur.cunki henuz gorulmeyen bir yazinin locate
        edilmeside mumkun olmayabilir.bu durumda bekleme islemi ve
         locati birlikte yapmaliyiz
        * */

        WebElement itsGoneMesajiElementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        Assert.assertTrue(itsGoneMesajiElementi.isDisplayed());


         driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();



         WebElement itsBackMesajiElementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
         Assert.assertTrue(itsBackMesajiElementi.isDisplayed());







    }
}
