import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * Created by agrigorj on 12/12/15.
 * Klass kirjeldab kasutajaliidest
 */
class GUI extends Main {
    int forUser1[][] = new int[][] //abimaatriks EASY tasemele ( 0 - number; 1- tühi lahter)
            {{1, 0, 0, 1, 0, 1, 0, 0, 0},
                    {1, 1, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 1, 0, 0, 0, 1, 0, 1},
                    {1, 0, 1, 0, 0, 1, 0, 0, 0},
                    {1, 0, 1, 0, 0, 1, 0, 0, 0},
                    {1, 0, 0, 0, 1, 0, 1, 0, 0},
                    {1, 0, 0, 0, 1, 0, 1, 0, 0},
                    {0, 0, 1, 0, 0, 0, 1, 0, 1},
                    {1, 1, 0, 0, 0, 0, 1, 0, 0}};
    int forUser2[][] = new int[][] //abimaatriks MEDIUM tasemele
            {{1, 0, 0, 1, 0, 1, 1, 1, 0},
                    {1, 1, 0, 1, 0, 0, 1, 0, 1},
                    {1, 1, 1, 0, 1, 0, 1, 0, 1},
                    {1, 0, 1, 0, 0, 1, 1, 1, 0},
                    {1, 0, 1, 1, 0, 1, 1, 0, 0},
                    {1, 0, 0, 0, 1, 1, 1, 1, 0},
                    {1, 0, 1, 0, 1, 1, 1, 0, 0},
                    {0, 0, 1, 1, 0, 0, 1, 1, 1},
                    {1, 1, 0, 0, 1, 0, 1, 0, 1}};
    int forUser3[][] = new int[][]//abimaatriks HARD tasemele
            {{1, 0, 1, 1, 0, 1, 1, 1, 0},
                    {1, 1, 0, 1, 0, 1, 1, 0, 1},
                    {1, 1, 1, 0, 1, 0, 1, 1, 1},
                    {1, 0, 1, 1, 0, 1, 1, 1, 0},
                    {1, 0, 1, 1, 0, 1, 1, 0, 1},
                    {1, 0, 1, 0, 1, 1, 1, 1, 0},
                    {1, 0, 1, 0, 1, 1, 1, 0, 1},
                    {1, 0, 1, 1, 0, 0, 1, 1, 1},
                    {1, 1, 1, 0, 1, 0, 1, 0, 1}};
    String logo[][] = new String[][] //abimaatriks logo kuvamiseks
            {{"", "W", "E", "L", "C", "O", "M", "E", ""},
                    {"", "", "", "T", "", "O", "", "", ""},
                    {"", "", "", "", "", "", "", "", ""},
                    {"", "S", "", "", "D", "", "", "U", ""},
                    {"", "", "U", "", "O", "", "K", "", ""},
                    {"", "", "", "", "", "", "", "", ""},
                    {"", "", "W", "", "", "", "D", "", ""},
                    {"", "", "", "O", "", "L", "", "", ""},
                    {"", "", "", "", "R", "", "", "", ""}};
    int lauaPikkus = 9;
    int ruuduServaPikkus = 50;

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
                + "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );"
                + "fx-border-color: black;"
                + "fx-border-radius: 5;"
                + "-fx-text-fill: black;");
        easy.setPrefSize(120.0, 20.0);
        easy.setTranslateY(200);
        easy.setTranslateX(-150.0);
        easy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                seadistaMang();
                genereeriGrid(newField.toSolve(forUser1));//genereerime maatriksi ja kuvame ekraanile
                time.startCount();//aeg hakkab käima 0-st
            }
        });
        Button medium = new Button("MEDIUM");
        medium.setStyle("-fx-font-size: 14px;"
                + "-fx-alignment: center;"
                + "-fx-font-weight: bold;"
                + "-fx-font-family: Arial Black;"
                + "-fx-background-color: #FFD12A; "
                + "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );"
                + "fx-border-color: black;"
                + "fx-border-radius: 5;"
                + "-fx-text-fill: black;");
        medium.setPrefSize(120.0, 20.0);
        medium.setTranslateY(200);
        medium.setTranslateX(0);
        medium.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                seadistaMang();
                genereeriGrid(newField.toSolve(forUser2));//genereerime maatriksi ja kuvame ekraanile
                time.startCount();//aeg hakkab käima 0-st
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
                seadistaMang();
                genereeriGrid(newField.toSolve(forUser3));//genereerime maatriksi ja kuvame ekraanile
                time.startCount();//aeg hakkab käima 0-st
            }
        });
        Label explain = new Label("Please choose difficulty level to start or press  F1 for help");
        explain.setStyle("-fx-font-size: 14px;"
                + "-fx-font-style: italic;"
                + "-fx-alignment: center;"
                + "-fx-text-fill: blue;");
        explain.setTranslateY(250);
        explain.setTranslateX(0);
        maailm.getChildren().addAll(laud, easy, medium, hard, explain);
        Scene manguStseen = new Scene(maailm, 500, 600);
        lava.setScene(manguStseen);
        lava.show(); // näita akent
        lava.setOnCloseRequest(event -> {
            System.exit(0);
        }); // akna sulgedes läheb programm kinni
    }

    public void logo() {
        //meetod logo kuvamiseks peaekraanile
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
                laud.add(text, j, i);
            }
        }

    }

    public void genereeriGrid(int[][] ar) {
        //meetod mänguvälja genereerimiseks
        for (int i = 0; i < lauaPikkus; i++) {
            for (int j = 0; j < lauaPikkus; j++) {
                Rectangle ruut = new Rectangle(ruuduServaPikkus, ruuduServaPikkus);
                ruut.setFill(Color.WHITE);
                ruut.setStroke(Color.GREY);
                laud.add(ruut, i, j);
                if (ar[i][j] > 0) {
                    //kui maatriksi väärtus on 0-st suurem, siis lisame Label ja kirjutame väärtust Label'ile
                    Label label = new Label(Integer.toString(ar[i][j]));
                    label.setTranslateX(20.0);
                    label.setStyle("-fx-font-size: 12px;"
                            + "-fx-font-style: italic;"
                            + "-fx-alignment: center;"
                            + "-fx-font-weight: bold;"
                            + "-fx-font-family: Arial Black;"
                            + "-fx-text-fill: green;");
                    laud.add(label, i, j);
                } else {
                    //kui maatriksi väärtus  on 0, siis lisame teksti välja
                    TextField input = new TextField();
                    input.setPrefSize(50.0, 50.0);
                    input.textProperty().addListener(
                            (observable, oldValue, newValue) -> {
                                if (newValue.length() > 1) input.setText(oldValue);
                            });
                    input.addEventFilter(KeyEvent.KEY_TYPED, numFilter()); //sisestada tohib ainult numbrid 1-st 9-ni
                    input.setStyle(""
                            + "-fx-font-size: 12px;"
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

    public static EventHandler<KeyEvent> numFilter() {
        //lahtrisse saab sisestada ainult numbrid 1-st 9-ni, kui kasutaja sisestab midagi muud, siis ei reageeri
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
        //mänguvälja ekraan
        maailm = new StackPane();
        laud = new GridPane();
        laud.setPadding(new Insets(10, 0, 10, 20));
        Line abi1 = new Line(150, 0, 150, 455);
        abi1.setTranslateX(-77.0);
        abi1.setTranslateY(-60.0);
        abi1.setStroke(Color.BLACK);
        abi1.setStrokeWidth(2);
        Line abi2 = new Line(150, 0, 150, 455);
        abi2.setTranslateX(76.5);
        abi2.setTranslateY(-60.0);
        abi2.setStroke(Color.BLACK);
        abi2.setStrokeWidth(2);
        Line abi3 = new Line(0, 0, 455, 0);
        abi3.setTranslateY(-136.0);
        abi3.setStroke(Color.BLACK);
        abi3.setStrokeWidth(2);
        Line abi4 = new Line(0, 0, 455, 0);
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
                yes.setTranslateY(3);
                yes.setTranslateX(-50);
                yes.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        peaekraan();//näitame peaekraani
                        logo();//Grid logoga peaekraanile
                        dialog.close();
                        time.stopCount();
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
                Text question = new Text("Are you sure you want exit the game?");
                question.setTranslateY(5);
                dialogVbox.getChildren().add(question);
                dialogVbox.getChildren().addAll(yes, no);
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
                yes.setTranslateY(3);
                yes.setTranslateX(-50);
                yes.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        seadistaMang();
                        genereeriGrid(newField.solved);//kuvame lahendatud maatriksit
                        dialog.close();//aken läheb kinni
                        time.stopCount();//aegg seisma
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
                Text question = new Text("Are you giving up?");
                question.setTranslateY(5);
                dialogVbox.getChildren().add(question);
                dialogVbox.getChildren().addAll(yes, no);
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
                checkout.kontrolli();//nupule vajutamisel käivitub kontroll

            }
        });
        Label showtime = new Label();//siia tuleb taimer
        showtime.setTranslateY(270);
        showtime.setTranslateX(170);
        final Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showtime.setText(time.getTime());//tekst kuvamiseks
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE); //skaneerime pidevalt ja kuvame muutused ekraanile
        timeline.play();
        maailm.getChildren().addAll(laud, back, lah, kontr, abi1, abi2, abi3, abi4, showtime);
        Scene manguStseen = new Scene(maailm, 500, 600);
        lava.setScene(manguStseen);
        lava.show(); // näita akent
        lava.setOnCloseRequest(event -> {
            System.exit(0);
        }); // akna sulgedes läheb programm kinni
    }


}

