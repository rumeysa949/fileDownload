package day12_cookies_webTable;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_KlasikWebTable extends TestBase {

    @Test

    public void test01() {

        //amazon adresine gidin

        driver.get("https://www.amazon.com");

        //sayfanin en altina gidin

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        bekle(3);

        //WebTable tum body'sini yazdirin
        WebElement tumBodyElementi =  driver.findElement(By.xpath("//tbody"));

        System.out.println(tumBodyElementi.getText());

        bekle(2);





        //Web table'daki satir sayisinin 9 oldugunu test edin

        List<WebElement> satirlarListesi = driver.findElements(By.xpath("/tbody/tr"));

        int expectedSatirSayisi = 9;
        int actualSatirSayisi = satirlarListesi.size();

        Assert.assertEquals(expectedSatirSayisi, actualSatirSayisi);

        bekle(1);

        //Tum satirlari yazdirin

        for (int i = 0; i < satirlarListesi.size(); i++) {

            System.out.println((i + 1) + ".ci satir :" + satirlarListesi.get(i).getText());
        }

        //  Web table'daki sutun sayisinin 13 oldugunu test edin

        List<WebElement> birinciSatirDataList = driver.findElements(By.xpath("/tr[1]/td"));

        int expectedSutunSayisi = 13;
        int actualSutunSayisi = birinciSatirDataList.size();

        Assert.assertEquals(expectedSutunSayisi, actualSutunSayisi);

        // 5. sutunu yazdirin.
        List<WebElement> besinciSutunDataList = driver.findElements(By.xpath("/tr/td[5]"));

        System.out.println("===== 5. sutun =====");

        for (WebElement each : besinciSutunDataList
        ) {

            System.out.println(each.getText());
        }
// Satir ve sutun sayisini parametre olarak alip ,
        // hucredeki bilgiyi String olarak denduren bir method olusturun


        System.out.println("=====method ile gele datalar=====");
        System.out.println(hucredekiBilgi(3, 5));


    }




public String hucredekiBilgi(int satirNO , int sutunNO){

        String dinamikXPath = "//tr[" + satirNO + "]/td[" + sutunNO + "]";

        WebElement istenenDataElementi = driver.findElement(By.xpath(dinamikXPath));

        return istenenDataElementi.getText();






}



    }





















