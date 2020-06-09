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
public class AStar {
    
    private Keko minimiKeko;
    private char[][] kartta;
    private Solmu[] lista;
    private Solmu[] polku;
    private int lyhinReitti;
    private boolean[][] kasitelty;
    private int[][] etaisyysAlusta;
    
    public AStar(char[][] kartta) {
        this.kartta = kartta;
        this.minimiKeko = new Keko(kartta.length * kartta[0].length);
        this.polku = new Solmu[kartta.length * kartta[0].length];
        this.lyhinReitti = 0;
        this.etaisyysAlusta = new int[kartta.length][kartta[0].length];
        this.kasitelty = new boolean[kartta.length][kartta[0].length];
        for (int i = 0; i < kartta.length; i++) {
            for (int j = 0; j < kartta[0].length; j++) {
                kasitelty[i][j] = false;
                etaisyysAlusta[i][j] = Integer.MAX_VALUE;
            }
        }
    }
    /**
     * Metodi arvioi ja asettaa etäisyydet nykyisestä solmusta loppuun.
     * 
     * @param solmu nykyinen solmu
     * @param loppu solmu, johon reitti päättyy
     */
    public int arvioiEtaisyysLoppuun(int x, int y, Solmu loppu) {
        int etaisyysLoppuun = 
                (Math.abs(loppu.getX() - x)
                + Math.abs(loppu.getY() - y));
        return etaisyysLoppuun;
    }
    
    public int laskeReitti(Solmu alku, Solmu loppu) {
        alku.setLyhinEtaisyysAlusta(0);
        etaisyysAlusta[alku.getX()][alku.getY()] = 0;
        minimiKeko.lisaaSolmu(alku);
        
        while (!minimiKeko.isEmpty()) {
            Solmu kasiteltava = minimiKeko.poistaPienin();
            kasitelty[kasiteltava.getX()][kasiteltava.getY()] = true;
            
            if (kasiteltava.equals(loppu)) {
                return reitinPituus(kasiteltava);
            }
            etsi(kasiteltava, loppu);
        }
        return -1;
    }
    
    public int reitinPituus(Solmu solmu) {
        if (solmu.getVanhempi() != null) {
            lyhinReitti++;
            reitinPituus(solmu.getVanhempi());
        }
        return lyhinReitti;
    }
    
    public void etsi(Solmu kasiteltava, Solmu loppu) {
        //askel ylös
        tutkiEtaisyyksia(kasiteltava.getX() - 1, kasiteltava.getY(), kasiteltava, loppu);
        //askel alas
        tutkiEtaisyyksia(kasiteltava.getX() + 1, kasiteltava.getY(), kasiteltava, loppu);
        //askel vasemmalle
        tutkiEtaisyyksia(kasiteltava.getX(), kasiteltava.getY() - 1, kasiteltava, loppu);
        //askel oikealle
        tutkiEtaisyyksia(kasiteltava.getX(), kasiteltava.getY() + 1, kasiteltava, loppu);  
    }
    
    public void tutkiEtaisyyksia(int x, int y, Solmu edeltaja, Solmu loppu) {
        if ((x >= 0 && x < kartta.length) && (y >= 0 && y < kartta[0].length) && kartta[x][y] == '.' && kasitelty[x][y] == false && etaisyysAlusta[x][y] == Integer.MAX_VALUE) {
            int etaisyysAlustaInt = edeltaja.getLyhinEtaisyysAlusta() + 1;
            etaisyysAlusta[x][y] = etaisyysAlustaInt;
            int etaisyysLopusta = arvioiEtaisyysLoppuun(x, y, loppu);
            Solmu solmu = new Solmu(x, y, etaisyysAlustaInt, edeltaja);
            solmu.setEtaisyysArvioLoppuun(etaisyysLopusta);
            minimiKeko.lisaaSolmu(solmu);
        }
    }
}

