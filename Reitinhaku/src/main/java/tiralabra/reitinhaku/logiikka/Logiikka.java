/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.reitinhaku.logiikka;

import java.io.File;
import java.io.FileNotFoundException;
import tiralabra.reitinhaku.kartat.Kartanlukija;
/**
 *
 * Luokka vastaa sovelluslogiikasta.
 */
public class Logiikka {
    
    private String valittuKartta;
    private File kartta;
    private Kartanlukija kartanlukija;
    private char[][] matriisi;
    private String valittuAlgo;
    /**
     * Sovelluslogiikka alustetaan oletuksena Lontoon kartalla ja Dijkstran
     * algoritmilla, jos käyttäjä ei itse valitse karttaa tai algoritmia.
     * 
     * @throws FileNotFoundException
     * @throws Exception
     */
    public Logiikka() throws FileNotFoundException, Exception {
        this.valittuKartta = "kartta1";
        this.kartta = new File("./kartat/London_2_256.map");
        this.kartanlukija = new Kartanlukija(kartta);
        this.matriisi = kartanlukija.muutaMatriisiksi();
        this.valittuAlgo = "Dijkstra";
    }
    
    public void setValittuKartta(String kartta) {
        this.valittuKartta = kartta;
    }
    
    public String getValittuKartta() {
        return this.valittuKartta;
    }
    /**
     * Metodi palauttaa matriisimuotoisen kartan käyttäjän valinnan perusteella.
     * 
     * @throws FileNotFoundException
     * @throws Exception
     * 
     * @return matriisimuotoinen kartta
     */
    public char[][] getValittuKarttaMatriisina() throws FileNotFoundException, Exception {
        if (this.valittuKartta.equals("kartta1")) {
            File kartta1 = new File("./kartat/London_2_256.map");
            Kartanlukija kartanlukija = new Kartanlukija(kartta1);
            this.matriisi = kartanlukija.muutaMatriisiksi();
        } else if (this.valittuKartta.equals("kartta2")) {
            File kartta2 = new File("./kartat/Milan_2_256.map");
            Kartanlukija kartanlukija = new Kartanlukija(kartta2);
            this.matriisi = kartanlukija.muutaMatriisiksi();
        } else if (this.valittuKartta.equals("kartta3")) {
            File kartta3 = new File("./kartat/Moscow_1_256.map");
            Kartanlukija kartanlukija = new Kartanlukija(kartta3);
            this.matriisi = kartanlukija.muutaMatriisiksi();
        } else if (this.valittuKartta.equals("kartta4")) {
            File kartta4 = new File("./kartat/NewYork_1_256.map");
            Kartanlukija kartanlukija = new Kartanlukija(kartta4);
            this.matriisi = kartanlukija.muutaMatriisiksi();
        }
        return this.matriisi;
    }
    
    public void setValittuAlgo(String algoritmi) {
        this.valittuAlgo = algoritmi;
    }
    
    public String getValittuAlgo() {
        return this.valittuAlgo;
    }
    
    public boolean solmutOK(String alkuX, String alkuY, String loppuX, String loppuY) {
        int[] luvut = new int[4];
        luvut[0] = Integer.valueOf(alkuX);
        luvut[1] = Integer.valueOf(alkuY);
        luvut[2] = Integer.valueOf(loppuX);
        luvut[3] = Integer.valueOf(loppuY);
        for (int i = 0; i < luvut.length; i++) {
            if (i >= 0 && i < matriisi.length && matriisi[luvut[0]][luvut[1]] == '.' && matriisi[luvut[2]][luvut[3]] == '.') {
                return true;
            }
        }
        return false;
    }
}
