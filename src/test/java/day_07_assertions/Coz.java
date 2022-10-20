package day_07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Coz {
    WebDriver driver;
    @Before
public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

}

    @After
    public void tearDown() {
        driver.close();

    }

    @Test
    public void test1() {

       // https://www.amazon.com/ adresine gidin.
       // - Test 1
       // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
       // oldugunu test edin
       //         -Test 2
       // 1. Kategori menusunden Books secenegini secin
       // 2. Arama kutusuna Java yazin ve aratin
       // 3. Bulunan sonuc sayisini yazdirin
       // 4. Sonucun Java kelimesini icerdigini test edin

    }
}
