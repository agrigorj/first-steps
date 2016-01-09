package Projekt;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by agrigorj on 25/12/15.
 * Klass m�ngija poolt t�idetud maatriksi kontrollimiseks.
 * P�him�te: kirjutame �les kasutaja pooltt lahendatud sudoku ja v�rdleme arvuti lahendusega.
 * Kui lahendus on �ige, siis proggramm �tleb kasutajale, et on korras; kui on vead, siis programm hoiatab, et lahendus ei ole
 * �ige ja n�itab punasega valed ruudud.
 */
class Kontrolli extends Main {
    static void kontrolli() {
        ArrayList kasutajalt = new ArrayList(); //siia kirjutame �les kasutaja maatriksi
        ArrayList programmilt = new ArrayList();//siia kopeerime programmi poolt lahendatud maatriksi
        for (Node node : Main.laud.getChildren()) { //skaneerime k�ik laua lahtrid
            if (node instanceof TextField) {
                kasutajalt.add(((TextField) node).getText().trim());
            } else if (node instanceof Label) {
                kasutajalt.add(((Label) node).getText().trim());
            }
        }
        System.out.println(kasutajalt); //vihjed konsooli
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                programmilt.add(Integer.toString(Main.newField.solved[i][j]));
            }
        }
        System.out.println(programmilt);//vihjed konsooli
        for (int i = 0; i < 81; i++) {
            if (programmilt.get(i).equals(kasutajalt.get(i))) {
                Main.laud.getChildren().get((i + 1) * 2 - 1).setStyle("-fx-font-size: 12px;"
                        + "-fx-alignment: center;"
                        + "-fx-font-weight: bold;"
                        + "-fx-font-family: Arial Black;"
                        + "-fx-text-fill: GREEN;");
            } else if (kasutajalt.get(i).equals("")) {
                Main.laud.getChildren().get((i + 1) * 2 - 1).setStyle("-fx-font-size: 12px;"
                        + "-fx-font-style: italic;"
                        + "-fx-alignment: center;"
                        + "-fx-font-weight: bold;"
                        + "-fx-font-family: Arial Black;"
                        + "-fx-text-fill: blue;"
                        + "-fx-background-color: #F5F5DC; "
                        + "-fx-border-color:grey;");

            } else {
                Main.laud.getChildren().get((i + 1) * 2 - 1).setStyle("-fx-font-size: 12px;"
                        + "-fx-font-style: italic;"
                        + "-fx-alignment: center;"
                        + "-fx-font-weight: bold;"
                        + "-fx-font-family: Arial Black;"
                        + "-fx-text-fill: red;"
                        + "-fx-background-color: #F5F5DC; "
                        + "-fx-border-color:red;");
            }
        }
        if (kasutajalt.equals(programmilt)) {
            Main.time.stopCount();
            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.setResizable(false);
            dialog.initOwner(Main.lava);
            VBox dialogVbox = new VBox(20);
            Button ok = new Button("OK!");
            ok.setPrefSize(60, 30);
            ok.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    dialog.close();
                }
            });
            dialogVbox.getChildren().add(new Text("Alright! You've done it! " + '\n' + '\n' + " Your time is " + Main.time.getTime()));
            dialogVbox.getChildren().addAll(ok);
            dialogVbox.setStyle("-fx-font-size: 12px;"
                    + "-fx-font-style: italic;"
                    + "-fx-alignment: center;"
                    + "-fx-font-weight: bold;"
                    + "-fx-font-family: Arial Black;"
                    + "-fx-text-fill: black;");
            Scene dialogScene = new Scene(dialogVbox, 420, 150);
            dialog.setScene(dialogScene);
            dialog.show();
        } else {
            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.setResizable(false);
            dialog.initOwner(Main.lava);
            VBox dialogVbox = new VBox(20);
            Button ok = new Button("OK!");
            ok.setPrefSize(60, 30);
            ok.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    dialog.close();

                }
            });
            dialogVbox.getChildren().add(new Text("Oops! Something went wrong. Please check your solution!"));
            dialogVbox.getChildren().addAll(ok);
            dialogVbox.setStyle("-fx-font-size: 12px;"
                    + "-fx-font-style: italic;"
                    + "-fx-alignment: center;"
                    + "-fx-font-weight: bold;"
                    + "-fx-font-family: Arial Black;"
                    + "-fx-text-fill: black;");
            Scene dialogScene = new Scene(dialogVbox, 420, 150);
            dialog.setScene(dialogScene);
            dialog.show();
        }
    }
}
