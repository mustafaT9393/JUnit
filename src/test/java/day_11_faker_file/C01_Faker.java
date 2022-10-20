package day_11_faker_file;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C01_Faker extends TestBaseBeforeAfter {

    @Test
    public void test() throws InterruptedException {
        //facebook gorevini faker olarak yapalim
        driver.get("https://www.facebook.com");

        WebElement kayitButonu=driver.findElement(By.xpath("(//a[@role='button'])[2]"));
        kayitButonu.click();
        WebElement isimKutusu= driver.findElement(By.xpath("(//input[@type='text'])[2]"));


        Faker faker=new Faker();
        Actions actions=new Actions(driver);

     String fakeMail=faker.internet().emailAddress();
        actions.click(isimKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeMail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeMail)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
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
        Thread.sleep(5000);







    }
}
