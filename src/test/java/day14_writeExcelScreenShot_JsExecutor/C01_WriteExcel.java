package day14_writeExcelScreenShot_JsExecutor;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcel {

    @Test
    public void excelTest() throws IOException {

        //3 adimlari takip edip  Sayfa1'deki 1. satira  kadar gidelim
        String dosyaYolu = "src/test/java/day13_excelOtomasyonu/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        //4 5. hucreye yeni bir cell olusturalim
        sayfa1.getRow(0).createCell(4);
        //5 olusturudugumuz hucreye "Nufus" yazdiralim
        sayfa1.getRow(0).getCell(4).setCellValue("Nufus");
        //6 2. satir nufus kolonuna 1500000 yazdiralim
        sayfa1.getRow(1).createCell(4).setCellValue("1500000");
        //7 10. satir nufus kolonuna 250000 yazdiralim
        sayfa1.getRow(9).createCell(4).setCellValue("250000");
        //8 15. satir nufus kolonuna 54000 yazdiralim
        sayfa1.getRow(14).createCell(4).setCellValue("54000");
        //9 dosyayi kaydedelim
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);

        //10 dosyayi kapatalim
        fis.close();
        fos.close();
        workbook.close();
    }
}
