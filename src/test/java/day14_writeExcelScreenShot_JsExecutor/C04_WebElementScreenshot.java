package day14_writeExcelScreenShot_JsExecutor;


import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class C04_WebElementScreenshot extends TestBase {

    @Test
    public void test01() throws IOException {

        // Amazon'a gidelim

        driver.get("https://www.amazon.com");


        //Nutella icin arama yapalim

       WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[1]"));
        String expectedIcerik ="Nutella";
        String actualSonucYazisi = sonucYaziElementi.getText();
       Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        //Sonuclarin Nutella icerdigini test edelim

        //Rapora eklemek icin sonuc yazisinin screenshot'ini alalim

        File sonucYazisiSS = new File("target/screenShots/sonucYazisi.jpg");

        File geciciResim = sonucYaziElementi.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciResim,sonucYazisiSS);

        ReusableMethods.webElementFotografCek(sonucYaziElementi,"NutellaArama");



    }
}
