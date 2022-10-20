package day_10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BeforeClass_AfterClass;

public class C04_ActionsDenemeSitesi extends BeforeClass_AfterClass {

    @Test
    public void test() {
        //1https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2Drog me butonunu tutup Drog here butonunun ustune birakalim
        Actions actions=new Actions(driver);
        WebElement kucukButon=driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement buyukButon= driver.findElement(By.xpath("(//div[@class='drop-box ui-droppable'])[1]"));

        actions.dragAndDrop(kucukButon,buyukButon).perform();

        //Drog here yazisi yerine Dropped! oldugunu test edelim

        WebElement actualSonucYazi=driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String actualSonucYazisi = actualSonucYazi.getText();
        String expectedSonucYazisi="Dropped!";
        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);









    }
}
