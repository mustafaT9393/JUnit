package day_05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_SoruCozum {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



       // 1 https://www.amazon.com/ sayfasina gidelim
       // 2 arama kutusunu locate edelim
       // 3 “Samsung headphones” ile arama yapalim
       // 4 Bulunan sonuc sayisini yazdiralim
       // 5 Ilk urunu tiklayalim
       // 6 Sayfadaki tum basliklari yazdiralim
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);
        Thread.sleep(1000);
        WebElement sonucYazisi=driver.findElement(By.xpath("//*[text()=\"1-16 of 252 results for\"]"));
        Thread.sleep(1000);
        System.out.println("Bulunan urun sayisi:"+sonucYazisi.getText());
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

        System.out.println("=============h2===================");
        List<WebElement> basliklar2=driver.findElements(By.tagName("h2"));
        for (int i = 0; i <basliklar2.size() ; i++) {
            System.out.println(basliklar2.get(i).getText());
        }
        System.out.println("=============h1===================");
        List<WebElement> basliklar1=driver.findElements(By.tagName("h1"));
        for (int i = 0; i <basliklar1.size() ; i++) {
            System.out.println(basliklar1.get(i).getText());
        }
        System.out.println("=============h3===================");
        List<WebElement> basliklar3=driver.findElements(By.tagName("h3"));
        for (int i = 0; i <basliklar3.size() ; i++) {
            System.out.println(basliklar3.get(i).getText());
        }

        driver.close();

    }
}
