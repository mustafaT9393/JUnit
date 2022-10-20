package day_10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BeforeClass_AfterClass;

import java.util.Set;

public class C03_Actions extends BeforeClass_AfterClass {

                String ilkSayfaHasKodu="";
    @Test
    public void test() throws InterruptedException {

    // 2https://the-internet.herokuapp.com/context_menu
        // sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
    // 3- Cizili alan uzerinde sag click yapalim
        WebElement ciziliAlan=driver.findElement(By.id("hot-spot"));
        Actions actions=new Actions(driver);
        actions.contextClick(ciziliAlan).perform();
        Thread.sleep(2000);
    // 4 Alert’te cikan yazinin “You selected a context menu”
        // oldugunu  test edelim.
        String expectedYazi="You selected a context menu";
        String actualYazi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi, actualYazi);

    // 5 Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        ilkSayfaHasKodu=driver.getWindowHandle();
        System.out.println("IlkSayfaHasKodu = " + ilkSayfaHasKodu);

    // 6 Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();


    // 7 Acilan sayfada h1 taginda “Elemental Selenium”
        // yazdigini test edelim
        Set<String> hasKodlariSeti=driver.getWindowHandles();
        System.out.println("hasKodlari = " + hasKodlariSeti);

        String ikinciSayfaHasKodu="";
        for (String each:hasKodlariSeti) {
            if (!each.equals(ilkSayfaHasKodu)){
                ikinciSayfaHasKodu=each;
            }

        }

        driver.switchTo().window(ikinciSayfaHasKodu);

        String expectedH1="Elemental Selenium";
        WebElement actualH1Tagi=driver.findElement(By.tagName("h1"));
        Assert.assertEquals(expectedH1, actualH1Tagi.getText());


    }
}
