package day_14_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel  {
    @Test
    public void test() throws IOException {
 //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/Kitap1.xlsx";
 //8.FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis= new FileInputStream(dosyaYolu);
 //9.Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fis);

 //11.Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet= workbook.getSheet("Sayfa1");
 //12.Row objesi olusturun sheet.getRow(index)
        Row row=sheet.getRow(1);
 //13.Cell objesi olusturun row.getCell(index)
        Cell cell= row.getCell(1);
        System.out.println("cell = " + cell);

        String actualData=cell.toString();
        String expectedData="osman";
        Assert.assertEquals(expectedData,actualData);







    }
}
