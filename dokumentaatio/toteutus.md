# Toteutus

## Yleisrakenne

Ohjelma on jaettu kuuteen pakkaukseen:
- tiralabra.reitinhaku.algoritmit sisältää luokat A*- ja Dijkstran algoritmeille
- tiralabra.reitinhaku.kartat sisältää Kartanlukija-luokan
- tiralabra.reitinhaku.logiikka sisältää sovelluslogiikan
- tiralabra.reitinhaku.main sisältää Main-luokan
- tiralabra.reitinhaku.tietorakenteet sisältää luokat minimikeolle ja solmulle
- tiralabra.reitinhaku.ui sisältää käyttöliittymän

Ohjelma käynnistetään Main-metodista, joka avaa näytölle käyttöliittymän. Ensimmäisenä avautuu Menu-näkymä, jossa käyttäjä pääsee valitsemaan neljästä eri kartasta. Jos karttaa ei valitse, valitaan oletuksena Lontoon kartta. Karttanappien painaminen kutsuu sovelluslogiikan metodia setValittuKartta. Tämän jälkeen Vertailu-nappia painamalla pääsee siirtymään toiseen näkymään.

Vertailu-napin painaminen tyhjentää piirtoalustan mahdollisista aiemmin piirretyistä kartoista ja reiteistä sekä nollaa kuluneen ajan ja lasketun reitin pituuden, jotka näytetään käyttäjälle. Tämän jälkeen kutsutaan piirraKartta-metodia, joka saa parametrikseen Logiikka-luokan tiedossa olevan valitun kartan sekä tyhjän piirtoalustan, johon kartta piirretään. Logiikka-luokan kutsuttava metodi getValittuKarttaMatriisina antaa Kartanlukija-luokalle parametrina oikean kartan, joka muutetaan Kartanlukija-luokassa matriisiksi. Jos karttaa ei löydy tai sen luku ei onnistu, ilmoittaa sovellus tästä käyttäjälle.

Dijkstran ja A*-algoritmi saavat parametrikseen matriisiksi muutetun kartan sekä alku- ja loppusolmut, joiden välille ne etsivät lyhyimmän reitin. Kun käyttäjä painaa Hae reitti -nappia, piirtää ohjelma kartalle lyhimmät reitit molemmilla algoritmeilla sekä ilmoittaa käyttäjälle reitin pituuden, käsiteltyjen solmujen määrän ja reitin hakemiseen kuluneen ajan. Reitit saa nollattua painamalla Pyyhi reitit -nappia.

## Saavutetut aika- ja tilavaativuudet
Dijkstran ja A*-algoritmin kokonaisaikavaativuus on O((|E|+|V|) log(|V|)), jossa V on solmujen lukumäärä ja E kaarien lukumäärä. Tilavaativuus Dijkstran algoritmilla ja A*-algoritmilla on O(|V|).

## Suorituskykyvertailu

Vaikka Dijkstran ja A*-algoritmilla onkin teoriassa sama aikavaativuus, käy [suorituskykytestien](testaus.md) tuloksista ilmi, että A*-algoritmi toimii huomattavasti Dijkstraa nopeammin ja käy läpi vähemmän solmuja. Ainoastaan yhdessä testissä (tulostaulukon kolmas ja neljäs rivi) A*-algoritmilla meni keskimäärin enemmän aikaa lyhyimmän reitin löytämiseen. Tässä testissä valittiin tarkoituksella A*-algoritmille epäedullinen tilanne, jossa lyhin reitti kiersi useamman esteen ympäri.

## Puutteet ja parannusehdotukset

Työhön ei ehditty toteuttaa JPS-algoritmia. JPS-algoritmi olisi mahdollistanut monipuolisemman suorituskykytestaamisen. Käyttöliittymän kehitys jäi myös kesken: alku- ja loppusolmut olisi kätevämpi pystyä valitsemaan suoraan karttaa klikkaamalla, jolloin ei pitäisi arvioida, osuvatko syötetyt koordinaatit esteen päälle.

Lähteet:

Wikipedia (2020a) Dijkstran algoritmi. https://fi.wikipedia.org/wiki/Dijkstran_algoritmi, haettu 15.5.2020.

Wikipedia (2020b) A*-algoritmi. https://fi.wikipedia.org/wiki/A*-algoritmi, haettu 15.5.2020.

Wikipedia (2020c) A* search algorithm. https://en.wikipedia.org/wiki/A*_search_algorithm, haettu 15.5.2020.
