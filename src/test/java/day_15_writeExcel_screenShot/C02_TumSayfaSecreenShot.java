package day_15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_TumSayfaSecreenShot extends TestBaseBeforeAfter {
    @Test
    public void test() throws IOException {
        //Amazon sayfasina gidip tum sayfanin fotografini cekiniz

        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        String tarih=date.format(dtf);
        System.out.println("tarih = " + tarih);

        driver.get("https://www.amazon.com");
        TakesScreenshot ts= (TakesScreenshot) driver;
        File gecıcıDosya=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile( gecıcıDosya,new File("target/ekranGoruntuleri/tumSayfa"+tarih+".jpg"));




    }
}
