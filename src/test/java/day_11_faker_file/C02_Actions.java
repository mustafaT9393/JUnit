package day_11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C02_Actions extends TestBaseBeforeAfter {
    @Test
    public void test() throws InterruptedException {  // Bir Class olusturalim KeyboardActions2
       //2https://html.com/tags/iframe/ sayfasina gidelim
       driver.get("https://html.com/tags/iframe/");
       //3- video’yu gorecek kadar asagi inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();

        Thread.sleep(2000);

        WebElement ifrime= driver.findElement(By.xpath("//iframe[@src=" +
                "'https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(ifrime);
        //4 videoyu izlemek icin Play tusuna basin
        driver.findElement(By.xpath("//button[@class='ytp-large-play-b" +
                "utton ytp-button ytp-large-play-button-red-bg']")).click();

        //5 videoyu calistirdiginizi test edin
        WebElement youTubeLogosu=driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youTubeLogosu.isDisplayed());




    }



}
