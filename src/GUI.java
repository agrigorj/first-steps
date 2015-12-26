import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;


/**
 * Created by agrigorj on 12/12/15.
 */
public class GUI extends Main {
    public void genereeriGrid(int[][] ar) {
        for (int i = 0; i < lauaPikkus; i++) {
            for (int j = 0; j < lauaPikkus; j++) {
                Rectangle ruut = new Rectangle(ruuduServaPikkus, ruuduServaPikkus);
                ruut.setFill(Color.WHITE);
                ruut.setStroke(Color.GREY);
                laud.add(ruut, i, j);
                    if(ar[i][j]>0){
                        Label label= new Label(Integer.toString(ar[i][j]));
                        label.setTranslateX(20.0);
                        label.setStyle("-fx-font-size: 12px;"
                                + "-fx-font-style: italic;"
                                + "-fx-alignment: center;"
                                + "-fx-font-weight: bold;"
                                + "-fx-font-family: Arial Black;"
                                + "-fx-text-fill: green;");
                laud.add(label,i,j);
                    } else{
                        TextField input=new TextField();
                        input.setPrefSize(50.0,50.0);
                        input.textProperty().addListener(
                                (observable, oldValue, newValue)->{
                                    if (newValue.length()>1) input.setText(oldValue);
                                });
                        input.addEventFilter(KeyEvent.KEY_TYPED,numFilter());
                        input.setStyle(""
                        +  "-fx-font-size: 12px;"
                                + "-fx-font-style: italic;"
                                + "-fx-alignment: center;"
                                + "-fx-font-weight: bold;"
                                + "-fx-font-family: Arial Black;"
                                + "-fx-text-fill: blue;"
                                + "-fx-background-color: #F5F5DC; "
                                + "-fx-border-color:grey;");
                        laud.add(input, i, j);
            }

            }
        }

    }
    public static EventHandler<KeyEvent>  numFilter() {
        EventHandler<KeyEvent> aux = new EventHandler<KeyEvent>() {
            public void handle(KeyEvent keyEvent) {
                if (!"123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        };
        return aux;

    }

    public void seadistaMang() {
        maailm = new StackPane();
        laud = new GridPane();
        laud.setPadding(new Insets(10,0,10,20));
        Line abi1=new Line (150,0,150,455);
        abi1.setTranslateX(-77.0);
        abi1.setTranslateY(-60.0);
        abi1.setStroke(Color.BLACK);
        abi1.setStrokeWidth(2);
        Line abi2=new Line (150,0,150,455);
        abi2.setTranslateX(76.5);
        abi2.setTranslateY(-60.0);
        abi2.setStroke(Color.BLACK);
        abi2.setStrokeWidth(2);
        Line abi3=new Line (0,0,455,0);
        abi3.setTranslateY(-136.0);
        abi3.setStroke(Color.BLACK);
        abi3.setStrokeWidth(2);
        Line abi4=new Line (0,0,455,0);
        abi4.setTranslateY(17.0);
        abi4.setStroke(Color.BLACK);
        abi4.setStrokeWidth(2);
        Button back = new Button("Main screen");
        back.setStyle("-fx-font-size: 12px;"
                + "-fx-font-style: italic;"
                + "-fx-alignment: center;"
                + "-fx-font-weight: bold;"
                + "-fx-font-family: Arial Black;"
                + "-fx-background-color: #FBCEB1; "
                + "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );"
                + "fx-border-color: black;"
                + "fx-border-radius: 5;"
                + "-fx-text-fill: black;");
        back.setPrefSize(120.0, 20.0);
        back.setTranslateY(220);
        back.setTranslateX(-170.0);
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                dialog.setResizable(false);
                dialog.initOwner(lava);
                VBox dialogVbox = new VBox(20);
                Button yes = new Button("Yes");
                yes.setPrefSize(60, 30);
                yes.setTranslateY(-2);
                yes.setTranslateX(-50);
                yes.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        peaekraan();
                        logo();
                        dialog.close();
                    }
                });
                Button no = new Button("NO");
                no.setTranslateY(-45);
                no.setTranslateX(50);
                no.setPrefSize(60, 30);
                no.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        dialog.close();
                    }
                });
                dialogVbox.getChildren().add(new Text("Are you sure you want exit the game?"));
                dialogVbox.getChildren().addAll(yes,no);
                dialogVbox.setStyle("-fx-font-size: 12px;"
                        + "-fx-font-style: italic;"
                        + "-fx-alignment: center;"
                        + "-fx-font-weight: bold;"
                        + "-fx-font-family: Arial Black;"
                        + "-fx-text-fill: black;");
                Scene dialogScene = new Scene(dialogVbox, 300, 100);
                dialog.setScene(dialogScene);
                dialog.show();

            }
        });
        Button lah = new Button("Show solution");
        lah.setStyle("-fx-font-size: 12px;"
                + "-fx-font-style: italic;"
                + "-fx-alignment: center;"
                + "-fx-font-weight: bold;"
                + "-fx-font-family: Arial Black;"
                + "-fx-background-color: #FBCEB1; "
                + "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );"
                + "fx-border-color: black;"
                + "fx-border-radius: 5;"
                + "-fx-text-fill: black;");
        lah.setPrefSize(120.0, 20.0);
        lah.setTranslateY(220);
        lah.setTranslateX(170);
        lah.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                dialog.setResizable(false);
                dialog.initOwner(lava);
                VBox dialogVbox = new VBox(20);
                Button yes = new Button("Yes");
                yes.setPrefSize(60, 30);
                yes.setTranslateY(-2);
                yes.setTranslateX(-50);
                yes.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        seadistaMang();
                        genereeriGrid(class1.solved);
                        dialog.close();
                    }
                });
                Button no = new Button("NO");
                no.setTranslateY(-45);
                no.setTranslateX(50);
                no.setPrefSize(60, 30);
                no.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        dialog.close();
                    }
                });
                dialogVbox.getChildren().add(new Text("Are you giving up?"));
                dialogVbox.getChildren().addAll(yes,no);
                dialogVbox.setStyle("-fx-font-size: 12px;"
                        + "-fx-font-style: italic;"
                        + "-fx-alignment: center;"
                        + "-fx-font-weight: bold;"
                        + "-fx-font-family: Arial Black;"
                        + "-fx-text-fill: black;");
                Scene dialogScene = new Scene(dialogVbox, 300, 100);
                dialog.setScene(dialogScene);
                dialog.show();

            }
        });

        Button kontr = new Button("Check out");
        kontr.setStyle("-fx-font-size: 12px;"
                + "-fx-font-style: italic;"
                + "-fx-alignment: center;"
                + "-fx-font-weight: bold;"
                + "-fx-font-family: Arial Black;"
                + "-fx-background-color: #FBCEB1; "
                + "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );"
                + "fx-border-color: black;"
                + "fx-border-radius: 5;"
                + "-fx-text-fill: black;");
        kontr.setPrefSize(120.0, 20.0);
        kontr.setTranslateY(220);
        kontr.setTranslateX(0);
        kontr.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 class2.kontrolli();

            }
        });
        maailm.getChildren().addAll(laud,back,lah,kontr,abi1,abi2,abi3,abi4);
        Scene manguStseen = new Scene(maailm, 500,600);
        lava.setScene(manguStseen);
        lava.show(); // näita akent
        lava.setOnCloseRequest(event -> {
            System.exit(0);
        }); // akna sulgedes läheb programm kinni
    }
    }

