package day08_alerts_Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BasicAuthentication {
    /*
         Authentication Nedir?
        Kısaca, herhangi bir internet kullanıcısının, uygulamanın ya da
        programın, söz konusu sisteme dahil olup olamayacağını belirleyen
        formu ifade eder.
        Uygulama ana sayfalarindaki kullanici adi ve password istemek de bir
        authentication’dir.
        End user’lar icin tasarlanmayan uygulamalarda(Ornegin API
        sorgularinda) bu authentication HTML komutlari ile de yapilabilir.
        Bu authentication’i yapabilmek icin uygulamanin kullanicilara authentication’i nasil yapacagina dair
        bilgilendirme yapmis olmasi gerekir.
        Ornegin yandaki uygulama icin authentication asagidaki gibi yapilabilir.
        https://username:password@URL

     */
  static   WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void  tearDown() {
        // driver.close();
    }
    @Test
    public void test01(){
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

    }
}
