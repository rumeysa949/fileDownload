package practice;

import org.junit.*;

public class P02 {

    @BeforeClass
    public static void BeforeClass(){

        System.out.println("Before Class calisti.Testler calismaya baslayabilir");
    }

   // @AfterClass
   // public void afterClass(){

   //     System.out.println("Tum testler basariyla tamamlandi.");
   // }

    @Before
    public  void setup(){

        System.out.println("Yeni bir test kodu calisitiriliyor");
    }

   // @After
   // public  void teardown(){

       // System.out.println("Bu test tamamlandi.Siradaki test calistirlacak.");
 //   }

    @Test
    public  void test01(){

        System.out.println("01 numarali test calisitirldi");
    }

    @Test
    public void test02(){

        System.out.println("02 nolu test calistirildi");
    }
}
