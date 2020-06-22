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

Dijkstran ja A*-algoritmi saavat parametrikseen matriisiksi muutetun kartan sekä alku- ja loppusolmut, joiden välille ne etsivät lyhyimmän reitin. Alku- ja loppusolmujen x- ja y-koordinaatit pitää toistaiseksi vaihtaa itse manuaalisesti Main-luokassa, jos algoritmien halutaan testata eri alku- ja loppusolmuille, eikä sovellus toimi oikein, jos alku- tai loppusolmuksi valitaan sellainen piste kartasta, johon ei voi kulkea (jos kokeilet itse muuttaa koordinaatteja eikä ohjelma toimi, syy on tämä). Tähän yritetään keksiä parempi ratkaisu ennen viimeistä palautusta.

Vertailunäkymässä on tällä hetkellä napit A*-, Dijkstran ja JPS-algoritmeille, joista viimeistä ei ole vielä toteutettu. Napin klikkaus kutsuu Logiikka-luokan metodia setValittuAlgo. Kun käyttäjä painaa Hae reitti -nappia, piirtää ohjelma kartalle lyhimmän reitin valitulla algoritmilla sekä ilmoittaa käyttäjälle reitin pituuden ja reitin hakemiseen kuluneen ajan. Reitit saa nollattua painamalla Pyyhi reitit -nappia.

## Tämänhetkiset puutteet

Tänne tullaan lähiaikoina lisäämään myös analyysi saavutetuista aika- ja tilavaativuuksista. Koska työn ideana on vertailla Dijkstran ja A*-algoritmin suorituskykyä reitinhaussa, lisätään tänne myös suorituskyky- ja O-analyysivertailu.

Lopulliseen toteutusdokumenttiin lisätään myös työn puutteet ja parannusehdotukset sekä tämän dokumentin mahdolliset lähteet.
