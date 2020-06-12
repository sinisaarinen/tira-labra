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
    private int lyhinReitti;
    private int[][] etaisyys;
    private boolean[][] kasitelty;
    
    public Dijkstra(char[][] kartta) {
        this.kartta = kartta;
        this.minimiKeko = new Keko(kartta.length * kartta[0].length);
        this.lyhinReitti = 0;
        this.etaisyys = new int[kartta.length][kartta[0].length];
        this.kasitelty = new boolean[kartta.length][kartta[0].length];
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
     * solmu, kutsutaan metodia reitinPituus. Jos alkusolmusta ei ole mahdollista
     * päästä loppusolmuun, metodi palauttaa -1.
     * 
     * @param alku solmu, josta reitti alkaa
     * @param solmu, johon reitti päättyy
     * @return reitin pituus
     */
    public int laskeReitinPituus(Solmu alku, Solmu loppu) {
        this.minimiKeko.lisaaSolmu(alku);
        alku.setKekoon();

        while (!minimiKeko.isEmpty()) {
            Solmu kasiteltava = minimiKeko.poistaPienin();
            kasitelty[kasiteltava.getX()][kasiteltava.getY()] = true;
            kasiteltava.setKasitelty();

            if (kasiteltava.equals(loppu)) {
                return reitinPituus(kasiteltava);
            }
            etsi(kasiteltava, loppu);
        }
        return -1;
    }
    /**
     * Metodi saa parametrikseen solmun, johon reitti päättyy. Se laskee reitin
     * pituuden etsimällä aina solmun vanhemman, kunnes vanhempia ei enää ole.
     * Tällöin reitin pituus on saatu laskettua.
     * 
     * @param solmu solmu, johon reitti päättyy
     * @return reitin pituus
     */
    public int reitinPituus(Solmu solmu) {
        if (solmu.getVanhempi() != null) {
            lyhinReitti++;
            reitinPituus(solmu.getVanhempi());
        }
        return lyhinReitti;
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
        tutkiEtaisyyksia(kasiteltava.getX() - 1, kasiteltava.getY(), kasiteltava, loppu);
        //askel alas
        tutkiEtaisyyksia(kasiteltava.getX() + 1, kasiteltava.getY(), kasiteltava, loppu);
        //askel vasemmalle
        tutkiEtaisyyksia(kasiteltava.getX(), kasiteltava.getY() - 1, kasiteltava, loppu);
        //askel oikealle
        tutkiEtaisyyksia(kasiteltava.getX(), kasiteltava.getY() + 1, kasiteltava, loppu);  
    }
    /**
     * Metodi tarkistaa ensin, onko annettu solmu kartalla ja onko siihen mahdollista
     * edetä. Tämän jälkeen solmulle lasketaan etäisyys alusta ja se lisätään kekoon.
     * 
     * @param y solmun y-koordinaatti
     * @param x solmun x-koordinaatti
     * @param edeltaja edeltäjäsolmu
     * @param loppu loppusolmu
     */
    public void tutkiEtaisyyksia(int x, int y, Solmu edeltaja, Solmu loppu) {
        if ((x >= 0 && x < kartta.length) && (y >= 0 && y < kartta[0].length) && kartta[x][y] == '.' && kasitelty[x][y] == false) {
            if (edeltaja.getLyhinEtaisyysAlusta() + 1 < etaisyys[x][y]) {
                int etaisyysAlusta = edeltaja.getLyhinEtaisyysAlusta() + 1;
                etaisyys[x][y] = etaisyysAlusta;
                Solmu solmu = new Solmu(x, y, etaisyysAlusta, edeltaja);                
                minimiKeko.lisaaSolmu(solmu);
                solmu.setKekoon();
            }
        }
    }
    
    public Keko getKeko() {
        return this.minimiKeko;
    }
}
