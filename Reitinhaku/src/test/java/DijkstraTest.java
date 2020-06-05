/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tiralabra.reitinhaku.algoritmit.Dijkstra;
import tiralabra.reitinhaku.kartat.Kartanlukija;
import tiralabra.reitinhaku.tietorakenteet.Keko;
import tiralabra.reitinhaku.tietorakenteet.Solmu;

/**
 *
 * @author saasini
 */
public class DijkstraTest {
    
    File tiedosto = new File("./kartat/London_2_256.map");
    Keko minimiKeko;
    Dijkstra dijkstra;
    Kartanlukija kartanlukija;

    @Before
    public void setUp() throws FileNotFoundException, Exception {
        kartanlukija = new Kartanlukija(tiedosto);
        char[][] valittuKartta = kartanlukija.muutaMatriisiksi();
        dijkstra = new Dijkstra(valittuKartta);
    }
    
    @Test
    public void lyhinReittiOnOikeanPituinen() {
        Solmu eka = new Solmu(10, 0);
        Solmu toka = new Solmu(5, 0);
        int pituus = dijkstra.laskeReitinPituus(eka, toka);
        assertEquals(5, pituus);
    }
    
    @Test
    public void kartanUlkopuolistaSolmuaEiLisataKekoon() {
        Solmu edeltaja = new Solmu(0, 0);
        Solmu loppu = new Solmu(10, 10);
        dijkstra.tutkiEtaisyyksia(-1, 0, edeltaja, loppu);
        assertEquals(-1, dijkstra.getKeko().getLisatytSolmut());
    }
}
