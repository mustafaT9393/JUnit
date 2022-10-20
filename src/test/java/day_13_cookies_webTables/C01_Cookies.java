package day_13_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBaseBeforeAfter;

import java.util.Set;

public class C01_Cookies extends TestBaseBeforeAfter {

    @Test
    public void test() {

 //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
 //2tum cookie’leri listeleyin
        Set<Cookie> cerezler=driver.manage().getCookies();
        System.out.println(cerezler);
        int sayac=1;
        for (Cookie each : cerezler)
        {
            System.out.println(sayac+ ".cookie" +each);
            System.out.println("name :" +each.getName());
            System.out.println("value :"+each.getValue());
            sayac++;
        }



 //3 Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
     //1.yol==>
        System.out.println("sayac = " + sayac);
        Assert.assertTrue(sayac-1>5);
     //2.yol==>
       Assert.assertTrue(cerezler.size()>5);

 //4ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie  each:cerezler) {
          if (each.getName().equals("i18n-prefs")) {
              Assert.assertEquals("USD",each.getValue());
          }
        }

 //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
        //olusturun ve sayfaya ekleyin
       Cookie cerez=new Cookie("en sevdigim cookie","cikolatali" );
        driver.manage().addCookie(cerez);
        cerezler=driver.manage().getCookies();//cerezlerin guncel halini tekrar ayni Sete atiyoruz
        System.out.println(cerezler);
        int sayacYeni=1;
        for (Cookie each : cerezler)
        {
            System.out.println(sayacYeni+ ".cookie" +each);
            System.out.println("name :" +each.getName());
            System.out.println("value :"+each.getValue());
            sayacYeni++;
        }

        //6 eklediginiz cookie’nin sayfaya eklendigini test edin
       Assert.assertTrue(cerezler.contains(cerez));

 //7 ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(cerezler.contains("skin"));
 //8 tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cerezler=driver.manage().getCookies();
        Assert.assertTrue(cerezler.isEmpty());



    }
}
