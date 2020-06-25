
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
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
public class SolmuTest {
    
    private static final double DELTA = 1e-15;
    private Solmu solmu1;
    private Solmu solmu2;
    private Solmu solmu3;
    private Solmu solmu4;

    @Before
    public void setUp() {
        solmu1 = new Solmu(5, 5);
        solmu2 = new Solmu(5, 5);
        solmu3 = new Solmu(3, 3);
        solmu4 = new Solmu(10, 10, 20, solmu1);
    }

    @Test
    public void equalsMetodiToimiiOikein() {
        assertTrue(solmu1.equals(solmu2));
        assertFalse(solmu1.equals(solmu3));
    }
    
    @Test
    public void getteritToimivatOikein() {
        assertEquals(5, solmu1.getX());
        assertEquals(5, solmu1.getY());
        assertEquals(-1, solmu2.getLyhinEtaisyysAlusta(), DELTA);
        assertEquals(null, solmu2.getVanhempi());
    }
}
