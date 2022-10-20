package day_11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void test() {
        System.out.println(System.getProperty("user.dir"));//C:\Users\TOSHIBA PC\IdeaProjects\com.Junit
        //bana icimde oldugum projenin dosya yolunu(path) verir
        System.out.println(System.getProperty("user.home"));//C:\Users\TOSHIBA PC
        //bilgisayarimin bana ozel kismini verdi


        //masa ustumuzdeki text1 dosyamizin varligini test edelim

       // "C:\Users\TOSHIBA PC\Desktop\txt1.txt"
        /*Bilgisayarimizdaki bir dosyanin varligini test etmek icin
        once o dosyaya ulasmamiz gerekir.Javada dosyaya erisim icin dosya
        yoluna(path) ihtiyac vardir.Her bilgisayarin kullanici
        adi farkli olacagindan masaustu dosya yoluda birbirlerinden
        farkli lacaktir.Testlerimizin tum bilgisayarlarda calismasi icin
        dosya yolunu DINAMIK yapmak zorundayiz
        Bunun icin asagidaki sekilde dinamik yazmaliyiz
        *
        * */
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Desktop\\text1.txt";

        String dosyaYolu=farkliKisim+ortakKisim;

        System.out.println(dosyaYolu);
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
