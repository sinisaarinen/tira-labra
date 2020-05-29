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
    private int lyhinEtaisyysAlusta; //A*-algoritmille
    private int etaisyysArvioLoppuun; //A*-algoritmille
    Solmu vanhempi;
    private int sijainti; //Minimikeon käyttöön
    
    public Solmu(int y, int x) {
        this.x = x;
        this.y = y;
        this.lyhinEtaisyysAlusta = -1;
        this.sijainti = -1;
    }
    
    public Solmu(int y, int x, int etaisyys, Solmu vanhempi) {
        this.x = x;
        this.y = y;
        this.lyhinEtaisyysAlusta = etaisyys;
        this.vanhempi = vanhempi;
        this.sijainti = -1;
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

    public Solmu getVanhempi() {
        return vanhempi;
    }
    
    public void setSijainti(int sijainti) {
        this.sijainti = sijainti;
    }
    
    public int getSijainti() {
        return this.sijainti;
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