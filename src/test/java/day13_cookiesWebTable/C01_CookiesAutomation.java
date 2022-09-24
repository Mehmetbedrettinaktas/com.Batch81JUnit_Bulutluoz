package day13_cookiesWebTable;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBaseBeforeAfter;

import java.util.Set;

public class C01_CookiesAutomation extends TestBaseBeforeAfter {
    @Test
    public void test() {
        // Yeni bir class olusturun : cookiesAutomation
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2tum cookie’leri listeleyin
        Set<Cookie> cookieSet = driver.manage().getCookies();
        System.out.println(cookieSet);
         int sayac=1;
        for (Cookie each:cookieSet) {
            System.out.println(sayac+ ". cookie "+each);
            System.out.println("name : "+ each.getName());
            System.out.println("Valu : "+ each.getValue());
            sayac++;
        }
        //3 Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookieSayisi= cookieSet.size();
        Assert.assertTrue(cookieSayisi>5);
        //4ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie each:cookieSet
             ) {
            if (each.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD",each.getValue());
                sayac++;

            }
        }
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
        //olusturun ve sayfaya ekleyin

        Cookie cookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);
        cookieSet = driver.manage().getCookies();
         sayac=1;
        for (Cookie each:cookieSet) {
            System.out.println(sayac+ ". cookie "+each);
            sayac++;
        }
        //6 eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(cookieSet.contains(cookie));
        //7 ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(cookieSet.contains("skin"));
        //8 tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookieSet=driver.manage().getCookies();
        Assert.assertTrue(cookieSet.isEmpty());
    }
}
