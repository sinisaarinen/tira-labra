/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tiralabra.reitinhaku.kartat.Kartanlukija;
/**
 *
 * @author saasini
 */
public class KartanlukijaTest {
    
    private Kartanlukija kartanlukija;
    private File tied1;
    private File tied2;

    @Before
    public void setUp() {      
        tied1 = new File("./kartat/London_2_256.map");
        tied2 = new File("testi");
    }

    @Test
    public void konstruktoriHeittaaPoikkeuksen() {        
        try {
            kartanlukija = new Kartanlukija(tied1);            
        } catch (Exception poikkeus){
            assert false;
        }    
        try {
            kartanlukija = new Kartanlukija(tied2);
            assert false;
        } catch (Exception poikkeus){
            assert true;
        }        
    }

    @Test
    public void lataaKarttaHeittaaPoikkeuksen() {
        try{
            kartanlukija = new Kartanlukija(tied1);
            assertTrue(kartanlukija.lataaKartta(tied1));
            assertFalse(kartanlukija.lataaKartta(tied2));
        } catch (Exception poikkeus) {
            assert false;
        }                
    }
    
    @Test
    public void luoMatriisiHeittaaPoikkeuksen() {
        try {
            kartanlukija = new Kartanlukija(tied2);
            char[][] matriisi = kartanlukija.luoMatriisi();
            assert false;
        } catch (Exception poikkeus) {
            assert true;
        }
    }
    
    @Test
    public void muutaMatriisiksiHeittaaPoikkeuksen() {
        try {
            kartanlukija = new Kartanlukija(tied2);
            kartanlukija.muutaMatriisiksi();
            assert false;
        } catch (Exception poikkeus) {
            assert true;
        }
    }
    
    @Test
    public void muutaMatriisiksiMetodiToimii() {
        try {
            kartanlukija = new Kartanlukija(tied1);
            char[][] matriisi = kartanlukija.muutaMatriisiksi();
            assertTrue(matriisi[0][0]=='@');
            assertTrue(matriisi[1][0]=='.');                     
        } catch (Exception poikkeus) {
            assert false;
        }   
    }
}

