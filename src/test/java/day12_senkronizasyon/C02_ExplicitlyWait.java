package day12_senkronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C02_ExplicitlyWait extends TestBaseBeforeAfter {
    // 1. Bir class olusturun : EnableTest
    //2. Bir metod olusturun : isEnabled()

    @Test
    public void enabletest() {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement texBoxElementi= driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(texBoxElementi.isEnabled());
        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(texBoxElementi));
        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabledYaziElementi= driver.findElement(By.xpath("//p[text()=\"It's enabled!\"]"));
        Assert.assertTrue(itsEnabledYaziElementi.isDisplayed());
        //7. Textbox’in etkin oldugunu(enabled) dogrulayın
        Assert.assertTrue(texBoxElementi.isEnabled());

    }
}
