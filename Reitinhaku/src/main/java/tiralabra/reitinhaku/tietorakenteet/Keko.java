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
    
    public Keko() {
        this.koko = -1;
        this.solmut = new Solmu[10];
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
        vaihdaSolmut(0, this.koko);
        this.koko--;
        painaAlas(0);
        return arvo;
    }
    /**
     * Metodi lisää solmun minimikekoon ja kutsuu muita metodeja kekoehdon
     * säilyttämiseksi.
     * @param solmu lisättävä solmu
     */
    public void lisaaSolmu(Solmu solmu) {
        koko++;
        int i = koko;
        while(i > 0 && solmut[etsiVanhempi(i)] == null || i > 0 && solmut[etsiVanhempi(i)].compareTo(solmu) == 1) {
            vaihdaSolmut(i, etsiVanhempi(i));
            i = etsiVanhempi(i);
        }
        solmut[i] = solmu;
        solmu.setSijainti(i);
    }
    /**
     * Metodi vaihtaa kahden solmun paikat.
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
     * Metodi, joka huolehtii siitä, että minimikeon kekoehto toteutuu. Metodi
     * kutsuu vaihdaSolmut-metodia ja itseään rekursiivisesti, kunnes kekoehto
     * täyttyy.
     * 
     * @param sijainti solmun sijainti keossa
     */
    public void painaAlas(int sijainti) {
        int vasen = etsiVasenLapsi(sijainti);
        int oikea = etsiOikeaLapsi(sijainti);
        int pienin;
        if (!onLehti(sijainti)) {
            if (oikea <= this.koko) { //solmulla on molemmat lapset
                if (solmut[vasen].compareTo(solmut[oikea]) == -1 || solmut[oikea] == null) { //valitaan pienempi lapsista
                    pienin = vasen;
                } else {
                    pienin = oikea;
                }
                if (solmut[sijainti].compareTo(solmut[pienin]) == 1) {
                    vaihdaSolmut(sijainti, pienin);
                    painaAlas(pienin);
                }
            } else if (solmut[vasen] != null && vasen == this.koko && solmut[sijainti].compareTo(solmut[vasen]) == 1) {
                vaihdaSolmut(sijainti, vasen);
            }
        }
    }
     /**
     * Metodi, joka tarkistaa, onko annetussa sijainnissa oleva solmu lehti.
     * 
     * @param sijainti solmun sijainti keossa
     * @return true jos solmu on lehti, muuten false
     */
    public boolean onLehti(int sijainti) { 
        if (sijainti >= (this.koko / 2) && sijainti <= koko) { 
            return true; 
        } 
        return false; 
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
    /**
     * Metodi laskee solmun vanhemman sijainnin ja palauttaa sen.
     * 
     * @param sijainti solmun sijainti keossa
     * @return vanhemman sijainti
     */
    public int etsiVanhempi (int sijainti) {
        int vanhempi = (int) Math.floor(sijainti / 2);
        return vanhempi;
    }
    
    public int getKeonKoko() {
        return solmut.length;
    }
    /**
     * Metodi tarkistaa, onko keko tyhjä.
     * 
     * @return true jos keko on tyhjä, muuten false
     */
    public boolean isEmpty() {
        if (getKeonKoko() == -1) {
            return true;
        } else {
            return false;
        }
    }
}
