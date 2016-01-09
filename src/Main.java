import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by agrigorj on 26/12/15.
 * Sellest klassist käivitub programm
 */
public class Main extends Application {
    //deklareerime objektid
    static Genereerimine newField = new Genereerimine();
    static Kontrolli checkout = new Kontrolli();
    static GUI gameScreen = new GUI();
    static help howToPlay = new help();
    static ElapsedT time = new ElapsedT();
    static Stage lava;
    static StackPane maailm;
    static GridPane laud;

    @Override
    public void start(Stage primaryStage) throws Exception {
        lava = primaryStage;
        lava.setResizable(false);
        lava.setTitle("Sudoku v 1.0 by Andrei Grigorjev");
        gameScreen.peaekraan();//käivitame peaakent
        gameScreen.logo();//peakna sisu

        lava.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            //F1 klahvi vajutamisel näitame akent mängu reeglitega
            if (event.getCode().equals(KeyCode.F1)) {
                System.out.println("F1 pressed");
                howToPlay.help();

            }
        });
    }


}


