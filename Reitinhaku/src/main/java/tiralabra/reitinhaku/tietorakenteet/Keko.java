/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.reitinhaku.tietorakenteet;

/**
 *
 * Luokka vastaa minimikeko-tietorakenteesta. Keko on tallennettu taulukkona.
 */
public class Keko {
    
    private int koko;
    private Solmu[] solmut;
    
    public Keko(int koko) {
        this.koko = -1;
        this.solmut = new Solmu[koko];
    }
    
    public Solmu getPienin() {
        return solmut[0];
    }
    /**
     * Metodi poistaa keon pienimmän solmun ja palauttaa sen. Metodi myös kutsuu
     * painaAlas-metodia, jotta keko pysyy järjestyksessä.
     * @return keon pienin solmu
     */
    public Solmu poistaPienin() {
        Solmu arvo = solmut[0];
        vaihdaSolmut(0, koko);
        this.koko--;
        painaAlas(0);
        return arvo;
    }
     /**
     * Metodi vertailee kahden solmun paikat.
     * @param sijainti1 ensimmäisen solmun sijainti keossa
     * @param sijainti2 toisen solmun sijainti keossa
     */
    public void vaihdaSolmut(int sijainti1, int sijainti2) {
        Solmu apu = solmut[sijainti1];
        solmut[sijainti1] = solmut[sijainti2];
        solmut[sijainti2] = apu;
        if (solmut[sijainti1] != null) {
            solmut[sijainti1].setSijainti(sijainti1);
        }
        if (solmut[sijainti2] != null) {
            solmut[sijainti2].setSijainti(sijainti2);
        }
    }
    /**
     * Metodi, joka huolehtii siitä, että minimikeon kekovaatimus toteutuu. Metodi
     * kutsuu vaihdaSolmut-metodia ja itseään rekursiivisesti, kunnes kekovaatimus
     * täyttyy.
     * 
     * @param sijainti solmun sijainti keossa
     */
    public void painaAlas(int sijainti) {
        int vasen = etsiVasenLapsi(sijainti);
        int oikea = etsiOikeaLapsi(sijainti);
        int pienin;
        int apu;
        
        if (oikea <= koko) { //solmulla on molemmat lapset
            if (solmut[vasen].compareTo(solmut[oikea]) == -1 || solmut[oikea] == null) { //valitaan pienempi lapsista
                pienin = vasen;
            } else {
                pienin = oikea;
            }
            if (solmut[sijainti].compareTo(solmut[pienin]) == 1) {
                vaihdaSolmut(sijainti, pienin);
                painaAlas(pienin);
            }
        } else if (solmut[vasen] != null && vasen == koko && solmut[sijainti].compareTo(solmut[vasen]) == 1) {
            vaihdaSolmut(sijainti, vasen);
        }
    }
     /**
     * Metodi laskee solmun vasemman lapsen sijainnin ja palauttaa sen.
     * 
     * @param sijainti solmun sijainti keossa
     * @return vasemman lapsen sijainti
     */
    public int etsiVasenLapsi(int sijainti) {
        return 2 * sijainti;
    }
     /**
     * Metodi laskee solmun oikean lapsen sijainnin ja palauttaa sen.
     * 
     * @param sijainti solmun sijainti keossa
     * @return oikean lapsen sijainti
     */
    public int etsiOikeaLapsi(int sijainti) {
        return 2 * sijainti + 1;
    }
}
