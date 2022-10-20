package day_15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C03_IstenenWebElementSS extends TestBaseBeforeAfter {
    @Test
    public void test() throws IOException {
     //amazona gidip nutella aratalim ve sonuc sayisinin oldugu
     // WebElementin fotografini cekelim
        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        String tarih=date.format(dtf);
        System.out.println("tarih = " + tarih);

        driver.get("https://www.amazon.com");
        WebElement sorchBox = driver.findElement(By.id("twotabsearchtextbox"));
        sorchBox.sendKeys("Nutella");
        sorchBox.sendKeys(Keys.ENTER);


        WebElement sonucText= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        File temp=sonucText.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp,new File("target/ekranGoruntuleri/tumSayfa"+tarih+".jpg"));

    }
}
