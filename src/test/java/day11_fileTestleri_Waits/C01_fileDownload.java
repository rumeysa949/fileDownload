package day11_fileTestleri_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_fileDownload extends TestBase {
//a[normalize-space()='logo.jpg']


    @Test
    public void indirmeTesti(){

        //  /Users/sumeyraaslan/Desktop/5mb script.xml
        //2. https://the-internet.herokuapp.com/download adresine gidelim

        driver.get("https://the-internet.herokuapp.com/download");

        bekle(1);

        driver.findElement(By.xpath("//a[text()='example.jpg']")).click();
bekle(5);

        String dosyaYolu = "/Users/sumeyraaslan/Downloads/example.jpg";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        bekle (2);









        //3. logo.jpg dosyasini indirelim










        //4. Dosyanin basariyla inirilip indirilmedigini test edelim







    }
}
