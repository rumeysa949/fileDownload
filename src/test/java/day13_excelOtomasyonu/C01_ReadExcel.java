package day13_excelOtomasyonu;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C01_ReadExcel {

    @Test

    public void readExcelTesti() throws IOException {

        String dosyaYolu = "src/test/java/day13_excelOtomasyonu/ulkeler.xlsx";

        FileInputStream fis =new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        // olusturduguuz workbook online olarak excel dosyasina erismez
        //20.satirda file input stream kullanarak exceldeki bilgileri aldik
        //sonra kodlarimizin icinde fiziki excel dosyasinin kopyasini olusturmus olduk

        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(3);// index
        Cell cell = row.getCell(3);// index

        System.out.println(cell); // Cezayir



        // 1. satirdaki 2. hucreye gidelim ve yazdiralim

        System.out.println(sheet.getRow(0).getCell(1)); // Baskent (Ingilizce)

        // 1. satirdaki 2. hucreyi bir string degiskene atayalim ve yazdiralim

        String istenenData = String.valueOf(sheet.getRow(0).getCell(1)).toString();

        // 2. satir 4.cell'in Afganistan'in baskenti oldugunu test edelim

        String expectedData = "Kabil";
        String actualData = sheet.getRow(1).getCell(3).toString();
        Assert.assertEquals(expectedData,actualData);

        // Satir sayisini bulalim

        System.out.println(sheet.getLastRowNum()+1);// method 190 yani son satirin index'ini verir
        // biz satir sayisi bulmak icin 1 ekledik

        // Fiziki olarak kullanilan satir sayisini bulun

        System.out.println(sheet.getPhysicalNumberOfRows()); //direkt fiziki olarak kullanilan satir sayisini yazdi

        // Ingilizce ulke isimleri ve baskentleri bir map olarak kaydedelim

        String isim;
        String baskent;
        Map<String,String> ulkelerMap = new TreeMap<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            isim = sheet.getRow(i).getCell(0).toString();
            baskent = sheet.getRow(i).getCell(1).toString();

            ulkelerMap.put(isim,baskent);


        }


        // Ulkeler excel'inde Canada isimli bir ulke oldugunu test edin

        Assert.assertTrue(ulkelerMap.containsKey("Canada"));


        // Ulkeler excel'inde Cuba'nin baskentinin Havaan oldugunuu test edin

        String expectedBaskent = "Havana";
        String actualBaskent = ulkelerMap.get("Cuba");

        Assert.assertEquals(expectedBaskent,actualBaskent);









    }





}
