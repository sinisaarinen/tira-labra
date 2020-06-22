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
 * @author saasini
 */
public class Logiikka {
    
    private String valittuKartta;
    private File kartta;
    private Kartanlukija kartanlukija;
    private char[][] matriisi;
    
    public Logiikka() throws FileNotFoundException, Exception {
        this.valittuKartta = "kartta1";
        this.kartta = new File("./kartat/London_2_256.map");
        this.kartanlukija = new Kartanlukija(kartta);
        this.matriisi = kartanlukija.muutaMatriisiksi();
    }
    
    public void setValittuKartta(String kartta) throws FileNotFoundException, Exception {
        this.valittuKartta = kartta;
    }
    
    public char[][] getValittuKartta() throws FileNotFoundException, Exception {
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
}
