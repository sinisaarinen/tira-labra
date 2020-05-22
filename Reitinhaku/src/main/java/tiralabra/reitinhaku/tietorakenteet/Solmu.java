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
public class Solmu {
    
    private int x;
    private int y;
    private int etaisyys;
    Solmu vanhempi;
    
    public Solmu(int y, int x) {
        this.x = x;
        this.y = y;
        this.etaisyys = -1;
    }
    
    public Solmu(int y, int x, int etaisyys, Solmu vanhempi) {
        this.x = x;
        this.y = y;
        this.etaisyys = etaisyys;
        this.vanhempi = vanhempi;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public int getEtaisyys() {
        return etaisyys;
    }

    public Solmu getVanhempi() {
        return vanhempi;
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
}