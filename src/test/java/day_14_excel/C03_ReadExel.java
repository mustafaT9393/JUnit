package day_14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExel {
    @Test
    public void exelTesti() throws IOException {
//input olarak verilen satirNo sutunNo degerlerinialip
//o celldeki(hucredeki)  datayi String olarak bize donduren bir method olusturun
int satirNo=2;
int sutunNo=2;
//donen Stringin osman oldugunu test edin
String expectedData="osman";

String actualData=banaDataGetir(satirNo-1,sutunNo-1);//cunku excel index ile calisir
Assert.assertEquals(expectedData, actualData);


    }

    private String banaDataGetir(int satirIndex, int sutunIndex) throws IOException {
        String istenenData="";
        String dosyaYolu = "src/resources/Kitap1.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        istenenData=workbook
                .getSheet("Sayfa1")
                .getRow(satirIndex)
                .getCell(sutunIndex)
                .toString();

     return istenenData;
    }
}
