/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.reitinhaku.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import tiralabra.reitinhaku.algoritmit.Dijkstra;
import tiralabra.reitinhaku.kartat.Kartanlukija;
import tiralabra.reitinhaku.tietorakenteet.Solmu;

/**
 *
 * @author saasini
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, Exception {
        File kartta = new File("./kartat/London_2_256.map");
        Kartanlukija kartanlukija = new Kartanlukija(kartta);
        char[][] valittuKartta = kartanlukija.muutaMatriisiksi();
        
        Solmu alku = new Solmu(5, 2);
        Solmu loppu = new Solmu(240, 2);
        Dijkstra dijkstra = new Dijkstra(valittuKartta);
        
        long aloitusAika = System.currentTimeMillis();
        int lyhinReitti = dijkstra.laskeReitinPituus(alku, loppu);
        long lopetusAika = System.currentTimeMillis();
        
        //long aloitusAika2 = System.currentTimeMillis();
        //A*-haku
        //long lopetusAika2 = System.currentTimeMillis();


        System.out.println();
        System.out.println("Lyhin reitti Dijkstran algoritmilla oli pituudeltaan " + lyhinReitti);
        //System.out.println("Lyhin reitti A*-algoritmin etsimänä oli pituudeltaan  " + lyhinReitti2);
        System.out.println();
        System.out.println("Suoritusaika Dijkstran algoritmille oli " + (lopetusAika - aloitusAika) + "ms.");
        //System.out.println("Suoritusaika A*-algoritmille oli " + (lopetusAika2 - aloitusAika2) + "ms.");
    } 
}
