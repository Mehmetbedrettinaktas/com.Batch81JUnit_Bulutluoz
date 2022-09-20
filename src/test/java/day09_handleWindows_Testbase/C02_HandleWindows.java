package day09_handleWindows_Testbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HandleWindows {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test1() throws InterruptedException {
        // 1- amazon ana sayfasina gidin
        driver.get("https://www.amazon.com");
       String amazonWindowHandel= driver.getWindowHandle();
        // 2- url'nin amazon icerdigini test edelim
        String istenenKelime="amazon";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(istenenKelime));
        //3- yeni bir pencere acip besbuy ana sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestBuywindowhandel=driver.getWindowHandle();
        // 4- title'in Best Buy icerdigini test edelim
        String actualTitle=driver.getTitle();
        String arananKelime="Best Buy";
        Assert.assertTrue(actualTitle.contains(arananKelime));
        //5 ilk sayfaya donup sayfada java aratalim
        driver.switchTo().window(amazonWindowHandel);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);
        //6- arama sonuclarinin Java icerdigini test edelim
        WebElement sonucYaziElemnti= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazisiStr=sonucYaziElemnti.getText();
        String aradigimizKelime="Java";
        Assert.assertTrue(sonucYazisiStr.contains(aradigimizKelime));
        //7- yeniden bestbuy'in acik oldugunu sayfaya gidelim
        driver.switchTo().window(bestBuywindowhandel);
        // 8- logonun gorundugunu test edelim
        WebElement logoElementi= driver.findElement(By.xpath("//img[@class='logo'][1]"));
        Assert.assertTrue(logoElementi.isDisplayed());
        Thread.sleep(3000);
    }
    @After
    public  void  tearDown() {
        driver.quit();
    }
}