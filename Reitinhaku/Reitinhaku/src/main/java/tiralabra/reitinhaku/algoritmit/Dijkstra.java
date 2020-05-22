/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.reitinhaku.algoritmit;

/**
 *
 * @author saasini
 */
public class Dijkstra {
    
    
    keko.push((0,alku))
    while not keko.empty()
    solmu = keko.pop()[1]
    if kasitelty[solmu]
    continue
    kasitelty[solmu] = true
    for kaari in verkko[solmu]
    nyky = etaisyys[kaari.loppu]
    uusi = etaisyys[solmu]+kaari.paino
    if uusi < nyky
    etaisyys[kaari.loppu] = uusi
    keko.push((uusi,kaari.loppu))
}
