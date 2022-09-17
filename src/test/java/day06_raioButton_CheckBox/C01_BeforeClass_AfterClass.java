package day06_raioButton_CheckBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeClass_AfterClass {
    /*
    @BeforeClass ve @AfterClass notasyonlari sadece static methodlar icin calisir.
    Cllas calismaya baslamadan once @BeforeClass calisir ve class kapanmadan önce
    @AfterClass calisir, yani birer defa calisir.
     */
  static   WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void  tearDown(){
        driver.close();

    }
    @Test
    public void test1(){// Her method dan once bir Before method call var
        driver.get("https://www.amazon.com");
        // Her method dan sonra bir after method call var
    }
    @Test
    public void test2(){
        driver.get("https://www.techproeducation.com");
    }
    @Test
    public void test3(){
        driver.get("https://www.facebook.com");
    }
}
