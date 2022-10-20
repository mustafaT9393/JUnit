package day_11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBaseBeforeAfter {


    @Test
    public void test() throws InterruptedException {
        //  2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //  3. LambdaTest.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='LambdaTest.txt']")).click();
        Thread.sleep(7000);
        //  4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Downloads\\LambdaTest.txt";
        String indirdigimDosyaninYolu=farkliKisim+ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(indirdigimDosyaninYolu)));






    }
}
