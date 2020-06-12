/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import tiralabra.reitinhaku.algoritmit.AStar;
import tiralabra.reitinhaku.kartat.Kartanlukija;
import tiralabra.reitinhaku.tietorakenteet.Keko;
import tiralabra.reitinhaku.tietorakenteet.Solmu;

/**
 *
 * @author saasini
 */
public class AStarTest {
    
    File tiedosto = new File("./kartat/London_2_256.map");
    Keko minimiKeko;
    AStar astar;
    Kartanlukija kartanlukija;

    @Before
    public void setUp() throws FileNotFoundException, Exception {
        kartanlukija = new Kartanlukija(tiedosto);
        char[][] valittuKartta = kartanlukija.muutaMatriisiksi();
        astar = new AStar(valittuKartta);
    }
    
    @Test
    public void alustusAsettaaAlkusolmunEtaisyydeksiNollan() {
        Solmu alku = new Solmu(10, 2);
        assertEquals(-1, alku.getLyhinEtaisyysAlusta());
        Solmu loppu = new Solmu(5, 2);
        astar.laskeReitti(alku, loppu);
        assertEquals(0, alku.getLyhinEtaisyysAlusta());
    }
    
    @Test
    public void lyhinReittiOnOikeanPituinen() {
        Solmu eka = new Solmu(10, 0);
        Solmu toka = new Solmu(14, 0);
        int pituus = astar.laskeReitti(eka, toka);
        assertEquals(4, pituus);
    }
    
    @Test
    public void kartanUlkopuolistaSolmuaEiLisataKekoon() {
        Solmu edeltaja = new Solmu(0, 0);
        Solmu loppu = new Solmu(20, 10);
        astar.tutkiEtaisyyksia(-1, 0, edeltaja, loppu);
        assertEquals(-1, astar.getKeko().getLisatytSolmut());
    }
}
