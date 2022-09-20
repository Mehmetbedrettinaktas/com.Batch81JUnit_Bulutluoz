package day08_alerts;

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

public class C01_Alerts {
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
       // driver.close();
    }
    @Test
    public void test01(){

        /*
        herhangi bir web sitesine gidince veya bir websitesinde herhangi bir islem yaptigimizda
        ortaya cikan uyarilara alert diyoruz.

        Eger bir alert inspect yapilabiliyorsa, o alert otomasyon ile kullanilabilir,
        bu tur alert'lere HTML alert denir ve bunlar icin ekstra bir islm yapmaya gerek yoktur
        tum Webelementler gibi locate edip istedigimiz islemleri yapabiliriz.

        driver.get("https://www.facebook.com"); gibi cikan alert vb..
         driver.findElement(By.xpath("//*[text()='Temel ve isteğe bağlı çerezlere izin ver']")).click();

         Ancak web uygulamalrinda HTML alert yaninda java script alert de bulunabilir
         js alert'ler localte edilemez
         Selenium'da JS alert'ler icin ozel bir yontem gelistirilmistir.
         driver.switchTo().alert().accep() --> onaylamak icin bu kod  blogunu kullaniriz
         driver.switchTo().alert().sendKeys() --> string bir metin gönderme
         driver.switchTo().alert().getTest() --> oradaki herhangi bir text'i bana getiriyor
         driver.switchTo().alert().dismiss() --> cansel'a basmis olacagiz.
         */
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        // alert'te OK tusuna  basin
        driver.switchTo().alert().accept();
        // alert'te OK tusuna  basin ve result kisminda "You successfully clicked an alert" yazdigini test edin
        String expectedResult="You successfully clicked an alert";
       WebElement sonucYazisiElementi= driver.findElement(By.xpath("//p[@id='result']"));
       String actualResultYazisi=sonucYazisiElementi.getText();
        Assert.assertEquals(expectedResult,actualResultYazisi);



    }
}
