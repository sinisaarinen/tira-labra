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
 * Luokka vastaa Dijkstran algoritmin toteutuksesta.
 */
public class Dijkstra {
    
    private Keko minimiKeko;
    private char[][] kartta;
    private double[][] etaisyys;
    private int[][] reitti;
    private boolean[][] kasitelty;
    private int kasiteltyja;
    
    public Dijkstra(char[][] kartta) {
        this.kartta = kartta;
        this.minimiKeko = new Keko(kartta.length * kartta[0].length);
        this.kasiteltyja = 0;
        this.etaisyys = new double[kartta.length][kartta[0].length];
        this.kasitelty = new boolean[kartta.length][kartta[0].length];
        this.reitti = new int[kartta.length][kartta[0].length];
        for (int i = 0; i < kartta.length; i++) {
            for (int j = 0; j < kartta[0].length; j++) {
                etaisyys[i][j] = Integer.MAX_VALUE;
                kasitelty[i][j] = false;
            }
        }
    }
    /**
     * Metodi saa parametreikseen reitin alku- ja loppusolmut ja laskee niiden
     * välisen lyhyimmän reitin. Alkusolmu lisätään kekoon, jonka jälkeen kekoa
     * käsitellään kunnes se on tyhjä. Jos käsiteltävä solmu on sama kuin loppu-
     * solmu, kutsutaan metodia reitinPituus ja palautetaan reitin pituus. 
     * Jos alkusolmusta ei ole mahdollista päästä loppusolmuun, metodi palauttaa -1.
     * 
     * @param alku solmu, josta reitti alkaa
     * @param loppu solmu, johon reitti päättyy
     * @return reitin pituus
     */
    public double laskeReitinPituus(Solmu alku, Solmu loppu) {
        alku.setLyhinEtaisyysAlusta(0);
        etaisyys[alku.getX()][alku.getY()] = 0;
        this.minimiKeko.lisaaSolmu(alku);

        while (!minimiKeko.isEmpty()) {
            Solmu kasiteltava = minimiKeko.poistaPienin();
            kasitelty[kasiteltava.getX()][kasiteltava.getY()] = true;
            kasiteltyja++;

            if (kasiteltava.equals(loppu)) {
                reitinPituus(kasiteltava);
                return this.etaisyys[kasiteltava.getX()][kasiteltava.getY()];
            }
            etsi(kasiteltava, loppu);
        }
        return -1;
    }
    /**
     * Metodi saa parametrikseen solmun, johon reitti päättyy. Se kutsuu itseään rekursiivisesti, 
     * kunnes päästiin alkusolmuun ja reitti on merkitty taulukkoon.
     * 
     * @param solmu solmu, johon reitti päättyy
     */
    public void reitinPituus(Solmu solmu) {
        this.reitti[solmu.getX()][solmu.getY()] = 1;
        if (solmu.getVanhempi() != null) {
            reitinPituus(solmu.getVanhempi());
        }
    }
    /**
     * Metodi saa parametreikseen käsiteltävän solmun ja loppusolmun. Se kutsuu
     * metodia tutkiEtaisyyksia kaikkien solmun naapureiden osalta tarkistaakseen,
     * voidaanko naapurisolmujen etäisyyksiä päivittää.
     * 
     * @param kasiteltava käsiteltävä solmu
     * @param loppu loppusolmu
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
     * Metodi tarkistaa ensin, onko annettu solmu kartalla ja onko siihen mahdollista
     * edetä. Tämän jälkeen solmulle lasketaan etäisyys alusta ja se lisätään kekoon.
     * 
     * @param y solmun y-koordinaatti
     * @param x solmun x-koordinaatti
     * @param edeltaja edeltäjäsolmu
     * @param loppu loppusolmu
     * @param vinottain siirryttiinkö edeltävästä solmusta vinottain vai ei
     */
    public void tutkiEtaisyyksia(int x, int y, Solmu edeltaja, Solmu loppu, boolean vinottain) {
        if ((x >= 0 && x < kartta.length) && (y >= 0 && y < kartta[0].length) && kartta[x][y] == '.' && kasitelty[x][y] == false) {
            double siirtyma = 1.00;
            if (vinottain == true) {
                siirtyma = Math.sqrt(2);
            }
            if (edeltaja.getLyhinEtaisyysAlusta() + siirtyma < etaisyys[x][y]) {
                double etaisyysAlusta = edeltaja.getLyhinEtaisyysAlusta() + siirtyma;
                etaisyys[x][y] = etaisyysAlusta;
                Solmu solmu = new Solmu(x, y, etaisyysAlusta, edeltaja);                
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
