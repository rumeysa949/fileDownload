package practice;

import org.junit.Test;

public class P01 {

   /*
   @BeforeClass ==> sadece bir kere calisiyor
   @Before ==> her testten once bir kere calisir
   @After ==> her testin sonunda bir kere calisir
   @AferClass==> tum testlerin sonunda bitince bir kere calisir
   @Test ==>Test kodlarinin yer aldigi kisimdir

    */

    @Test
    public void test08(){

        System.out.println("Ahmet");
    }



    @Test
    public void test01(){

        System.out.println("Rumeysa");
    }


    @Test
    public void test13(){

        System.out.println("Nergiz");
    }


}
