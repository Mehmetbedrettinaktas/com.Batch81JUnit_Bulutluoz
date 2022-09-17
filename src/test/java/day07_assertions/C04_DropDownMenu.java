package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownMenu {
    /*
    1- amazon sayfasina gidin
    2- dropdown'dan books secenegini secin
    3- Java aratalim
    ve arama sonuclarinin Java icerdigini test edelim.
     */
    WebDriver driver;
    @Before
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @After
    public  void  tearDown() {
    driver.close();
    }
    @Test
    public  void test01() throws InterruptedException {
        //  1- amazon sayfasina gidin
        driver.get("https://www.amazon.com");

       // dropdown'dan bir option secmek icin 3 adim vardir
      // 1- dropdown'ni locate edelim
        WebElement dropDownmenu= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        //2- bir select objesini olusturup parametre olarak bir onceki adimda locate ettigimiz ddm'yu girelim
        Select select=new Select(dropDownmenu);
        // 3- Dropdowda'da var olan option'lardan istedigimiz bir taneyi secelim
        select.selectByVisibleText("Books"); // gorunur text ile
       // select.selectByIndex(5); // gorunur index ile
        //select.selectByValue("search-alias=stripbooks-intl-ship"); // gorunur index ile

        // arama kutusuna Java yazdiralim
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);


        WebElement sonucYazisiElementi= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucYazisiStr=sonucYazisiElementi.getText();
        String arananKelime="Java";
        Assert.assertTrue(sonucYazisiStr.contains(arananKelime));
        Thread.sleep(5000);
    }
}
