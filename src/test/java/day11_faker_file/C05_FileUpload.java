package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C05_FileUpload extends TestBaseBeforeAfter {
    @Test
    public void test01() throws InterruptedException {
        // 1. Tests packagenin altina bir class oluşturun : C05_UploadFile
        //2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //3. chooseFile butonuna basalim
        //4. Yuklemek istediginiz dosyayi secelim.
        /*
        bu islemi selenium ile yapma imkanimiz yok cunku web tabanli bir uygulama degil
        bu durumda sendKeys() imdadimiza yetisir.
        eger chooseFile butonuna var olan bir dosyanin dosya yolunu yollarsak
        secme islemi otomatik olarak yapilmis olacaktir.
         */
        // 1. adim chooseFile butonunu locate edelim
        WebElement dosyaSecButonu= driver.findElement(By.id("file-upload"));
        // 2. adim yuklenecek dosyanin dosya yolunu olusturalim
        String farkliKisim=System.getProperty("user.home");
        // ben downlands taki LambdaTest.txt yukledim
        String ortakKisim="\\Downloads\\LambdaTest.txt";
        String yuklenecekDosya =farkliKisim+ortakKisim;
        // 3. Adim sendKeys ile dosya yolunu, secme butonuna yollayalim
        dosyaSecButonu.sendKeys(yuklenecekDosya);
        Thread.sleep(5000);

        //5. Upload butonuna basalim.
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
        //6. “File Uploaded!” textinin goruntulendigini test edelim
        WebElement yaziElementi= driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(yaziElementi.isDisplayed());
    }
}
