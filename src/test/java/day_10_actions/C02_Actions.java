package day_10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BeforeClass_AfterClass;

public class C02_Actions extends BeforeClass_AfterClass {

//amazona gidelim account butonunda bekleyin acilan
//pencereden create a list'e tiklayin
    @Test
    public void test1() {
        driver.get("https://www.amazon.com");
        Actions actions=new Actions(driver);
        WebElement kutu=driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
        actions.moveToElement(kutu).perform();
        driver.findElement(By.xpath("(//span[@class='nav-text'])[1]")).click();






    }
}
