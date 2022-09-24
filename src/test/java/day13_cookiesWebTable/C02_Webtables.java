package day13_cookiesWebTable;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v95.overlay.model.LineStyle;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C02_Webtables extends TestBaseBeforeAfter {
    //● Bir class oluşturun : C02_WebTables

    @Test
    public void test( ) {
        //● login( ) metodun oluşturun ve oturum açın.
        login();

        //● table( ) metodu oluşturun
        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> sutunBasliklariListesi= driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Sutun sayisi : "+sutunBasliklariListesi);
        //○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.

        /*
        Tum body'i bir string olarak yazdirmak isterseniz
        body webElementinii locate edip, getText() method'u ile yazdirabilirsiniz
         */
        WebElement tumBody= driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());
        //● printRows( ) metodu oluşturun //tr
        //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirlarListesi=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("satir sayisi : "+satirlarListesi);
        //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement each:satirlarListesi
             ) {
            System.out.println(each.getText());
        }
        //○ 4.satirdaki(row) elementleri konsolda yazdırın
        List<WebElement> cellList=driver.findElements(By.xpath("//tbody//td"));
        for (WebElement each: cellList
             ) {
            System.out.println(each.getText());
        }
    }

    private void login() {
        //● https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        //○ Username : manager
        //○ Password : Manager1!
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        //  driver.findElement(By.xpath("//input[@id='UserName']")).click();
        Actions actions=new Actions(driver);
        WebElement username= driver.findElement(By.xpath("//input[@id='UserName']"));
        actions.click(username).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
    // code  gitmek icin //thead//tr[1]//th[3]



    }
}
