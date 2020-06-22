# Viikko 6

Tähän mennessä viikko on kulunut käyttöliittymän rakenteluun. Käytin ensimmäiseen versioon käyttöliittymästä melkein kokonaisen työpäivän, mutta en saanut sitä toimimaan, joten päätin kysyä ryhmästä apua ja lähdin toteuttamaan sitä uudelleen alusta. Nyt käyttöliittymä on siinä vaiheessa, että sillä pystyy piirtämään graafisen esityksen kartoista ja piirtämään lyhyimmän reitin manuaalisesti asetetuiden alku- ja loppupisteiden välille. Toteutin käyttöliittymään kaksi näkymään, joista ensimmäisessä pääsee valitsemaan neljästä kartasta ja siirtymään vertailuun. Vertailunäkymässä valittuun karttaan voi hakea lyhimmän reitin A*- ja Dijkstran algoritmeilla. Käyttäjälle ilmoitetaan myös haetun reitin pituus ja hakuun kulunut aika, mikä mahdollistaa vertailun. Ainoa puute tällä hetkellä on se, että alku- ja loppusolmu tulee vaihtaa koodiin manuaalisesti ja tulee tarkastaa, että valitut alku- ja loppusolmut eivät sijaitse valitussa kartassa minkään esteen päällä. JPS-algoritmille on toteutettu nappi, mutta sen painaminen ei johda vielä mihinkään, koska en ole algoritmia vielä ehtinyt toteuttaa.

Toteutin myös tällä viikolla Logiikka-luokan käyttöliittymää kehittäessä. Sovelluslogiikkaa kutsutaan käyttöliittymästä ja se toimii algoritmeihin ja karttoihin liittyvien toimintojen välikappaleena. Tein myös lisää testejä, lisäsin kommentoinnin kaikkiin luokkiin ja poistin Checkstyle-virheet. Poistin myös käyttöliittymän koodin kokonaan testikattavuusraportista. Lisäksi tein suorituskykytestausta ja päivitin dokumentaatiota.

Seuraavaksi
- Lisään kulmittain liikkumisen algoritmeihin
- Toteutan JPS-algoritmin
- Yritän keksiä paremman keinon alku- ja loppusolmun valitsemiseen

Aikaa projektiin kului tällä viikolla noin 20 tuntia.
