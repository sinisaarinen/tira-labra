/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tiralabra.reitinhaku.kartat.Kartanlukija;
import tiralabra.reitinhaku.logiikka.Logiikka;

/**
 *
 * @author saasini
 */
public class LogiikkaTest {
    
    private Logiikka logiikka;

    @Before
    public void setUp() throws Exception {      
        this.logiikka = new Logiikka();
    }
    
    @Test
    public void alustusToimiiOikein() {
        assertEquals("Dijkstra", this.logiikka.getValittuAlgo());
        assertEquals("kartta1", this.logiikka.getValittuKartta());
    }
    
    @Test
    public void valitunKartanTaiAlgonVoiVaihtaa() {
        this.logiikka.setValittuKartta("kartta2");
        this.logiikka.setValittuAlgo("AStar");
        assertEquals("kartta2", this.logiikka.getValittuKartta());
        assertEquals("AStar", this.logiikka.getValittuAlgo());
    }
    
    @Test
    public void oikeaKarttaMuutetaanMatriisiksi() throws FileNotFoundException, Exception {
        this.logiikka.setValittuKartta("kartta3");
        File kartta3 = new File("./kartat/Moscow_1_256.map");
        Kartanlukija kartanlukija3 = new Kartanlukija(kartta3);
        char[][] matriisi3 = kartanlukija3.muutaMatriisiksi();
        Assert.assertArrayEquals(matriisi3, this.logiikka.getValittuKarttaMatriisina());
        
        this.logiikka.setValittuKartta("kartta4");
        File kartta4 = new File("./kartat/NewYork_1_256.map");
        Kartanlukija kartanlukija4 = new Kartanlukija(kartta4);
        char[][] matriisi4 = kartanlukija4.muutaMatriisiksi();
        Assert.assertArrayEquals(matriisi4, this.logiikka.getValittuKarttaMatriisina());
        
        this.logiikka.setValittuKartta("kartta1");
        File kartta1 = new File("./kartat/London_2_256.map");
        Kartanlukija kartanlukija1 = new Kartanlukija(kartta1);
        char[][] matriisi1 = kartanlukija1.muutaMatriisiksi();
        Assert.assertArrayEquals(matriisi1, this.logiikka.getValittuKarttaMatriisina());
        
        this.logiikka.setValittuKartta("kartta2");
        File kartta2 = new File("./kartat/Milan_2_256.map");
        Kartanlukija kartanlukija2 = new Kartanlukija(kartta2);
        char[][] matriisi2 = kartanlukija2.muutaMatriisiksi();
        Assert.assertArrayEquals(matriisi2, this.logiikka.getValittuKarttaMatriisina());
    }
}
