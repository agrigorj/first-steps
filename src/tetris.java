import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agrigorj on 14/11/15.
 */
public class tetris extends Application {
    Stage lava;
    StackPane maailm;
    Pane laud;
    Pane pane;

    @Override
    public void start(Stage primaryStage) throws Exception {
        lava = primaryStage;
        seadistaLava();
        Shape1();
        liiguta();
        Input();
    }

    public void liiguta() {
        for (int i = 1; i < 20;i++) {
           TranslateTransition translateTransitionDown = new TranslateTransition();
            translateTransitionDown.setDuration(Duration.seconds(10));
            translateTransitionDown.setNode(laud);
            translateTransitionDown.setFromY(laud.getTranslateY());
            translateTransitionDown.setToY(laud.getTranslateY() + i*50);
            PauseTransition pauseTransition =
                    new PauseTransition(Duration.millis(200));
            SequentialTransition sequentialTransition2 =
                   new SequentialTransition (
                           pauseTransition,
                           translateTransitionDown

                            );
            sequentialTransition2.play();
        }


    }


    public static void main(String[] args) {
        launch(args);

        //createScene

    }

    public void seadistaLava() {
        maailm = new StackPane();
        laud = new Pane();
        laud.setPrefSize(20,20);
        maailm.getChildren().add(laud);
        Scene manguStseen = new Scene(maailm, 800, 1000);
        lava.setScene(manguStseen);
        lava.show(); // näita akent
        lava.setOnCloseRequest(event -> {
            System.exit(0);
        });
    }

    public void Shape1() {
        Rectangle ruut=new Rectangle(20,20);
        ruut.setFill(Color.BLUE);
        ruut.setStroke(Color.BLACK);
        laud.getChildren().add(ruut);

    }

    public void Input(){
        lava.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if (key.getCode() == KeyCode.RIGHT) {
                System.out.println("Move Right");
                TranslateTransition translateTransitionRight = new TranslateTransition();
                translateTransitionRight.setDuration(Duration.millis(20));
                translateTransitionRight.setNode(laud);
                translateTransitionRight.setFromX(laud.getTranslateX());
                translateTransitionRight.setToX(laud.getTranslateX()+20);
                translateTransitionRight.play();

            }
            if (key.getCode() == KeyCode.LEFT) {
                System.out.println("Move Left");
                TranslateTransition translateTransitionLeft = new TranslateTransition();
                translateTransitionLeft.setDuration(Duration.millis(20));
                translateTransitionLeft.setNode(laud);
                translateTransitionLeft.setFromX(laud.getTranslateX());
                translateTransitionLeft.setToX(laud.getTranslateX() - 20);
                translateTransitionLeft.play();
            }
            if (key.getCode() == KeyCode.DOWN) {
                System.out.println("Move Down");
                TranslateTransition translateTransitionDown = new TranslateTransition();
                translateTransitionDown.setDuration(Duration.millis(20));
                translateTransitionDown.setNode(laud);
                translateTransitionDown.setFromY(laud.getTranslateY());
                translateTransitionDown.setToY(laud.getTranslateY() + 20);
                translateTransitionDown.play();
            }
        });
    }










}