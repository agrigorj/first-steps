
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * Created by agrigorj on 27/12/15.
 * Klass kirjeldab HELP akent
 */
class help extends Main {
    public void help() {
        final Stage dialog = new Stage();
        dialog.setResizable(false);
        dialog.setTitle("Sudoku game help");
        dialog.initOwner(lava);
        VBox root = new VBox();
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(browser);
        webEngine.loadContent("<tr>\n" +
                "<td>\n" +
                "<h2 ><font color=\"#000066\">What is Sudoku?</font></h2>\n" +
                "<p>Sudoku is a puzzle game designed for a single player, much like a crossword puzzle. The puzzle itself is nothing more than a grid of little boxes called “cells”. They are stacked nine high and nine wide, making 81 cells total.  The puzzle comes with some of the cells  already filled in.\n" +
                "<h2 ><font color=\"#000066\">How to play?</font></h2>\n" +
                "<p>The object of Sudoku is to fill the other empty cells with numbers between 1 and 9 (1 number only in each cell) according the following guidelines: <p>1. Number can appear only once on each row;<p>2. Number can appear only once on each column; <p> 3. Number can appear only once on each region. <p> A summary of these guidelines would be, that a number should appear only once on each row, column and a region. \n" +
                "<h3><font color=\"#FF0800\"> To learn more about Sudoku visit webpage http://www.learn-sudoku.com </font></h3> \n " +
                "</td>");
        root.getChildren().addAll(scrollPane);
        Scene dialogScene = new Scene(root, 810, 500);
        dialog.setScene(dialogScene);
        dialog.show();
    }
}
