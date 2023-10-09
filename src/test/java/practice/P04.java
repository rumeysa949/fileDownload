package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P04 {
    static WebDriver driver;
    double result;

    /*

    // ilgili kurulumlari tamamlayalim
// Kullanici https://www.google.com adresine gider
// Çıkıyorsa Kullanici cookies i kabul eder
// Arama Kutusuna karşilastirma yapmak istedigi para birimlerini girer
// Para birimlerinin karsilastirmasini alin
// Karsilastirilacak olan para biriminin 25 den kUCUk oldygu test edilir
     */

    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

   // @After
    //public void teardown(){
    //   // driver.close();
   // }

    @Test
    public void test01(){
        driver.get("https://www.google.com");
        WebElement searchbox;
        searchbox = driver.findElement(By.xpath("/*[@name='csi']"));
        searchbox.sendKeys("USD to TRY"+ Keys.ENTER);

        WebElement resultMoney = driver.findElement(By.xpath("/*[@class='DFlfde SwHCTb']"));
        String result = resultMoney.getText().replace(",",",");



        double resultDouble = Double.parseDouble(result);
        Assert.assertTrue(resultDouble>25);
    }


}
