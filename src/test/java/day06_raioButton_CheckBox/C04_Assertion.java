package day06_raioButton_CheckBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertion {
    WebDriver driver;
    @Before
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @After
    public void tearDown() {
    driver.close();
    }
    @Test
    public  void test1(){
        /*
        Eger Test method'umuzda hicbir test yoksa, test calistiktan sonra
        hic bir problemle karsilasilmadigini raporlamak icin"tests passed" yazis cikar
        Eger testleri if ile yaparsak test faild olsa bile kodlar problemsiz calistigi icin
        kod calismasi bittiginde ekranin sol alt kisminda test passed yazacaktir
         */
        driver.get("https://www.amazon.com");
      /*
        // url'in "https://www.facebook.com" oldugunu test edin
        if (driver.getCurrentUrl().equals("https://www.facebook.com")){
            System.out.println("Url testi Passed");
        }else System.out.println("Url Testi FAILED");

       */
        String expectedUrl="https://www.facebook.com";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals("Url beklenden farkli"+expectedUrl,actualUrl);

        /*
        Assert ile yaptzigimiz testlerde assertion faild olursa Java kodlarin calismasini
        durdurur ve Assert class'i bizi hata konusunda bilgilendirir.

         Expected :https://www.facebook.com    https://www.facebook.com
        Actual   :https://www.amazon.com/    https://www.amazon.com/
        <Click to see difference>
        Boylece hatanin ne arastirmamiza gerek kalmadan
        Junit bize raporlamis olacak
         */
    }
}
