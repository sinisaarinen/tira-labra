/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.reitinhaku.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tiralabra.reitinhaku.algoritmit.AStar;
import tiralabra.reitinhaku.algoritmit.Dijkstra;

/**
 *
 * @author saasini
 */
public class Kayttoliittyma extends Application {

    @Override
    public void start(Stage window) {
        
        //napit
        Button menuNappi = new Button("Menu");
        Button vertailuNappi = new Button("Vertailu");
        
        //menunäkymä
        BorderPane menu = new BorderPane();
        menu.setTop(vertailuNappi);
        
        //vertailunäkymä
        BorderPane asettelu = new BorderPane();
        Canvas piirtoalusta = new Canvas(640, 480);
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
        });

        menuNappi.setOnAction((event) -> {
            window.setScene(menuNakyma);
        });

        window.setScene(menuNakyma);
        window.show();

    }

    //Käytä ihan perus Canvas, jolle fillRectilla värillinen ruudukko kuvaamaan estettä, väylää, alkupistettä, 
    //loppupistettä ja reittiä, 2x2 pikselin ruutuja ehkä. Ohja-kurssilla olet varmaan piirrellyt JavaFX:llä.
    public static void main(String[] args) {
        launch(Kayttoliittyma.class);
    }
}
