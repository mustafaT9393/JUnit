package day05_practis;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeAfter;

public class C01_Deneme extends TestBaseBeforeAfter {
    @Test
    public void test() {
        // ...Exercise3...
// go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
//fill the firstname
        WebElement isimBox=driver.findElement(By.xpath("//input[@name='firstname']"));
        isimBox.sendKeys("mustafa");
        Actions actions=new Actions(driver);

//fill the lastname
        actions.sendKeys(Keys.TAB).sendKeys("Turk").perform();

//check the gender
        WebElement cinsiyetButton= driver.findElement(By.xpath("//input[@id='sex-0']"));
        cinsiyetButton.click();

//check the experience
        WebElement secim= driver.findElement(By.xpath("//input[@id='exp-2']"));
        secim.click();
//fill the date
        WebElement dateButton= driver.findElement(By.xpath("//input[@id='datepicker']"));
        dateButton.sendKeys("02.05.2022");
//choose your profession -> Automation Tester
        driver.findElement(By.xpath("//input[@id='profession-1']")).click();
//choose your tool -> Selenium Webdriver
        driver.findElement(By.xpath("//input[@id='tool-2']")).click();
//choose your continent -> Antartica
        WebElement secim2=driver.findElement(By.xpath("//select[@id='continents']"));
        secim2.click();
        Select select=new Select(secim2);
        select.selectByVisibleText("Antartica");

//choose your command  -> Browser Commands
        driver.findElement(By.xpath("//select[@id='selenium_commands']/option[1]")).click();
//click submit button

    }
}
