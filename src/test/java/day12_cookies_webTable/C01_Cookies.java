package day12_cookies_webTable;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_Cookies extends TestBase {

    @Test
    public void cookieTesti() {

        //Amazon sayfasina gidin

        driver.get("https://www.amazon.com");

        // tum cookie'leri listeleyin

        Set<Cookie> cookieSeti = driver.manage().getCookies();
        //System.out.println(cookieSeti);
        // Bu sekilde yazdirinca kac ccokie oldugu ve bunlarin neler oldugu anlasilmiyor

        int siraNo = 1;
        for (Cookie each : cookieSeti
        ) {
            System.out.println(siraNo + "  -  " + each);
            siraNo++;


        }

        // sayfadaki cookie sayisinin 5'ten buyuk oldugunuu test edin

        int expectedMinCookieSayisi = 5;
        int actualCookieSayisi = cookieSeti.size();
        Assert.assertTrue(actualCookieSayisi > expectedMinCookieSayisi);

        // ismi i18n-prefs olan cookie degerinin USD oldugunuu test edin

        String expectedCookieValue = "USD";
        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();

        Assert.assertEquals(expectedCookieValue, actualCookieValue);


        // ismi "en sevdigim cookie" ve degeri "cikolatali" olan
        // bir cookie olusturun ve sayfaya ekleyin

        Cookie yeniCookie = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(yeniCookie);


        //eklediginiz cookie'nin sayfaya eklendigini test edin
        System.out.println("================Yeni cookie eklendikten sonra==============");

        cookieSeti = driver.manage().getCookies();
        siraNo = 1;

        for (Cookie each : cookieSeti
        ) {
            System.out.println(siraNo + "  -  " + each);
            siraNo++;


        }

        boolean yeniCookieEklendiMi = false;

        for (Cookie each : cookieSeti
        ) {
            if (each.getName().equals("en sevdigim cookie")) {
                yeniCookieEklendiMi = true;
            }
        }

        //yeni cookie eklenmisse yeniCookieEklendiMi' nin degeri true olmali
        Assert.assertTrue(yeniCookieEklendiMi);


        // ismi skin olan cookie'yi silin ve silindigini test edin

        driver.manage().deleteCookieNamed("skin");

        System.out.println("================skin silindikten  sonra==============");

        cookieSeti = driver.manage().getCookies();
        siraNo = 1;

        for (Cookie each : cookieSeti
        ) {
            System.out.println(siraNo + "  -  " + each);
            siraNo++;


        }

        boolean skinSilindiMi = true;

        for (Cookie each : cookieSeti
        ) {
            if (each.getName().equals("skin")) {
                skinSilindiMi = false;
            }
        }

        Assert.assertTrue(skinSilindiMi);





        ////tum cookie'lerii silin ve silindigini test edin


        driver.manage().deleteAllCookies();

        cookieSeti = driver.manage().getCookies();

        int expectedCookieSetiSize = 0 ;
        int actualCookieSetiSize = cookieSeti.size();

        Assert.assertEquals(expectedCookieSetiSize,actualCookieSetiSize);








        bekle(2);




    }


    }











