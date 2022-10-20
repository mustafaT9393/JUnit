package day_13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_WebTables extends TestBaseBeforeAfter {

    @Test
    public void test() throws InterruptedException {

//onceki classdaki adrese gidip
//girisyap methodunu kullanarak sayfaya giris yapin input olarak verilen
//satir sayisi ve sutun sayisina sahip hucredeki text i yazdirin

  int satir=4;
  int sutun=4;

  girisYap();

  WebElement arananHucre= driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));

        System.out.println("Aranan Hucre Icerigi: "+arananHucre.getText());

    }
    public void girisYap() throws InterruptedException {
        driver.get("https://www.hotelmycamp.com");
        WebElement loginButonu = driver.findElement(By.xpath("(//a[@class='nav-link'])[7]"));


        Actions actions = new Actions(driver);
        actions.click(loginButonu).perform();
        WebElement usurNameBolmesi = driver.findElement(By.xpath("//input[@type='text']"));
        WebElement passworlBolmesi = driver.findElement(By.xpath("//input[@type='password']"));


        actions.click(usurNameBolmesi).sendKeys("manager")
                .click(passworlBolmesi).sendKeys("Manager1!")
                .sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);
    }


}
