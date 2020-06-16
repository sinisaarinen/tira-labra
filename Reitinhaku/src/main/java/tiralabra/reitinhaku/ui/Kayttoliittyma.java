/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.reitinhaku.ui;

import java.io.File;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import tiralabra.reitinhaku.algoritmit.AStar;
import tiralabra.reitinhaku.algoritmit.Dijkstra;
import tiralabra.reitinhaku.kartat.Kartanlukija;

/**
 *
 * @author saasini
 */
public class Kayttoliittyma extends Application {

    @Override
    public void start(Stage window) throws FileNotFoundException, Exception {
        
        //karttajutut
        File kartta = new File("./kartat/London_2_256.map");
        Kartanlukija kartanlukija = new Kartanlukija(kartta);
        char[][] valittuKartta = kartanlukija.muutaMatriisiksi();
        
        //napit
        Button menuNappi = new Button("Menu");
        Button vertailuNappi = new Button("Vertailu");
        
        //menunäkymä
        BorderPane menu = new BorderPane();
        menu.setTop(vertailuNappi);
        
        //vertailunäkymä
        BorderPane asettelu = new BorderPane();
        Pane piirtoalusta = new Pane();
        Button dijkstraNappi = new Button("Dijsktra");
        Button JPSNappi = new Button("Jump Point Search");
        Button AStarNappi = new Button("A-Star");
        Button laskeReittiNappi = new Button("Hae reitti");
        
        Label ohje = new Label("Valitse algoritmi");

        HBox algoHBox = new HBox();
        algoHBox.setSpacing(20);
        algoHBox.getChildren().add(dijkstraNappi);
        algoHBox.getChildren().add(JPSNappi);
        algoHBox.getChildren().add(AStarNappi);
        asettelu.setCenter(piirtoalusta);
        asettelu.setTop(menuNappi);
        
        VBox valitseAlgo = new VBox();
        valitseAlgo.setSpacing(20);
        valitseAlgo.getChildren().add(ohje);
        valitseAlgo.getChildren().add(algoHBox);
        valitseAlgo.getChildren().add(laskeReittiNappi);
        
        asettelu.setBottom(valitseAlgo);
        
        asettelu.setPrefSize(1000, 1000);
        BorderPane.setMargin(valitseAlgo, new Insets(100, 10, 10, 10));
        
        //näkymät
        Scene menuNakyma = new Scene(menu);
        Scene vertailuNakyma = new Scene(asettelu);
        
        //napit set on action
        vertailuNappi.setOnAction((event) -> {
            window.setScene(vertailuNakyma);
            piirraKartta(valittuKartta, piirtoalusta);
        });

        menuNappi.setOnAction((event) -> {
            window.setScene(menuNakyma);
        });

        window.setScene(menuNakyma);
        window.show();

    }
    
    public void piirraKartta(char[][] kartta, Pane piirtoalusta) {
        for (int x = 0; x < kartta.length; x++) {
            for (int y = 0; y < kartta[0].length; y++) {
                if (kartta[x][y] == '@') {
                    piirtoalusta.getChildren().add(new Rectangle(x * 3, y * 3 + 5, 3, 3));
                }
            }
        }
    }

    //Käytä ihan perus Canvas, jolle fillRectilla värillinen ruudukko kuvaamaan estettä, väylää, alkupistettä, 
    //loppupistettä ja reittiä, 2x2 pikselin ruutuja ehkä. Ohja-kurssilla olet varmaan piirrellyt JavaFX:llä.
    public static void main(String[] args) {
        launch(Kayttoliittyma.class);
    }
}
