package day_13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C02_WebTables extends TestBaseBeforeAfter {

    @Test
    public void login() throws InterruptedException {
// login( ) metodun oluşturun ve oturum açın.
// https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
// Username : manager
// Password : Manager1!

        girisYap();

        // table( ) metodu oluşturun
// Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody

        List<WebElement> sutunBasliklariListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Sutun Sayisi : " + sutunBasliklariListesi.size());
// Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement tumBady=driver.findElement(By.xpath("//tbody"));
        System.out.println("Tum Bady : " + tumBady.getText());

// table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirlarListesi=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satirlar Sayisi : " + satirlarListesi.size());


// Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement each:satirlarListesi) {
            System.out.println(each.getText());
        }

// 4.satirdaki(row) elementleri konsolda yazdırın
        List<WebElement> hucreListesi=driver.findElements(By.xpath("//tbody//tr[4]//td"));
        for (WebElement each:hucreListesi)
              {
                  System.out.println(each.getText());
        }
//Email basliginin altindaki tum elemanlari(sutun) yazdiriniz

        List<WebElement>basliklarListesi=driver.findElements(By.xpath("//thead//tr[1]//th"));
        int emailSutunNo=0;
        for (int i = 0; i < basliklarListesi.size(); i++) {
            if (basliklarListesi.get(i).getText().equals("Email")){
             emailSutunNo=i;
            }

        }

        List<WebElement> emailinSutunListesi=driver.findElements(By.xpath("//tbody//td["+(emailSutunNo+1)+"]"));
        for (WebElement each:emailinSutunListesi) {
            System.out.println(each.getText());

        }


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