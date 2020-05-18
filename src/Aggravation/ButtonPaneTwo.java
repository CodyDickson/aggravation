package Aggravation;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ButtonPaneTwo
{
    public static void buttonPaneTwo(GridPane paneTwo, Button[] buttonMain, Button[] buttonOrange, Button[] buttonMagenta)
    {
        /******** Attaching bottom half of gridpane ********/
        paneTwo.add(buttonMain[22], 9, 67);
        paneTwo.add(buttonMain[23], 9, 69);
        paneTwo.add(buttonMain[24], 9, 71);
        paneTwo.add(buttonMain[25], 9, 73);
        paneTwo.add(buttonMain[26], 9, 75);
        paneTwo.add(buttonMain[27], 7, 75);
        paneTwo.add(buttonMain[28], 5, 75);
        paneTwo.add(buttonMain[29], 3, 75);
        paneTwo.add(buttonMain[30], 1, 75);
        paneTwo.add(buttonMain[31], 1, 73);
        paneTwo.add(buttonMain[32], 1, 71);
        paneTwo.add(buttonMain[33], 1, 69);
        paneTwo.add(buttonMain[34], 1, 67);

        paneTwo.add(buttonMain[64], 1, 9);
        paneTwo.add(buttonMain[65], 1, 7);
        paneTwo.add(buttonMain[66], 1, 5);
        paneTwo.add(buttonMain[67], 1, 3);
        paneTwo.add(buttonMain[68], 1, 1);
        paneTwo.add(buttonMain[69], 3, 1);
        paneTwo.add(buttonMain[70], 5, 1);
        paneTwo.add(buttonMain[71], 7, 1);
        paneTwo.add(buttonMain[72], 9, 1);
        paneTwo.add(buttonMain[73], 9, 3);
        paneTwo.add(buttonMain[74], 9, 5);
        paneTwo.add(buttonMain[75], 9, 7);
        paneTwo.add(buttonMain[76], 9, 9);

        /*** Bottom Home Base Buttons (ORANGE) ***/
        for (int i = 0; i < 4; i++) {
            buttonOrange[i] = new Button();
            buttonOrange[i].setStyle(
                    "-fx-background-radius: 5em; " +
                            "-fx-min-width: 30px; " +
                            "-fx-min-height: 30px; " +
                            "-fx-max-width: 30px; " +
                            "-fx-max-height: 30px;"
            );
        }

        /*** Attach Home Base Buttons (ORANGE) ***/
        for (int i = 0, j = 3; i < 4; i++, j += 2) {
            paneTwo.add(buttonOrange[i], 5, j);
        }

        /*** Bottom Home Base Buttons (MAGENTA) ***/
        for (int i = 0; i < 4; i++) {
            buttonMagenta[i] = new Button();
            buttonMagenta[i].setStyle(
                    "-fx-background-radius: 5em; " +
                            "-fx-min-width: 30px; " +
                            "-fx-min-height: 30px; " +
                            "-fx-max-width: 30px; " +
                            "-fx-max-height: 30px;"
            );
        }

        /*** Attach Home Base Buttons (MAGENTA) ***/
        for (int i = 0, j = 73; i < 4; i++, j -= 2) {
            paneTwo.add(buttonMagenta[i], 5, j);
        }

        /******* Gridpane style and size **********/
        paneTwo.setRotate(-60); // Rotate pane -60 degrees
        paneTwo.setStyle(
                "-fx-border-color:transparent;" +
                        "-fx-min-width: 212px; " +
                        "-fx-min-height: 758px; " +
                        "-fx-max-width: 212px; " +
                        "-fx-max-height: 758px;"
        );
    }
}