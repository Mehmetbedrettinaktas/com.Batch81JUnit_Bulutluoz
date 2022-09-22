package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownland extends TestBaseBeforeAfter {



    @Test
    public void test01() throws InterruptedException {
        // 1- Tests packenin altinda bir class olusturalim
        // 2- https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        // 3- LambdaTest.txt dosyasını indirelim
      WebElement lambdaTest =driver.findElement(By.xpath("//*[text()='LambdaTest.txt']"));
      lambdaTest.click();
      Thread.sleep(5000);
        // 4-  Ardından isExist( ) methodu ile dosyanın başarıyla indirilip indirilmediğini test edelim
        // bize downloads'a indirilecektir, bize dowlands'un dosya yolu lazi

        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Downloads\\LambdaTest.txt";  // "C:\Users\Computer\Downloads"
        String arananDosyaYolu=farkliKisim+ortakKisim;
        // geriye o dosya yolundaki dosyanın var oldugunu assert edin
        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));
    }
}
