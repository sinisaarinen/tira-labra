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
    private int kasiteltyja;
    private boolean[][] kasitelty;
    private int[][] reitti;
    private double[][] etaisyysAlusta;

    public AStar(char[][] kartta) {
        this.kartta = kartta;
        this.minimiKeko = new Keko(kartta.length * kartta[0].length);
        this.kasiteltyja = 0;
        this.etaisyysAlusta = new double[kartta.length][kartta[0].length];
        this.kasitelty = new boolean[kartta.length][kartta[0].length];
        this.reitti = new int[kartta.length][kartta[0].length];
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
     * @param x nykyisen solmun x-koordinaatti
     * @param y nykyisen solmun y-koordinaatti
     * @param loppu solmu, johon reitti päättyy
     * 
     * @return arvioitu etäisyys x- ja y-koordinaateista loppusolmuun
     */
    public double arvioiEtaisyysLoppuun(int x, int y, Solmu loppu) {
        double etaisyysLoppuun
                = Math.sqrt((Math.pow(loppu.getX() - x, 2)
                + Math.pow(loppu.getY() - y, 2)));
        return etaisyysLoppuun;
    }
    /**
     * Metodi laskee lyhimmän reitin alku- ja loppusolmun välillä. Keon solmuja
     * käsitellään niin pitkään, kunnes joko reitin päätepiste tulee käsittelyyn
     * ja algoritmi kutsuu metodia reitinPituus, joka merkitsee A-Starin kulkeman reitin sekä 
     * palauttaa lyhimmän reitin, tai keossa ei ole enää solmuja, jolloin algoritmi palauttaa -1.
     *
     * @param alku solmu, josta reitti alkaa
     * @param loppu solmu, johon reitti päättyy
     * 
     * @return reitin pituus, jos reitti löytyy, muuten -1
     */
    public double laskeReitti(Solmu alku, Solmu loppu) {
        alku.setLyhinEtaisyysAlusta(0);
        etaisyysAlusta[alku.getX()][alku.getY()] = 0;
        minimiKeko.lisaaSolmu(alku);

        while (!minimiKeko.isEmpty()) {
            Solmu kasiteltava = minimiKeko.poistaPienin();
            kasitelty[kasiteltava.getX()][kasiteltava.getY()] = true;
            kasiteltyja++;

            if (kasiteltava.equals(loppu)) {
                reitinPituus(kasiteltava);
                return this.etaisyysAlusta[kasiteltava.getX()][kasiteltava.getY()];
            }
            etsi(kasiteltava, loppu);
        }
        return -1;
    }
    /**
     * Metodi merkitsee lyhimmän reitin loppusolmusta alkusolmuun kutsumalla solmun
     * edeltäjää niin kauan, ettei edeltäjää enää ole eli ollaan päästy alkupisteeseen.
     *
     * @param solmu solmu, johon reitti päättyy
     */
    public void reitinPituus(Solmu solmu) {
        this.reitti[solmu.getX()][solmu.getY()] = 2;
        if (solmu.getVanhempi() != null) {
            reitinPituus(solmu.getVanhempi());
        }
    }
    /**
     * Metodi etsii käsiteltävän solmun ympärillä solmut ja antaa niiden koordinaatit parametreiksi 
     * tutkiEtaisyyksia-metodille selvittääkseen, mihin käsiteltävästä solmusta voidaan seuraavaksi siirtyä.
     *
     * @param kasiteltava solmu, joka on nyt käsittelyssä
     * @param loppu solmu, johon reitti päättyy
     */
    public void etsi(Solmu kasiteltava, Solmu loppu) {
        //askel ylös
        tutkiEtaisyyksia(kasiteltava.getX() - 1, kasiteltava.getY(), kasiteltava, loppu, false);
        //askel alas
        tutkiEtaisyyksia(kasiteltava.getX() + 1, kasiteltava.getY(), kasiteltava, loppu, false);
        //askel vasemmalle
        tutkiEtaisyyksia(kasiteltava.getX(), kasiteltava.getY() - 1, kasiteltava, loppu, false);
        //askel oikealle
        tutkiEtaisyyksia(kasiteltava.getX(), kasiteltava.getY() + 1, kasiteltava, loppu, false);
        //askel koilliseen
        tutkiEtaisyyksia(kasiteltava.getX() + 1, kasiteltava.getY() + 1, kasiteltava, loppu, true);
        //askel kaakkoon
        tutkiEtaisyyksia(kasiteltava.getX() + 1, kasiteltava.getY() - 1, kasiteltava, loppu, true);
        //askel lounaaseen
        tutkiEtaisyyksia(kasiteltava.getX() - 1, kasiteltava.getY() - 1, kasiteltava, loppu, true);
        //askel luoteeseen
        tutkiEtaisyyksia(kasiteltava.getX() - 1, kasiteltava.getY() + 1, kasiteltava, loppu, true);
    }
    /**
     * Metodi tarkistaa ensin, että solmu sijaitsee kartan rajojen sisällä ja siihen
     * on mahdollista kulkea eikä sitä ole vielä käsitelty. Jos solmun nykyistä etäisyyttä
     * alusta on mahdollista parantaa, parannetaan etäisyyttä alusta ja lasketaan etäisyysarvio
     * loppuun. Tämän jälkeen luodaan uusi solmuolio, joka lisätään kekoon.
     *
     * @param x solmun x-koordinaatti
     * @param y solmun y-koordinaatti
     * @param edeltaja solmun edeltäjä
     * @param loppu solmu, johon reitti päättyy
     * @param vinottain siirryttiinkö edellisestä solmusta vinottain vai ei
     */
    public void tutkiEtaisyyksia(int x, int y, Solmu edeltaja, Solmu loppu, boolean vinottain) {
        if ((x >= 0 && x < kartta.length) && (y >= 0 && y < kartta[0].length) && kartta[x][y] == '.' && kasitelty[x][y] == false) {
            double siirtyma = 1.00;
            if (vinottain == true) {
                siirtyma = Math.sqrt(2);
            }
            if (edeltaja.getLyhinEtaisyysAlusta() + siirtyma < etaisyysAlusta[x][y]) {
                double etaisyysAlustaDouble = edeltaja.getLyhinEtaisyysAlusta() + siirtyma;
                etaisyysAlusta[x][y] = etaisyysAlustaDouble;
                double etaisyysLopusta = arvioiEtaisyysLoppuun(x, y, loppu);
                Solmu solmu = new Solmu(x, y, etaisyysAlustaDouble, edeltaja);
                solmu.setEtaisyysArvioLoppuun(etaisyysLopusta);
                minimiKeko.lisaaSolmu(solmu);
            }
        }
    }
    
    public Keko getKeko() {
        return this.minimiKeko;
    }
    
    public int[][] getReitti() {
        return this.reitti;
    }
    
    public int getKasitellyt() {
        return this.kasiteltyja;
    }
}
