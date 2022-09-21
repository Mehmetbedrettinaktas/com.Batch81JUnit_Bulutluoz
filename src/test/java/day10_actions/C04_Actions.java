package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C04_Actions extends TestBaseBeforeAfter {

    @Test
    public void test01() throws InterruptedException {
        // Yeni bir class olusturalim: D14_MouseActions2
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions=new Actions(driver);
        WebElement tasinacakEleman= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement hedefElement= driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        actions.dragAndDrop(tasinacakEleman,hedefElement).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String expectedYazi="Dropped!";
        String actualYazi= sonucYaziElementi.getText();
        Assert.assertEquals(expectedYazi, actualYazi);


    }

}
