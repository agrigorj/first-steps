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
public class GUI extends Application {
    static int forUser [][]=new int [][]
            {{1,0,0,1,0,1,1,1,0},
                    {1,1,0,1,0,0,1,0,1},
                    {1,1,1,0,1,0,1,0,1},
                    {1,0,1,0,0,1,1,1,0},
                    {1,0,1,1,0,1,1,0,0},
                    {1,0,0,0,1,1,1,1,0},
                    {1,0,1,0,1,1,1,0,0},
                    {0,0,1,1,0,0,1,1,1},
                    {1,1,0,0,1,0,1,0,1}} ;
    static Genereerimine class1=new Genereerimine();
    static Kontrolli class2=new Kontrolli();
    static Stage lava;
    static StackPane maailm;
    static GridPane laud;
    int lauaPikkus = 9;
    int ruuduServaPikkus = 50;

    @Override
    public void start(Stage primaryStage) throws Exception {
        lava = primaryStage;
        lava.setResizable(false);
        lava.setTitle("Sudoku v 0.6 by Andrei Grigorjev");
        seadistaLava();
        genereeriGrid(class1.toSolve(forUser));
    }
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

    private void seadistaLava() {
        maailm = new StackPane();
        laud = new GridPane();
        laud.setPadding(new Insets(10,0,10,20));
        Line abi1=new Line (150,0,150,455);
        abi1.setTranslateX(-77.0);
        abi1.setTranslateY(-60.0);
        abi1.setStroke(Color.ORANGE);
        abi1.setStrokeWidth(2);
        Line abi2=new Line (150,0,150,455);
        abi2.setTranslateX(76.5);
        abi2.setTranslateY(-60.0);
        abi2.setStroke(Color.ORANGE);
        abi2.setStrokeWidth(2);
        Line abi3=new Line (0,0,455,0);
        abi3.setTranslateY(-136.0);
        abi3.setStroke(Color.ORANGE);
        abi3.setStrokeWidth(2);
        Line abi4=new Line (0,0,455,0);
        abi4.setTranslateY(17.0);
        abi4.setStroke(Color.ORANGE);
        abi4.setStrokeWidth(2);
        Button gen = new Button("Genereeri uus");
        gen.setPrefSize(120.0,20.0);
        gen.setTranslateY(220);
        gen.setTranslateX(-170.0);
        gen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                seadistaLava();
                genereeriGrid(class1.toSolve(forUser));
            }
        });
        Button lah = new Button("Näita lahendus");
        lah.setPrefSize(120.0, 20.0);
        lah.setTranslateY(220);
        lah.setTranslateX(170);
        lah.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                seadistaLava();
                genereeriGrid(class1.solved);
            }
        });
        Button kontr = new Button("Kontrolli!");
        kontr.setPrefSize(120.0, 20.0);
        kontr.setTranslateY(220);
        kontr.setTranslateX(0);
        kontr.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 class2.kontrolli();

            }
        });
        maailm.getChildren().addAll(laud,gen,lah,kontr,abi1,abi2,abi3,abi4);
        Scene manguStseen = new Scene(maailm, 500,600);
        lava.setScene(manguStseen);
        lava.show(); // näita akent
        lava.setOnCloseRequest(event -> {
            System.exit(0);
        }); // akna sulgedes läheb programm kinni
    }
    }

