package day_05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_SoruCozum {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

      // 1. http://zero.webappsecurity.com sayfasina gidin
        driver.navigate().to("http://zero.webappsecurity.com");
      // 2. Signin buttonuna tiklayin
        Thread.sleep(1000);
        WebElement signinButonu=driver.findElement(By.xpath("//button[@id='signin_button']"));
        signinButonu.click();
        Thread.sleep(1000);

      // 3. Login alanine “username” yazdirin
        WebElement loginButton=driver.findElement(By.xpath("//input[@id='user_login']"));
        loginButton.sendKeys("username");
        Thread.sleep(1000);
      // 4. Password alanine “password” yazdirin
        WebElement paswordButton = driver.findElement(By.xpath("//input[@id='user_password']"));
        paswordButton.sendKeys("password");
        Thread.sleep(1000);
      // 5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(1000);
        driver.navigate().back();
       //6a.online btonuna basiniz
       driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();

        // 6b. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
        Thread.sleep(1000);
      // 7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement paraYazmaEkrani=driver.findElement(By.xpath("//input[@id='sp_amount']"));
        paraYazmaEkrani.sendKeys("500");
        Thread.sleep(1000);
        // 8. tarih kismina “2020-09-10” yazdirin
        WebElement tarihButonu=driver.findElement(By.xpath("//input[@id='sp_date']"));
        tarihButonu.sendKeys("2020-09-10");
      // 9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
      // 10. “The payment was successfully submitted.”
        // mesajinin ciktigini control edin
        WebElement SonucMesajiElementı=driver.findElement(By.xpath("//*[@title=\"$ 500 payed to payee sprint\"]"));

        if (SonucMesajiElementı.isDisplayed()) {
            System.out.println("beklenen mesaj passed");
        }
        else {
            System.out.println("beklenen mesaj failed");
        }
        driver.close();

    }
}
