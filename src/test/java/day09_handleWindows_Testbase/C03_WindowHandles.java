package day09_handleWindows_Testbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_WindowHandles {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test1() {
        // ● Tests package’inda yeni bir class olusturun: WindowHandle2
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement sayfadakiYaziElementi = driver.findElement(By.xpath("//h3"));
        String expectedYazi = "Opening a new window";
        String actualYazi = sayfadakiYaziElementi.getText();
        Assert.assertEquals(expectedYazi, actualYazi);
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

            /*
            eger kontrolsuz acilan bir tab veya window varsa o zaman sayfalarini
            elde etmem gerekir.
            oncelikle ikinci sayfa acilmadan once ilk sayfanin
            window hande degerini bir String'e atayalim
             */
        String ilkSayfaninWindowhandleDegeri = driver.getWindowHandle();
        System.out.println(ilkSayfaninWindowhandleDegeri);

        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();

            /*
            switchTo().newWindow() demeden link tiklayarak yeni tab veya window olustugunda
            biz driver'a yeni sayfaya gec demedikce, driver eski sayfada kalir
            ve yeni sayfa ile ilgili hicbir islem yapamaz yeni sayfada driver'i calistirmak
            isterseniz once driver'i yeni sayfaya yollamalisiniz
             */
            /*
            yeni sayfaya gecebilmek icin oncelikle ikinciSayfaninWindowHandleDegeri'ni bulmamiz gerekir
            bunun icin driver.getWindowHandles() method'unu kullanarak acik olan tum
            sayfalarin window handle degerlerini alip bir set'e atariz assign ederiz
            ilk sayfanin window handle degerini zaten biliyoruz
            Set'deki window handle degerlerini kontrol edip
            ilk sayfanin handle degerine esit olmayan ikinci sayfanin window handle degeridir deriz.
             */
        String ikinciSayfaninWindowHandleDegeri = "";
        Set<String> windowHandleseti = driver.getWindowHandles();
        System.out.println(windowHandleseti);
        for (String each : windowHandleseti
        ) {
            if (!each.equals(ilkSayfaninWindowhandleDegeri)) {
                ikinciSayfaninWindowHandleDegeri = each;
            }
        }
        // artik ikinci sayfanin window handle degerini biliyoruz
        // rahatlik sayfalar arasi gecis yapabiliriz.
        driver.switchTo().window(ikinciSayfaninWindowHandleDegeri);

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String expectedTitle2 = "New Window";
        String actualTitle2 = driver.getTitle();
        Assert.assertEquals(expectedTitle2, actualTitle2);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement ikinciSayfaYaziElemnti = driver.findElement(By.xpath("//h3"));
        String expectedIkinciYazi = "New Window";
        String actualIkinciyazi = ikinciSayfaYaziElemnti.getText();
        Assert.assertEquals(expectedIkinciYazi, actualIkinciyazi);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının
        // “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaninWindowhandleDegeri);
        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @After
    public void tearDown() {
          driver.quit();
    }

}



