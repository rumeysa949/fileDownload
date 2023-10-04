package day05_JUnitFramework;

import org.junit.Ignore;
import org.junit.Test;


public class C02_TestNotasyonu {

    /* Test notasyonu
    siradan methodlari bagimsiz olarak calistirabilmemize imkan tanir

    boylece main method bagimliligii ortadan kalkar
    ve biz istedigimiz testi tek basina
    veya class level'dan toplu olarak calistirabiliriz

    ayrica ileride gorecegimiz sekilde
    test method'larini belirli gruplara dahil edip
    toplu olarak da calistirabiliriz

    @Test notasyonuna sahip methodlar
    toplu olarak calistirildiginda
    hangi sira ile calisacagina dair bir kural yoktur

    JUnit bu konuda bir yontem gelistirmemistir
    calisma sirasi ongurulemez ve kontrol edilemez

    Eger bir test method'u @Ignore olarak isaretlenirse
    Selenium o methodu ignore eder
    calistirmaz

    JUnit bize calisan testkerden kacinin PASSED,kacinin FAILED oldugunu verir
    Ancak JUnit testlerin gecip gecmedigini
    kodlarda bir sorun yasanip yasanmamasina baglar

    kodlar sorunsuz calisirsa;TEST PASSED
    bir exception olusursa ; TEST FAILED
    olarak kaydedilir


     */
    @Test


    public void amazonTest(){
    System.out.println("amazon test calisti");

    }
    @Test @Ignore
    public void youtubeTest(){
        System.out.println("youtube test calsiti");

    }
    @Test
    public void wiseTest() {
        System.out.println("wise test calisti");
    }
    @Test
        public void test4(){
            //verilen iki sayidan,sayi1'in  daha buyuk oldugunu test edin
        int sayi1 = 10;
        int sayi2 = 5;

        if (sayi1>sayi2){
            System.out.println("Karsilastirma testi PASSED");

        }else{
            System.out.println("Karsilastirma testi FAILED");
            throw new IllegalArgumentException();
        }






    }
}
