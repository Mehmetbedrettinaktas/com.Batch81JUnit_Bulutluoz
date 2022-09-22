package day11_faker_file;

import net.jodah.failsafe.Failsafe;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void test01(){
        System.out.println(System.getProperty("user.dir"));  // C:\com.Batch81JUnit_Bulutluoz
        //bana icinde oldugum projenin dosya yolunu(path) verir

        System.out.println(System.getProperty("user.home"));
        // C:\Users\Computer   yani benim bilgisayarimin bana ozel kismini verdi
        // "C:\Users\Computer\Downloads" ---> dowlands dosyanin yolunun alinmasi
        // homePath +"\Downloads"
        // "C:\Users\Computer\Desktop"  --> masa ustu yolu

        // "C:\Users\Computer\Desktop\deneme.txt"
        // masa ustumuzdeki deneme.txt dosyanin varligini test edin
        String dosyaYolu =System.getProperty("user.home")+"\\Desktop\\deneme.txt";
        System.out.println("dosyaYolu = " + dosyaYolu); // C:\Users\Computer\Desktop\deneme.txt
        /*
        Bilgisayarimizaki bir dosyanin varligini test etmek icin once o dosyaya
        ulasmamiz gerekir Java'da dosyaya erisim icin dosya yoluna(path) ihtiyac vardir
        Her bilgisayarin kullanici adi farkli olacagindan masaustu dosya yolu da birbirinden farkli olacaktir
        Testlerimizin tum bilgisayarlarda calismasi icin dosya yolunu DINAMIK yapmak zorundayiz

         */
        //  Bunun icin her bilgisayarin birbirinden farkli olan yolunu bulmak icin
        String farkliKisim=System.getProperty("user.home");

        // herkesin bilgisayarinda ortak olan kisim ise
        String ortakKisim="\\Desktop\\deneme.txt";
        String masaustuDosyaYolu=farkliKisim+ortakKisim;

        System.out.println(Files.exists(Paths.get(masaustuDosyaYolu))); // true

        Assert.assertTrue(Files.exists(Paths.get(masaustuDosyaYolu)));

    }
}
