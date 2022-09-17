package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05_DropDownOptions {
    /*
    1- amazon ansayfasina gidip
    2- dropdown menuden Books'u secelim
    3- sectigimiz option'i yazdiralim

    dropdown'daki opsiyonlarin toplam sayisinin 28 oldugunu test edin

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
    public  void test01(){
        //  1- amazon ansayfasina gidip

        driver.get("https://www.amazon.com");
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(ddm);
        // 2- dropdown menuden Books'u secelim
        select.selectByVisibleText("Books");

        //    3- sectigimiz option'i yazdiralim

        // Bir dropdown ile calisiliyorken, son secilen option'a ulasmak isterseniz
        // select.getFirstSelectedOption() method'unu kullanmalisiniz
        // bu method bize Webelement dondurur
        //uzerindeki yaziyi  yazdirmak icin getTex() unutulmamalidir.
        System.out.println(select.getFirstSelectedOption().getText());

        //dropdown'daki opsiyonlarin toplam sayisinin 28 oldugunu test edin
        List<WebElement> optionList = select.getOptions();
        int actualOptionSayisi= optionList.size();
        int expectedOptionSayisi=28;
        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);

    }
}
