package day06_raioButton_CheckBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CheckBox {
    /*
        Bir class oluşturun : CheckBoxTest
        2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
        a. Verilen web sayfasına gidin.
        https://the-internet.herokuapp.com/checkboxes
        b. Checkbox1 ve checkbox2 elementlerini locate edin.
        c. Checkbox1 seçili değilse onay kutusunu tıklayın
        d. Checkbox2 seçili değilse onay kutusunu tıklayın
     */

    WebDriver driver;
    @Before
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Before
    public void  tearDown() {
    //driver.close();
    }
    @Test
    public void test1() throws InterruptedException {
        //1. Bir class oluşturun : CheckBoxTest
        //     2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
        //     a. Verilen web sayfasına gidin.
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //     b. Checkbox1 ve checkbox2 elementlerini locate edin.
        Thread.sleep(2000);
        WebElement checkBox1 =driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkBox2 =driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));
        //     c. Checkbox1 seçili değilse onay kutusunu tıklayın
        Thread.sleep(2000);
        if (!checkBox1.isSelected()){
            checkBox1.click();
        }
        //     d. Checkbox2 seçili değilse onay kutusunu tıklayın
        Thread.sleep(2000);
        if (!checkBox2.isSelected()){
            checkBox2.click();
        }
    }
}
