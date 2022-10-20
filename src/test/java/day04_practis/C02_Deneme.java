package day04_practis;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_Deneme {
    @Test
    public void deneme() {
        //Verify that we have pom.xml file in our project => please try in 4 min s
        //pom.xml in projede oldugunu dogrulayiniz

        String dosyaYolu="C:\\Users\\TOSHIBA PC\\IdeaProjects\\com.Junit\\pom.xml"; //copypathreferance den absulutparh yaparak aliriz

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }



}
