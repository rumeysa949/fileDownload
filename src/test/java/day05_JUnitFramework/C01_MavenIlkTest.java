package day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        /*
        17. satiri yazmamiz mecburi degildir
        Selenium 4.8 versiyonundan itibaren kendi WebDriver;ini olusturmustur
        Biz 17. satirdakii gibi disardan bir WebDriver tanimlamazsak
        Selenium otomatik olarak kendi WebDriver'ini devreye sokar
         */

        //2- arama kutusunu locate edelim
        WebElement aramaKutusu;
        aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        //3- "Samsung headphones " ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);

        //4- Bulunan sonuc sayisini yazdirin
        WebElement sonucYaziElementi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucYaziElementi.getText());


        //5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[1]")).click();

        //6-Bir onceki sayfaya donup sayfadaki tum basliklari yazdiralim
        driver.navigate().back();

        List<WebElement> baslikElementleri;
        baslikElementleri = driver.findElements(By.xpath("//div[@class='a-section a-spacing-double-large']"));

        for (int i = 0; i< baslikElementleri.size(); i++){
            System.out.println(i +"-"+ baslikElementleri.get(i).getText());
        }







        ReusableMethods.bekle(5);
        driver.close();

    }
}
