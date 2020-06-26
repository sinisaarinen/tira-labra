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

Algoritmien suorituskykyä on testattu mittaamalla A*- ja Dijkstran algoritmeilla kuluvaa aikaa lyhimmän reitin löytämiseen eri kartoissa. Suorituskykytestaukseen on käytetty Javan omaa System.currentTimeMillis()-metodia. 

Testausta on tehty antamalla algoritmeille syötteinä samat matriisimuodossa olevat kartat sekä samat alku- ja loppusolmut. Algoritmien toimivuus on varmistettu toteuttamalla graafinen esitys lyhyimmistä reiteistä käyttöliittymään sekä tarkistamalla, että löydetyt lyhimmät reitit ovat kaikilla syötteillä samanmittaiset A*- ja Dijkstran algoritmeilla.

Alle on listattu suorituskykytestauksen yhteenveto taulukoituna. Ajat on laskettu kymmenen perättäisen haun keskiarvona. Iteraatiot tarkoittaa läpikäytyjen solmujen määrää.

| Algoritmi  | Kartta  | Iteraatiot  | Lyhin reitti | Aika (ms) |
|---------------|-------------|------|---------|-----------|
| Dijkstra | - | - | - | - |

Testit voidaan toistaa antamalla algoritmeille syötteiksi samat kartat ja samat alku- ja loppusolmut.
