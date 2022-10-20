package day_14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void test() throws IOException {
        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/Kitap1.xlsx";
        //8.FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //9.Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);
        //11.Sheet objesi olusturun workbook.getSheetAt(index)
        //12.Row objesi olusturun sheet.getRow(index)
        //13.Cell objesi olusturun row.getCell(index)
            String actualData=workbook
                    .getSheet("Sayfa1")
                    .getRow(1)
                    .getCell(1)
                    .toString();
            String expectedData="osman";
        Assert.assertEquals(expectedData,actualData);




    }
}