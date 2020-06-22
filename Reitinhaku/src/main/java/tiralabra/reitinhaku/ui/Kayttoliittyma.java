/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.reitinhaku.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import tiralabra.reitinhaku.algoritmit.AStar;
import tiralabra.reitinhaku.algoritmit.Dijkstra;
import tiralabra.reitinhaku.kartat.Kartanlukija;
import tiralabra.reitinhaku.logiikka.Logiikka;
import tiralabra.reitinhaku.tietorakenteet.Solmu;

/**
 *
 * @author saasini
 */
public class Kayttoliittyma extends Application {
    
    private Logiikka logiikka;

    @Override
    public void start(Stage window) throws FileNotFoundException, Exception {
        
        this.logiikka = new Logiikka();

        //karttanapit
        Button nappiKartta1 = new Button("Lontoo");
        Button nappiKartta2 = new Button("Milano");
        Button nappiKartta3 = new Button("Moskova");
        Button nappiKartta4 = new Button("New York");
        
        //napit
        Button menuNappi = new Button("Menu");
        Button vertailuNappi = new Button("Vertailu");
        
        //menunäkymä
        BorderPane menu = new BorderPane();
        menu.setTop(vertailuNappi);
        
        HBox karttaHBox = new HBox();
        karttaHBox.setSpacing(20);
        karttaHBox.getChildren().add(nappiKartta1);
        karttaHBox.getChildren().add(nappiKartta2);
        karttaHBox.getChildren().add(nappiKartta3);
        karttaHBox.getChildren().add(nappiKartta4);
        
        Label ohjeKartta = new Label("Valitse kartta ja klikkaa Vertailu");
        
        VBox valitseKartta = new VBox();
        valitseKartta.setSpacing(20);
        valitseKartta.getChildren().add(ohjeKartta);
        valitseKartta.getChildren().add(karttaHBox);
        
        menu.setBottom(valitseKartta);
        
        menu.setPrefSize(400, 200);
        BorderPane.setMargin(menu, new Insets(100, 10, 10, 10));
        
        //vertailunäkymä
        BorderPane asettelu = new BorderPane();
        Pane piirtoalusta = new Pane();
        Button dijkstraNappi = new Button("Dijsktra");
        Button JPSNappi = new Button("Jump Point Search");
        Button AStarNappi = new Button("A-Star");
        Button laskeReittiNappi = new Button("Hae reitti");
        
        Label ohjeAlgo = new Label("Valitse algoritmi ja klikkaa Hae reitti");
        Label reitinPituus = new Label("");
        Label kulunutAika = new Label("");
        
        VBox vertailunTulos = new VBox();
        vertailunTulos.getChildren().add(reitinPituus);
        vertailunTulos.getChildren().add(kulunutAika);

        HBox algoHBox = new HBox();
        algoHBox.setSpacing(20);
        algoHBox.getChildren().add(dijkstraNappi);
        algoHBox.getChildren().add(JPSNappi);
        algoHBox.getChildren().add(AStarNappi);
        asettelu.setCenter(piirtoalusta);
        asettelu.setTop(menuNappi);
        
        VBox valitseAlgo = new VBox();
        valitseAlgo.setSpacing(20);
        valitseAlgo.getChildren().add(ohjeAlgo);
        valitseAlgo.getChildren().add(algoHBox);
        valitseAlgo.getChildren().add(vertailunTulos);
        valitseAlgo.getChildren().add(laskeReittiNappi);
        
        asettelu.setBottom(valitseAlgo);
        
        asettelu.setPrefSize(1000, 1000);
        BorderPane.setMargin(valitseAlgo, new Insets(100, 10, 10, 10));
        
        //näkymät
        Scene menuNakyma = new Scene(menu);
        Scene vertailuNakyma = new Scene(asettelu);
        
        //napit set on action
        nappiKartta1.setOnAction((event) -> {
            try {
                this.logiikka.setValittuKartta("kartta1");
            } catch (Exception ex) {
            }
        });
        
        nappiKartta2.setOnAction((event) -> {
            try {
                this.logiikka.setValittuKartta("kartta2");
            } catch (Exception ex) {
            }
        });
        
        nappiKartta3.setOnAction((event) -> {
            try {
                this.logiikka.setValittuKartta("kartta3");
            } catch (Exception ex) {
            }
        });
        
        nappiKartta4.setOnAction((event) -> {
            try {
                this.logiikka.setValittuKartta("kartta4");
            } catch (Exception ex) {
            }
        });
        
        vertailuNappi.setOnAction((event) -> {
            try {
                tyhjennaPiirtoalusta(piirtoalusta);
                kulunutAika.setText("");
                reitinPituus.setText("");
                piirraKartta(this.logiikka.getValittuKartta(), piirtoalusta);
            } catch (Exception ex) {
            }
            window.setScene(vertailuNakyma);
        });

        menuNappi.setOnAction((event) -> {
            window.setScene(menuNakyma);
        });
        
        AStarNappi.setOnAction((event) -> {
            logiikka.setValittuAlgo("AStar");
        });
        
        dijkstraNappi.setOnAction((event) -> {
            logiikka.setValittuAlgo("Dijkstra");
        });
        
        laskeReittiNappi.setOnAction((event) -> {
            try {
                Solmu alku = new Solmu(5, 2);
                Solmu loppu = new Solmu(200, 200);
                if (logiikka.getValittuAlgo().equals("Dijkstra")) {
                    Dijkstra dijkstra = new Dijkstra(this.logiikka.getValittuKartta());
                    long aloitusAika = System.currentTimeMillis();
                    int lyhinReitti = dijkstra.laskeReitinPituus(alku, loppu);
                    long lopetusAika = System.currentTimeMillis();
                    piirraReitti(this.logiikka.getValittuKartta(), piirtoalusta, dijkstra.getReitti());
                    reitinPituus.setText("Lyhin reitti Dijkstran algoritmilla oli pituudeltaan " + lyhinReitti);
                    kulunutAika.setText("Suoritusaika Dijkstran algoritmille oli " + (lopetusAika - aloitusAika) + "ms.");
                } else if (logiikka.getValittuAlgo().equals("AStar")) {
                    AStar astar = new AStar(this.logiikka.getValittuKartta());
                    long aloitusAika2 = System.currentTimeMillis();
                    int lyhinReitti2 = astar.laskeReitti(alku, loppu);
                    long lopetusAika2 = System.currentTimeMillis();
                    piirraReitti(this.logiikka.getValittuKartta(), piirtoalusta, astar.getReitti());
                    reitinPituus.setText("Lyhin reitti A*-algoritmilla oli pituudeltaan " + lyhinReitti2);
                    kulunutAika.setText("Suoritusaika A*-algoritmille oli " + (lopetusAika2 - aloitusAika2) + "ms.");
                }
            } catch (Exception ex) {
            }
        });

        window.setScene(menuNakyma);
        window.show();

    }
    
    public void piirraKartta(char[][] kartta, Pane piirtoalusta) {
        for (int x = 0; x < kartta.length; x++) {
            for (int y = 0; y < kartta[0].length; y++) {
                if (kartta[x][y] == '@') {
                    Rectangle ruutu = new Rectangle(x * 3, y * 3 + 5, 3, 3);
                    ruutu.setFill(Color.BLACK);
                    piirtoalusta.getChildren().add(ruutu);
                }
            }
        }
    }
    
    public void piirraReitti(char[][] kartta, Pane piirtoalusta, boolean[][] reitti) {
        for (int x = 0; x < kartta.length; x++) {
            for (int y = 0; y < kartta[0].length; y++) {
                if (reitti[x][y] == true) {
                    Rectangle reittiRuutu = new Rectangle(x * 3, y * 3 + 5, 3, 3);
                    reittiRuutu.setFill(Color.RED);
                    piirtoalusta.getChildren().add(reittiRuutu);
                }
            }
        }
    }
    
    public void tyhjennaPiirtoalusta(Pane piirtoalusta) {
        piirtoalusta.getChildren().clear();
    }

    public static void main(String[] args) {
        launch(Kayttoliittyma.class);
    }
}
