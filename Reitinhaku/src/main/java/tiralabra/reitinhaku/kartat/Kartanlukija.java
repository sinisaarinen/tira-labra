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
 * @author saasini
 */
public class Kartanlukija {
    private File kartta;
    private Scanner lukija;
    
    public Kartanlukija(File tiedosto) throws FileNotFoundException {
        this.kartta = tiedosto;        
        if (!lueKartta()) {
            throw new FileNotFoundException();
        }        
    }
    
    public boolean lataaKartta(File tiedosto) {
        kartta = tiedosto;
        return lueKartta();
    }
    
    public boolean lueKartta() {
        try {            
            lukija = new Scanner(kartta);
            return true;
        } catch (FileNotFoundException poikkeus) {
            return false;
        }
    }
    
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
        } catch (Exception poikkeus) {
            throw new Exception("Valittu tiedosto ei kelpaa.");            
        }        
    }
    
    public char[][] muutaMatriisiksi() throws Exception {
        char[][] matriisi = luoMatriisi();
        for (int i = 0; i < matriisi.length; i++) {
            matriisi[i] = lukija.nextLine().toCharArray();
        }
        return matriisi;
    }
}
