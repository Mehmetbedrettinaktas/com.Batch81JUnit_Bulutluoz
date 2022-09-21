package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.Set;

public class C03_MouseActions extends TestBaseBeforeAfter {
    @Test
    public void test01() throws InterruptedException {
        // 1- Yeni bir class olusturalim: C03_MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapalim
        Actions actions=new Actions(driver);
        WebElement cizgiliAlanelemnti= driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlanelemnti).perform();
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String expectedYazi="You selected a context menu";
        String actualYazi= driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        //5- Tamam diyerek alert’I kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        String ilkSayfaWHDegeri=driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        Set<String>handelSeti=driver.getWindowHandles();
        String ikinciSayfaWHDegeri=driver.getWindowHandle();
        for (String each:handelSeti
             ) {
            if (!each.equals(ikinciSayfaWHDegeri)){
                ikinciSayfaWHDegeri=each;
            }
        }

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        driver.switchTo().window(ikinciSayfaWHDegeri);
        WebElement yaziElementi=driver.findElement(By.tagName("h1"));
        String expectedYazi1="Elemental Selenium";
        String actualYazi1=yaziElementi.getText();
        Assert.assertEquals(expectedYazi1, actualYazi1);

        Thread.sleep(5000);
    }

}
