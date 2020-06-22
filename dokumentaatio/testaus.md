# Testaus

## JUnit

Testausta on tähän mennessä tehty JUnitin avulla automaattisin testein. Kaikille tähän mennessä toteutetuille luokille on laadittu testit:
- Algoritmit: luokan AStar testit löytyvät testiluokasta AStarTest ja luokan Dijkstra testit luokasta DijkstraTest
- Tietorakenteet: Keko-luokan testeistä vastaa testiluokka KekoTest ja Solmu-luokan testeistä SolmuTest
- Kartanlukija: Kartanlukija-luokkaa testaa KartanlukijaTest
- Sovelluslogiikka: Logiikka-luokkaa testaa LogiikkaTest

Testit voi suorittaa avaamalla projektin Netbeansissa ja painamalla projektin nimen kohdalla oikeaa hiirenpainiketta ja klikkaamalla `Test`. Sama onnistuu myös painamalla Alt + F6. Terminaalissa taas testit voi suorittaa komennolla
```
mvn test
```
Testien rivi- ja haaraumakattavuutta voi tarkastella Jacocon avulla luomalla testikattavuudesta raportin komennolla
```
mvn test jacoco:report
```
Kattavuusraporttia voi tämän jälkeen tarkastella avaamalla selaimella tiedoston _target/site/jacoco/index.html_.

Tänne tullaan päivittämään kuva lopullisesta testikattavuudesta, kun sovellus on valmis.

## Suorituskykytestaus

Algoritmien suorituskykyä on mitattu vaihtamalla manuaalisesti reitin lähtö- ja maalipisteitä ja mittaamalla A*- ja Dijkstran algoritmeilla kuluvaa aikaa lyhimmän reitin löytämiseen. Suorituskykytestaukseen on käytetty Javan omaa System.currentTimeMillis()-metodia. A*-algoritmi toimii tällä hetkellä huomattavasti nopeammin kuin Dijkstra. Tarkempia lukuja ja grafiikkaa testauksen tuloksista päivitetään tänne pian.

Testit voidaan toistaa antamalla algoritmeille syötteiksi samat kartat ja samat alku- ja loppusolmut.
