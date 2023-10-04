package day07_assertions_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assert{
static WebDriver driver;



    @BeforeClass

    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.bestbuy.com/");

    }

    @AfterClass
    public static void teardown(){
        driver.close();


    }

    @Test
    public void urlTest(){

        //2) https://www.bestbuy.com/ Adresine gidin
        //   farkli test method’lari olusturarak asagidaki testleri yapin
        //      ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin

        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();

       Assert.assertEquals(expectedUrl,actualUrl);}

       @Test
       public void titleTesti(){

            //      ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin

            String  unexpectedTitleIcerik = "Rest";
            String actualTitle = driver.getTitle();

            Assert.assertFalse(actualTitle.contains(unexpectedTitleIcerik));



        }
        @Test
       public void logoTesti(){

          // logoTest ==> BestBuy logosunun goruntulendigini test edin


            WebElement logoElementi = driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M89.75 30.')]"));

            Assert.assertTrue(logoElementi.isDisplayed());
   }

       //  @Test
   // public void francaisTesti(){

       // WebElement francaisLinkElementi = driver.findElement(By.xpath("//button[normalize-space()='Français']"));

      //  Assert.assertFalse(francaisLinkElementi.isDisplayed());


       //  }










        //      ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin








    }

