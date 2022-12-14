package day09_handleWindows_Testbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_HandleWindows {
    WebDriver driver;
    @Before
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void test1(){
        // amazon ana sayfasina gidin

        driver.get("https://www.amazon.com");
       String ilkSayfaHandeldegeri= driver.getWindowHandle();
        // nutella icin arama yptirin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        /*
        CDwindow-874BE526E4411CB513A0C1783FB8F7E3
        bu kocd acilan sayfanin  unique has kodudur.
        selenium sayfalar arasi geciste bu window handle degerini kullanir
        eger sayfalar arasinda driverimizi gezdiriyorsak herhangi bir sayfaya gecmek istiyorsak
        driver.switchTo().window("CDwindow-874BE526E4411CB513A0C1783FB8F7E3");
        bu sayfanin window handle degerini girerek bu sayfaya gecisi saglayabiliriz.

         */
        //3- ilk urunun resmini tiklayarak farkli bir tab olarak acin
        WebElement ilkUrunResmi= driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-square-aspect'][1]"));
      //  ilkUrunResmi.click(); bu kod ile ayni tabta aciliyor
        driver.switchTo().newWindow(WindowType.TAB);
        /*
        <Bu komutu kullandigimzda driver otomatik olarak olusturulan
         new Tab'a gecer yeni tab'da gorevi gerceklestirmek icin
         adamlari bastan almamiz gerekir
         */

        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-square-aspect'][1]"));
        // 4- yeni tab'da acilan urunun Title yazdirin
        WebElement urunTitleElementi= driver.findElement(By.xpath("//*[text()='Nutella Chocolate Hazelnut Spread, Perfect Topping for Pancakes, 35.2 oz Jar']"));
        System.out.println(urunTitleElementi.getText());
        // ilk sayfaya gecip url'i yazdiralim
        driver.switchTo().window(ilkSayfaHandeldegeri);
        System.out.println(driver.getCurrentUrl());


    }
    @After
    public  void  tearDown() {
        driver.quit();
    }
}
