/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.reitinhaku.algoritmit;

import tiralabra.reitinhaku.tietorakenteet.Keko;
import tiralabra.reitinhaku.tietorakenteet.Solmu;

/**
 *
 * Luokka vastaa A*-algoritmin toteutuksesta.
 */
public class AStar extends Dijkstra {
    
    private Keko minimiKeko;
    private char[][] kartta;
    
    public AStar(char[][] kartta) {
        super(kartta);
        this.minimiKeko = new Keko(kartta.length * kartta[0].length);
    }
    /**
     * Metodi saa parametreikseen alku- ja loppusolmut. Se asettaa alkusolmulle
     * alkuetäisyyden sekä arvioi kartan kullekin solmulle etäisyydet loppuun.
     * 
     * @param alku solmu, josta reitti alkaa
     * @param loppu solmu, johon reitti päättyy
     */
    public void alusta(Solmu alku, Solmu loppu) {
        alku.setLyhinEtaisyysAlusta(0);
        //hae tässä kartta
        for (int i = 0; i < kartta.length; i++) {
            for (int j = 0; j < kartta[0].length; j++) {
                Solmu solmu = new Solmu(j, i);
                arvioiEtaisyysLoppuun(solmu, loppu);
            }
        }
    }
    /**
     * Metodi arvioi ja asettaa etäisyydet nykyisestä solmusta loppuun.
     * 
     * @param solmu nykyinen solmu
     * @param loppu solmu, johon reitti päättyy
     */
    public void arvioiEtaisyysLoppuun(Solmu solmu, Solmu loppu) {
        int etaisyysLoppuun = 
                (Math.abs(loppu.getX() - solmu.getX())
                + Math.abs(loppu.getY() - solmu.getY()));
        solmu.setEtaisyysArvioLoppuun(etaisyysLoppuun);
    }
}
