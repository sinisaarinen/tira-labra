# Vaatimusmäärittely

Harjoitustyön aiheeksi olen valinnut reitinhaun. Tarkoitus on kehittää sovellus, joka etsii nopeimman tai lyhyimmän reitin kahden pisteen välillä kartasta. Karttaa käsitellään verkkona, jossa solmuja ovat esimerkiksi kaupungit Suomen kartalla.

Harjoitustyössäni aion vertailla A*-algoritmia ja Dijkstran algoritmia, jotka valitsin siksi, että ne ovat yleisiä reitinhaussa käytettyjä algoritmeja. Tietorakenteista tulen käyttämään ainakin kekoa, verkkoa ja solmua.

Syötteenä ohjelma saa kartan sekä alku- ja loppusolmun eli ne kaupungit, joiden välinen reitti halutaan optimoida. Luultavasti tämä tullaan toteuttamaan siten, että käyttöliittymä tarjoaa mahdollisuuden valita lähtö- ja päätepisteen listalla olevista kaupungeista.

Kekoa käyttämällä Dijkstran algoritmilla pyritään kokonaisaikavaativuuteen O((|E|+|V|) log(|V|)). A*-algoritmin aikavaativuus on sama kuin Dijkstran algoritmilla. Tilavaativuus Dijkstran algoritmilla ja A*-algoritmilla on O(|V|).




Lähteet:

Wikipedia (2020a) _Dijkstran algoritmi_. <https://fi.wikipedia.org/wiki/Dijkstran_algoritmi>, haettu 15.5.2020.

Wikipedia (2020b) _A*-algoritmi_. <https://fi.wikipedia.org/wiki/A*-algoritmi>, haettu 15.5.2020.

Wikipedia (2020c) _A* search algorithm_. <https://en.wikipedia.org/wiki/A*_search_algorithm>, haettu 15.5.2020.
