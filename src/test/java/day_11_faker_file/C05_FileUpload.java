package day_11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C05_FileUpload extends TestBaseBeforeAfter {

    @Test
    public void test() throws InterruptedException {
 //2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
 //3. chooseFile butonuna basalim

 //4. Yuklemek istediginiz dosyayi secelim.
        /*Bu islemi seleniumile yapma imkanimiz yok
        cunku web tabanli bir uygulama degil.bu durumda
        sendKeys() imdadimiza yetisir.
        eger chooseFile butonuna var olan bir dosyanin
        dosya yolunu yollarsaniz secme islemi otomatik
        olarak yapilmis olacaktir
       */
        // 1.adim= chooseFile butonunu locate edelim
        WebElement dosyaSecButonu=driver.findElement(By.id("file-upload"));

        //2.adim=yuklenecek dosyanin dosya yolunu olusturalim
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Desktop\\text1.txt";
        String yuklenecekDosyaYolu=farkliKisim+ortakKisim;
        //3.adim=sendKeys() ile dosya yolunu secme butonuna yollayalim
        dosyaSecButonu.sendKeys(yuklenecekDosyaYolu);
        Thread.sleep(5000);

        //5. Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //6. “File Uploaded!” textinin goruntulendigini test edelim
        WebElement fileUploadedYazisiElementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedYazisiElementi.isDisplayed());




   
    }
}
