/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.reitinhaku.tietorakenteet;

/**
 * 
 * Luokka vastaa yksittäisistä solmuista ja niiden toiminnoista
 */
public class Solmu implements Comparable<Solmu> {
    
    private int x;
    private int y;
    private int lyhinEtaisyysAlusta; //A*-algoritmille ja Dijkstralle
    private int etaisyysArvioLoppuun; //A*-algoritmille
    Solmu vanhempi;
    private int sijaintiKeossa; //Minimikeon käyttöön
    private Solmu ylaNaapuri;
    private Solmu alaNaapuri;
    private Solmu vasenNaapuri;
    private Solmu oikeaNaapuri;
    
    public Solmu(int x, int y) {
        this.x = x;
        this.y = y;
        this.lyhinEtaisyysAlusta = -1;
        this.sijaintiKeossa = -1;
    }
    
    public Solmu(int x, int y, int lyhinEtaisyysAlusta, Solmu vanhempi) {
        this.x = x;
        this.y = y;
        this.lyhinEtaisyysAlusta = lyhinEtaisyysAlusta;
        this.vanhempi = vanhempi;
        this.sijaintiKeossa = -1;
    }
    /**
     * Metodi asettaa solmulle naapurit kaikkiin neljään ilmansuuntaan.
     * 
     * @param x solmun x-koordinaatti
     * @param y solmun y-koordinaatti
     */
    public void setNaapurit(int x, int y) {
        this.ylaNaapuri = new Solmu(x, y - 1);
        this.alaNaapuri = new Solmu(x, y + 1);
        this.vasenNaapuri = new Solmu((x - 1), y);
        this.oikeaNaapuri = new Solmu((x + 1), y);

    }
    
    public Solmu getYlaNaapuri() {
        return this.ylaNaapuri;
    }
    
    public Solmu getAlaNaapuri() {
        return this.alaNaapuri;
    }
    
    public Solmu getVasenNaapuri() {
        return this.vasenNaapuri;
    }
    
    public Solmu getOikeaNaapuri() {
        return this.oikeaNaapuri;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public int getLyhinEtaisyysAlusta() {
        return lyhinEtaisyysAlusta;
    }
    
    public int getEtaisyysArvioLoppuun() {
        return etaisyysArvioLoppuun;
    }
    
    public void setLyhinEtaisyysAlusta(int etaisyys) {
        this.lyhinEtaisyysAlusta = etaisyys;
    }
    
    public void setEtaisyysArvioLoppuun(int etaisyys) {
        this.etaisyysArvioLoppuun = etaisyys;
    }

    public Solmu getVanhempi() {
        return vanhempi;
    }
    
    public void setSijainti(int sijainti) {
        this.sijaintiKeossa = sijainti;
    }
    
    public int getSijainti() {
        return this.sijaintiKeossa;
    }
    /**
     * Metodi vertailee kahta solmua.
     * @param o vertailtava solmu
     * @return true jos solmut ovat samat, muuten false
     */
    @Override
    public boolean equals(Object o) {
        Solmu vertailtava = (Solmu) o;
        if (x == vertailtava.getX() && y == vertailtava.getY()) {
            return true;
        }
        return false;
    }
     /**
     * Metodi vertailee kahta solmua niiden etäisyyksien perusteella.
     * @param s vertailtava solmu
     * @return -1 jos vertailtavan solmun etäisyys on suurempi, 1 jos vertailtavan
     * solmun etäisyys on pienempi ja 0 jos vertailtavaa solmua ei olemassa tai
     * solmujen etäisyydet ovat yhtä suuret.
     */
    @Override
    public int compareTo(Solmu s) {
        if (s == null) {
            return 0;
        }
        double etaisyys = this.lyhinEtaisyysAlusta + this.etaisyysArvioLoppuun;
        double vertailtavanEtaisyys = s.getLyhinEtaisyysAlusta() + s.getEtaisyysArvioLoppuun();

        if (etaisyys < vertailtavanEtaisyys) {
            return -1;
        } 
        if (etaisyys == vertailtavanEtaisyys) {
            return 0;            
        }
        return 1;        
    }
}