/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.reitinhaku.tietorakenteet;

/**
 *
 * @author saasini
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

    @Override
    public boolean equals(Object o) {
        Solmu vertailtava = (Solmu) o;
        if (x == vertailtava.getX() && y == vertailtava.getY()) {
            return true;
        }
        return false;
    }
}