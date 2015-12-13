import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.concurrent.SynchronousQueue;


/**
 * Created by agrigorj on 12/12/15.
 */
public class GUI extends Application {
    static int empty[][]=new int[9][9];
    static int filled[][]=new int[9][9];
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
    Genereerimine class1=new Genereerimine();
    Stage lava;
    StackPane maailm;
    GridPane laud;
    int lauaPikkus = 9;
    int laevaServaPikkus = 50;

    @Override
    public void start(Stage primaryStage) throws Exception {
        lava = primaryStage;
        lava.setTitle("Sudoku v 0.1 by Andrei Grigorjev");
        seadistaLava();
        genereeriGrid();
    }

    private void genereeriGrid() {
        int content [][]=new int[9][9];
        System.arraycopy(class1.toSolve(forUser),0,content,0,(content.length));
        for (int i = 0; i < lauaPikkus; i++) {
            for (int j = 0; j < lauaPikkus; j++) {
                Rectangle ruut = new Rectangle(laevaServaPikkus, laevaServaPikkus);
                ruut.setFill(Color.WHITE);
                ruut.setStroke(Color.BLACK);
                laud.add(ruut, i, j);
                for (int k = 0; k <9 ; k++) {
                    if(content[i][j]>0){
                        Label label= new Label(Integer.toString(content[i][j]));
                        label.setTranslateX(20.0);
                laud.add(label,i,j);
                    } else{
                        TextField input=new TextField();
                        input.setPrefSize(50.0,50.0);
                        input.setStyle(""
                        +  "-fx-font-size: 12px;"
                                + "-fx-font-style: italic;"
                                + "-fx-alignment: center;"
                                + "-fx-font-weight: bold;"
                                + "-fx-font-family: Arial Black;"
                                + "-fx-text-fill: blue;"
                                + "-fx-background-color: #F5F5DC; "
                                + "-fx-border-color:black;");
                        laud.add(input, i, j);
                    }
            }

            }
        }

    }


    private void seadistaLava() {
        maailm = new StackPane();
        laud = new GridPane();
        laud.setPadding(new Insets(10,0,10,20));
        Button gen = new Button("Genereeri uus");
        gen.setPrefSize(150.0,20.0);
        gen.setTranslateY(220);
        gen.setTranslateX(-150.0);
        gen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                genereeriGrid();
            }
        });


        maailm.getChildren().addAll(laud,gen);

        Scene manguStseen = new Scene(maailm, 500,600);
        lava.setScene(manguStseen);
        lava.show(); // näita akent
        lava.setOnCloseRequest(event -> { System.exit(0); }); // akna sulgedes läheb programm kinni
    }
    }

