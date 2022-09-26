package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        // 7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis= new FileInputStream(dosyaYolu);

        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim

        //10. WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);

        // sayfa 2'ye gidip
        // satir sayisinin 24, kullanilan satir sayisinin ise 12 oldugunu tesbit edin

        int sonsatirIndex=workbook
                .getSheet("Sayfa2")
                .getLastRowNum();
        int expectedSatirSayisi=24;
        Assert.assertEquals(expectedSatirSayisi,sonsatirIndex+1);

        int kullanilanSatirsayisi=workbook.getSheet("Sayfa2").getPhysicalNumberOfRows(); // bize kullanilan satir sayisini verir.

        int expectedKullanilanSatirsayisi=12;
        Assert.assertEquals(expectedKullanilanSatirsayisi,kullanilanSatirsayisi);
    }
}
