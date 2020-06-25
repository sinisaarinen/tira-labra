/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.reitinhaku.kartat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * Luokka vastaa .map-tyyppisten karttatiedostojen lukemisesta ja niiden
 * muuntamisesta matriisimuotoon.
 */
public class Kartanlukija {
    
    private File kartta;
    private Scanner lukija;
     /**
     * Konstruktori saa parametrinaan tiedoston ja kutsuu lueKartta-metodia.
     * @param tiedosto
     * @throws FileNotFoundException 
     */
    public Kartanlukija(File tiedosto) throws FileNotFoundException {
        this.kartta = tiedosto;        
        if (!lueKartta()) {
            throw new FileNotFoundException();
        }        
    }
    /**
     * Metodi saa parametrinaan tiedoston ja kutsuu lueKartta-metodia.
     * @param tiedosto
     * @return true jos lueKartta-metodi palauttaa true, muuten false
     */
    public boolean lataaKartta(File tiedosto) {
        kartta = tiedosto;
        return lueKartta();
    }
    /**
     * Metodi lukee .map-tiedoston.
     * @return true jos tiedosto löytyy, muuten false
     */
    public boolean lueKartta() {
        try {            
            lukija = new Scanner(kartta);
            return true;
        } catch (FileNotFoundException poikkeus) {
            return false;
        }
    }
     /**
     * Metodi luo matriisin .map-muotoisesta tiedostosta.
     * @return matriisi, jos tiedoston luku onnistuu.
     * @throws Exception 
     */
    public char[][] luoMatriisi() throws Exception {
        String korkeus;
        String leveys;
        try {
            lukija.nextLine();
            korkeus = lukija.nextLine();
            leveys = lukija.nextLine();            
            char[][] matriisi = 
                new char[Integer.parseInt(korkeus.substring(7))]
                        [Integer.parseInt(leveys.substring(6))];
            lukija.nextLine();                      
            return matriisi;
        } catch (NumberFormatException poikkeus) {
            throw new Exception("Valittu tiedosto ei kelpaa.");            
        }        
    }
     /**
     * Metodi kutsuu luoMatriisi-metodia ja palauttaa luodun matriisin.
     * 
     * @return luotu matriisi
     * @throws Exception 
     */
    public char[][] muutaMatriisiksi() throws Exception {
        char[][] matriisi = luoMatriisi();
        for (int i = 0; i < matriisi.length; i++) {
            matriisi[i] = lukija.nextLine().toCharArray();
        }
        return matriisi;
    }
}
