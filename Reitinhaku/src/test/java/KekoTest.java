
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import tiralabra.reitinhaku.tietorakenteet.Keko;
import tiralabra.reitinhaku.tietorakenteet.Solmu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saasini
 */
public class KekoTest {
    
    @Test
    public void lisayksetJaPoistotKekoonToimivat() {
        /*
        Tehdään minimikeko
        
                1
             2     3
           9  11 10  
        */
    
        Keko keko = new Keko(6);
        
        Solmu eka = new Solmu(0, 0);
        eka.setLyhinEtaisyysAlusta(1);
        eka.setEtaisyysArvioLoppuun(0);
        keko.lisaaSolmu(eka);
        
        Solmu toka = new Solmu(0, 0);
        toka.setLyhinEtaisyysAlusta(1);
        toka.setEtaisyysArvioLoppuun(1);
        keko.lisaaSolmu(toka);
        
        Solmu kolmas = new Solmu(0, 0);
        kolmas.setLyhinEtaisyysAlusta(1);
        kolmas.setEtaisyysArvioLoppuun(2);
        keko.lisaaSolmu(kolmas);
        
        Solmu neljas = new Solmu(0, 0);
        neljas.setLyhinEtaisyysAlusta(4);
        neljas.setEtaisyysArvioLoppuun(5);
        keko.lisaaSolmu(neljas);
        
        Solmu viides = new Solmu(0, 0);
        viides.setLyhinEtaisyysAlusta(5);
        viides.setEtaisyysArvioLoppuun(6);
        keko.lisaaSolmu(viides);
        
        Solmu kuudes = new Solmu(0, 0);
        kuudes.setLyhinEtaisyysAlusta(4);
        kuudes.setEtaisyysArvioLoppuun(6);
        keko.lisaaSolmu(kuudes);
        
        assertEquals(6, keko.getKeonKoko());
        
        assertEquals(eka, keko.poistaPienin());
        assertEquals(toka, keko.poistaPienin());
        assertEquals(kolmas, keko.poistaPienin());
        assertEquals(neljas, keko.poistaPienin());
        assertEquals(viides, keko.poistaPienin());
        assertEquals(kuudes, keko.poistaPienin());
    }
    
}
