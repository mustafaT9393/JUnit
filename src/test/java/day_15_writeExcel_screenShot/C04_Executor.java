package day_15_writeExcel_screenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C04_Executor extends TestBaseBeforeAfter {
    @Test
    public void test() throws InterruptedException {
     //amazona gidelim
     driver.get("https://amazon.com");
     //asagidaki signin butonunu gorunceye kadar js ile scroll(kaydirma) yapalim


        WebElement signinButonu = driver.findElement(By.xpath("//span[@class='action-inner']"));
        Thread.sleep(2000);
        JavascriptExecutor jse=(JavascriptExecutor) driver;

        jse.executeScript("arguments[0].scrollIntoView(true);",signinButonu);
        //signin butonuna js ile click yapalim
        jse.executeScript("arguments[0].click();",signinButonu);
        Thread.sleep(2000);


    }
}
