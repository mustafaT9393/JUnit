package day_08_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Allerts {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterClass
    public static void tearDown() {
        //driver.close();

    }

    @Test
    public void test1() {
//● https://the-internet.herokuapp.com/javascript_alerts
// adresine gidin.
//● Bir metod olusturun: acceptAlert
//○1. butona tıklayın, yuarıdaki OK butonuna tıklayın ve
// result mesajının
//“You successfully clicked an alert” oldugunu test edin.
        WebElement buton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        buton.click();
        driver.switchTo().alert().accept();
        WebElement actualtResulMesaj = driver.findElement(By.xpath("//p[@id='result']"));
        String actualMesajYazisi = actualtResulMesaj.getText();
        String expectedMesajYazisi = "You successfully clicked an alert";
        Assert.assertEquals(expectedMesajYazisi, actualMesajYazisi);

    }

    @Test
    public void test2() {
        //● Bir metod olusturun: dismissAlert
//○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın
// ve result mesajının
//“successfuly” icermedigini test edin.
       WebElement ikinciButon= driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
       ikinciButon.click();
       driver.switchTo().alert().dismiss();
       WebElement result= driver.findElement(By.xpath("//p[@id='result']"));
       String actualMesaj=result.getText();
       String arananKelime="successfuly";
       Assert.assertFalse(actualMesaj.contains(arananKelime));

    }

    @Test
    public void test3() throws InterruptedException {
        //● Bir metod olusturun: sendKeysAlert
//○ 3. butona tıklayın, yarıdaki metin kutusuna
// isminizi yazin, OK butonuna
//tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
    driver.switchTo().alert().sendKeys("Mustafagmail.com");
    Thread.sleep(3000);
    driver.switchTo().alert().accept();
    WebElement resulActual= driver.findElement(By.xpath("//p[@id=\"result\"]"));
    String result= resulActual.getText();
    String girilenMail="Mustafagmail.com";
    Assert.assertTrue(result.contains(girilenMail));







    }



}