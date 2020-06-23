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
    private Solmu[] polku;
    private int lyhinReitti;
    private int kasiteltyja;
    private boolean[][] kasitelty;
    private boolean[][] reitti;
    private int[][] etaisyysAlusta;

    public AStar(char[][] kartta) {
        this.kartta = kartta;
        this.minimiKeko = new Keko(kartta.length * kartta[0].length);
        this.polku = new Solmu[kartta.length * kartta[0].length];
        this.lyhinReitti = 0;
        this.kasiteltyja = 0;
        this.etaisyysAlusta = new int[kartta.length][kartta[0].length];
        this.kasitelty = new boolean[kartta.length][kartta[0].length];
        this.reitti = new boolean[kartta.length][kartta[0].length];
        for (int i = 0; i < kartta.length; i++) {
            for (int j = 0; j < kartta[0].length; j++) {
                kasitelty[i][j] = false;
                etaisyysAlusta[i][j] = Integer.MAX_VALUE;
                reitti[i][j] = false;
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
    public int arvioiEtaisyysLoppuun(int x, int y, Solmu loppu) {
        int etaisyysLoppuun
                = (Math.abs(loppu.getX() - x)
                + Math.abs(loppu.getY() - y));
        return etaisyysLoppuun;
    }
    /**
     * Metodi laskee lyhimmän reitin alku- ja loppusolmun välillä. Keon solmuja
     * käsitellään niin pitkään, kunnes joko reitin päätepiste tulee käsittelyyn
     * ja algoritmi kutsuu metodia reitinPituus, joka laskee reitin pituuden ja 
     * palauttaa sen, tai keossa ei ole enää solmuja, jolloin algoritmi palauttaa -1.
     *
     * @param alku solmu, josta reitti alkaa
     * @param loppu solmu, johon reitti päättyy
     * 
     * @return reitin pituus, jos reitti löytyy, muuten -1
     */
    public int laskeReitti(Solmu alku, Solmu loppu) {
        alku.setLyhinEtaisyysAlusta(0);
        etaisyysAlusta[alku.getX()][alku.getY()] = 0;
        minimiKeko.lisaaSolmu(alku);
        alku.setKekoon();

        while (!minimiKeko.isEmpty()) {
            Solmu kasiteltava = minimiKeko.poistaPienin();
            kasitelty[kasiteltava.getX()][kasiteltava.getY()] = true;
            kasiteltava.setKasitelty();
            kasiteltyja++;

            if (kasiteltava.equals(loppu)) {
                return reitinPituus(kasiteltava);
            }
            etsi(kasiteltava, loppu);
        }
        return -1;
    }
    /**
     * Metodi laskee lyhimmän reitin loppusolmusta alkusolmuun kutsumalla solmun
     * edeltäjää niin kauan, ettei edeltäjää enää ole eli ollaan päästy alkupisteeseen.
     *
     * @param alku solmu, johon reitti päättyy
     * 
     * @return lyhimmän reitin pituus
     */
    public int reitinPituus(Solmu solmu) {
        this.reitti[solmu.getX()][solmu.getY()] = true;
        if (solmu.getVanhempi() != null) {
            lyhinReitti++;
            reitinPituus(solmu.getVanhempi());
        }
        return lyhinReitti;
    }
    /**
     * Metodi etsii käsiteltävän solmun ylä- ja alapuolilla sekä oikealla ja vasemmalla
     * olevat solmut ja antaa niiden koordinaatit parametreiksi tutkiEtaisyyksia-metodille
     * selvittääkseen, mihin käsiteltävästä solmusta voidaan seuraavaksi siirtyä.
     *
     * @param kasiteltava solmu, joka on nyt käsittelyssä
     * @param loppu solmu, johon reitti päättyy
     */
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
     */
    public void tutkiEtaisyyksia(int x, int y, Solmu edeltaja, Solmu loppu) {
        if ((x >= 0 && x < kartta.length) && (y >= 0 && y < kartta[0].length) && kartta[x][y] == '.' && kasitelty[x][y] == false) {
            if (edeltaja.getLyhinEtaisyysAlusta() + 1 < etaisyysAlusta[x][y]) {
                int etaisyysAlustaInt = edeltaja.getLyhinEtaisyysAlusta() + 1;
                etaisyysAlusta[x][y] = etaisyysAlustaInt;
                int etaisyysLopusta = arvioiEtaisyysLoppuun(x, y, loppu);
                Solmu solmu = new Solmu(x, y, etaisyysAlustaInt, edeltaja);
                solmu.setEtaisyysArvioLoppuun(etaisyysLopusta);
                minimiKeko.lisaaSolmu(solmu);
                solmu.setKekoon();
            }
        }
    }
    
    public Keko getKeko() {
        return this.minimiKeko;
    }
    
    public boolean[][] getReitti() {
        return this.reitti;
    }
    
    public int getKasitellyt() {
        return this.kasiteltyja;
    }
}
