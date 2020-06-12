# Testaus

Testausta on tähän mennessä tehty JUnitin avulla automaattisin testein. Kaikille tähän mennessä toteutetuille luokille on laadittu testit:
- Algoritmit: luokan AStar testit löytyvät testiluokasta AStarTest ja luokan Dijkstra testit luokasta DijkstraTest
- Tietorakenteet: Keko-luokan testeistä vastaa testiluokka KekoTest ja Solmu-luokan testeistä SolmuTest
- Kartanlukija: Kartanlukija-luokkaa testaa KartanlukijaTest

Manuaalista testausta on tähän mennessä tehty vasta hyvin pienimuotoisesti, mutta algoritmit löytävät pituudeltaan samanpituisen reitin, joten voisi olettaa, että ne toimivat oikein. Main-luokasta löytyy manuaalisen testaamisen elementtejä, jotka mittaavat aikaa ja laskevat lyhimmän reitin molempien algoritmien osalta. Tällä hetkellä A*-algoritmi toimii huomattavasti nopeammin kuin Dijsktra.

Ensi viikolla tullaan jatkamaan Dijkstran ja A*-algoritmin suorituskykyä testausta .map-muotoisia karttoja syötteenä käyttäen.
Tarkoitus on testata suoritusaikoja ja reittien pituuksia, kun algoritmit saavat syötteenä saman kartan ja samat alku- ja loppusolmut. Testejä tullaan suorittamaan useampia eri kartoilla ja eri alku- ja loppusolmuilla.

Testit voidaan toistaa antamalla algoritmeille syötteiksi samat kartat ja samat alku- ja loppusolmut.

Tänne tullaan lisäämään myös empiirisen testauksen tulokset graafisessa muodossa.
