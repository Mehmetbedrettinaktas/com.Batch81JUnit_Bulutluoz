package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C06_KeyboardActions extends TestBaseBeforeAfter {
    @Test
    public void test01() throws InterruptedException {
        // facebook anasayfasina gidelim
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//*[text()='Temel ve isteğe bağlı çerezlere izin ver']")).click();

        // yeni kayit olustur butonuna basin
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();
        // isim kutusunu locate edip,
        WebElement isimKutusu = driver.findElement(By.xpath("//input[@name='firstname']"));
        // geriye kalan alanlari TAB ile dolasarak formu doldurun

        Actions actions = new Actions(driver);
        actions.click(isimKutusu)
                .sendKeys("Selo")
                .sendKeys(Keys.TAB)
                .sendKeys("gonul")
                .sendKeys(Keys.TAB)
                .sendKeys("gfr@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("gfr@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345sg.")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("10")
                .sendKeys(Keys.TAB)
                .sendKeys("Mayis")
                .sendKeys(Keys.TAB)
                .sendKeys("2000")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(5000);
        driver.quit();

    }
}
