# Testaus

Testausta on tähän mennessä tehty JUnitin avulla automaattisin testein. Kaikille tähän mennessä toteutetuille luokille on laadittu testit:
- Algoritmit: luokan AStar testit löytyvät testiluokasta AStarTest (ei vielä valmis) ja luokan Dijkstra testit luokasta DijkstraTest
- Tietorakenteet: Keko-luokan testeistä vastaa testiluokka KekoTest ja Solmu-luokan testeistä SolmuTest
- Kartanlukija: Kartanlukija-luokkaa testaa KartanlukijaTest

Manuaalista testausta on tähän mennessä tehty vasta hyvin pienimuotoisesti, koska A*-algoritmin toteutus ei ole vielä valmis. Algoritmeja ei ole tästä syystä ollut myöskään vielä mahdollista vertailla.
Main-luokkaan on kuitenkin laadittu valmiiksi manuaalisen testaamisen elementtejä, jotka mittaavat aikaa ja laskevat lyhyimmän reitin molempien algoritmien osalta. Dijkstran algoritmin osalta näitä elementtejä
on testailtu pienimuotoisesti.

Kun A*-algoritmi ensi viikolla valmistuu, tullaan Dijkstran ja A*-algoritmin suorituskykyä testaamaan .map-muotoisia karttoja syötteenä käyttäen.
Tarkoitus on testata suoritusaikoja ja reittien pituuksia, kun algoritmit saavat syötteenä saman kartan ja samat alku- ja loppusolmut. Testejä tullaan suorittamaan useampia eri kartoilla ja eri alku- ja loppusolmuilla.

Testit voidaan toistaa antamalla algoritmeille syötteiksi samat kartat ja samat alku- ja loppusolmut.

Tänne tullaan lisäämään myös empiirisen testauksen tulokset graafisessa muodossa.
