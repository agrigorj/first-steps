import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Created by agrigorj on 26/12/15.
 */
public class Main extends Application {
    static int forUser1[][] = new int[][]
            {{1, 0, 0, 1, 0, 1, 0, 0, 0},
                    {1, 1, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 1, 0, 0, 0, 1, 0, 1},
                    {1, 0, 1, 0, 0, 1, 0, 0, 0},
                    {1, 0, 1, 0, 0, 1, 0, 0, 0},
                    {1, 0, 0, 0, 1, 0, 1, 0, 0},
                    {1, 0, 0, 0, 1, 0, 1, 0, 0},
                    {0, 0, 1, 0, 0, 0, 1, 0, 1},
                    {1, 1, 0, 0, 0, 0, 1, 0, 0}};
    static int forUser2[][] = new int[][]
            {{1, 0, 0, 1, 0, 1, 1, 1, 0},
                    {1, 1, 0, 1, 0, 0, 1, 0, 1},
                    {1, 1, 1, 0, 1, 0, 1, 0, 1},
                    {1, 0, 1, 0, 0, 1, 1, 1, 0},
                    {1, 0, 1, 1, 0, 1, 1, 0, 0},
                    {1, 0, 0, 0, 1, 1, 1, 1, 0},
                    {1, 0, 1, 0, 1, 1, 1, 0, 0},
                    {0, 0, 1, 1, 0, 0, 1, 1, 1},
                    {1, 1, 0, 0, 1, 0, 1, 0, 1}};
    static int forUser3[][] = new int[][]
            {{1, 0, 1, 1, 0, 1, 1, 1, 0},
                    {1, 1, 0, 1, 0, 1, 1, 0, 1},
                    {1, 1, 1, 0, 1, 0, 1, 1, 1},
                    {1, 0, 1, 1, 0, 1, 1, 1, 0},
                    {1, 0, 1, 1, 0, 1, 1, 0, 1},
                    {1, 0, 1, 0, 1, 1, 1, 1, 0},
                    {1, 0, 1, 0, 1, 1, 1, 0, 1},
                    {1, 0, 1, 1, 0, 0, 1, 1, 1},
                    {1, 1, 1, 0, 1, 0, 1, 0, 1}};
    String logo[][] = new String[][]
                   {{"", "W", "E", "L", "C", "O", "M", "E", ""},
                           {"", "", "", "T", "", "O", "", "", ""},
                           {"", "", "", "", "", "", "", "", ""},
                           {"", "S", "", "", "D", "", "K", "", ""},
                           {"", "", "U", "", "O", "", "", "U", ""},
                           {"", "", "", "", "", "", "", "", ""},
                           {"", "", "W", "", "", "", "D", "", ""},
                           {"", "", "", "O", "", "L", "", "", ""},
                           {"", "", "", "", "R", "", "", "", ""}};
    static Genereerimine class1 = new Genereerimine();
    static Kontrolli class2 = new Kontrolli();
    static GUI class3 = new GUI();
    static ElapsedT class5=new ElapsedT();
    static help class4=new help();
    static Stage lava;
    static StackPane maailm;
    static GridPane laud;
    int lauaPikkus = 9;
    int ruuduServaPikkus = 50;

    @Override
    public void start(Stage primaryStage) throws Exception {
        lava = primaryStage;
        lava.setResizable(false);
        lava.setTitle("Sudoku v 1.0 by Andrei Grigorjev");
        peaekraan();
        logo();
        lava.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode().equals(KeyCode.F1)) {
                System.out.println("F1 pressed");
                class4.help();

            }
        });
    }

    public void peaekraan() {
        maailm = new StackPane();
        laud = new GridPane();
        laud.setPadding(new Insets(10, 0, 10, 20));

        Button easy = new Button("EASY");
        easy.setStyle("-fx-font-size: 14px;"
                + "-fx-alignment: center;"
                + "-fx-font-weight: bold;"
                + "-fx-font-family: Arial Black;"
                + "-fx-background-color: #66FF00; "
                +  "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );"
                +"fx-border-color: black;"
                +"fx-border-radius: 5;"
                + "-fx-text-fill: black;");
        easy.setPrefSize(120.0, 20.0);
        easy.setTranslateY(200);
        easy.setTranslateX(-150.0);
        easy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                class3.seadistaMang();
                class3.genereeriGrid(class1.toSolve(forUser1));
                class5.startCount();

            }
        });
        Button medium = new Button("MEDIUM");
        medium.setStyle("-fx-font-size: 14px;"
                + "-fx-alignment: center;"
                + "-fx-font-weight: bold;"
                + "-fx-font-family: Arial Black;"
                + "-fx-background-color: #FFD12A; "
                +  "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );"
                +"fx-border-color: black;"
                +"fx-border-radius: 5;"
                + "-fx-text-fill: black;");

        medium.setPrefSize(120.0, 20.0);
        medium.setTranslateY(200);
        medium.setTranslateX(0);
        medium.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                class3.seadistaMang();
                class3.genereeriGrid(class1.toSolve(forUser2));
                class5.startCount();

            }
        });
        Button hard = new Button("HARD");
        hard.setStyle("-fx-font-size: 14px;"
                + "-fx-alignment: center;"
                + "-fx-font-weight: bold;"
                + "-fx-font-family: Arial Black;"
                + "-fx-background-color: #8E4585; "
                + "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );"
                + "fx-border-color: black;"
                + "fx-border-radius: 5;"
                + "-fx-text-fill: black;");
        hard.setPrefSize(120.0, 20.0);
        hard.setTranslateY(200);
        hard.setTranslateX(150);
        hard.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                class3.seadistaMang();
                class3.genereeriGrid(class1.toSolve(forUser3));
                class5.startCount();
            }
        });
        Label explain =new Label("Please choose difficulty level to start or press  F1 for help");
        explain.setStyle("-fx-font-size: 14px;"
                + "-fx-font-style: italic;"
                + "-fx-alignment: center;"
                + "-fx-text-fill: blue;");
        explain.setTranslateY(250);
        explain.setTranslateX(0);
        maailm.getChildren().addAll(laud, easy, medium, hard,explain);
        Scene manguStseen = new Scene(maailm, 500, 600);
        lava.setScene(manguStseen);
        lava.show(); // näita akent
        lava.setOnCloseRequest(event -> {
            System.exit(0);
        }); // akna sulgedes läheb programm kinni
    }

    public void logo() {
        for (int i = 0; i < lauaPikkus; i++) {
            for (int j = 0; j < lauaPikkus; j++) {
                Rectangle ruut = new Rectangle(ruuduServaPikkus, ruuduServaPikkus);
                ruut.setFill(Color.WHITE);
                ruut.setStroke(Color.GREY);
                laud.add(ruut, i, j);

            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
        Label text = new Label(logo[i][j]);
        text.setTranslateX(20.0);
        text.setStyle("-fx-font-size: 20px;"
                + "-fx-alignment: center;"
                + "-fx-font-weight: bold;"
                + "-fx-font-family: Arial Black;"
                + "-fx-text-fill: blue;");
        laud.add(text,j,i);
            }
        }

    }
}


