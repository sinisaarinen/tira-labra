# Reitinhakusovellus

Tämä sovellus tullaan toteuttamaan osana Helsingin yliopiston alkukesän 2020 Tietorakenteiden ja algoritmien harjoitustyökurssia. Harjoitustyön aihe on reitinhaku ja se toteutetaan Java-ohjelmointikielellä.

## Dokumentaatio

[Määrittelydokumentti](dokumentaatio/vaatimusmaarittely.md)

## Viikkoraportit

[Viikko 1](dokumentaatio/viikkoraportit/viikko1.md)

[Viikko 2](dokumentaatio/viikkoraportit/viikko2.md)

## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla 

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn test jacoco:report
```
Kattavuusraporttia voi tarkastella avaamalla selaimella tiedoston _target/site/jacoco/index.html_

### JavaDoc

JavaDoc luodaan komennolla
```
mvn javadoc:javadoc
```
JavaDocia voi tarkastella avaamalla selaimella tiedoston _target/site/apidocs/index.html_


### Checkstyle

Tiedoston [checkstyle.xml](Reitinhaku/Reitinhaku/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla
```
mvn jxr:jxr checkstyle:checkstyle
```
Virheilmoituksia voi tarkastella avaamalla selaimella tiedoston _target/site/checkstyle.html_
