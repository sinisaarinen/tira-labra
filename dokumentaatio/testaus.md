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

Algoritmien suorituskykyä on testattu mittaamalla A*- ja Dijkstran algoritmeilla kuluvaa aikaa lyhimmän reitin löytämiseen eri kokoisissa kartoissa. Suorituskykytestaukseen on käytetty Javan omaa System.currentTimeMillis()-metodia. 

Testausta on tehty antamalla algoritmeille syötteinä samat matriisimuodossa olevat kartat sekä samat alku- ja loppusolmut. Algoritmien toimivuus on varmistettu toteuttamalla graafinen esitys lyhyimmistä reiteistä käyttöliittymään sekä tarkistamalla, että löydetyt lyhimmät reitit ovat kaikilla syötteillä samanmittaiset A*- ja Dijkstran algoritmeilla.

Alle on listattu suorituskykytestauksen yhteenveto taulukoituna. Kartan koko on ilmoitettu nimen jälkeen suluissa. Alku- ja loppusolmut on ilmoitettu muodossa (x,y). Ajat on laskettu kymmenen perättäisen haun keskiarvona. Iteraatiot tarkoittaa läpikäytyjen solmujen määrää. Kaikki testauksessa käytetyt kartat löytyvät [täältä](https://movingai.com/benchmarks/street/index.html).

| Algoritmi  | Kartta  | Alkusolmu | Loppusolmu | Iteraatiot  | Lyhin reitti | Aika (ms) |
|---------------|-------------|------|---------|-----------|-----------|---------|
| Dijkstra | Moscow_1_256.map (256x256) | (0,0) | (240,240) | 48585 | 348,78 | 24,3 |
| A* | Moscow_1_256.map (256x256) | (0,0) | (240,240) | 7903 | 348,78 | 4,2 |
| Dijkstra | Milan_2_256.map | (0,0) | (240,240) | 48147 | 394,70 | 19 |
| A* | Milan_2_256.map | (0,0) | (240,240) | 57403 | 394,70 | 20,5 |
| Dijkstra | Sydney_0_512.map (512x512) | (0,0) | (500,500) | 206610 | 748,70 | 123,1 |
| A* | Sydney_0_512.map (512x512) | (0,0) | (500,500) | 127498 | 748,70 | 90,5 |
| Dijkstra | NewYork_1_512.map (512x512) | (0,0) | (500,500) | 197699 | 758,45 | 123,3 |
| A* | NewYork_1_512.map (512x512) | (0,0) | (500,500) | 147950 | 758,45 | 102,9 |

Tuloksien tulkintaa..

Testit voidaan toistaa antamalla algoritmeille syötteiksi samat kartat ja samat alku- ja loppusolmut.
