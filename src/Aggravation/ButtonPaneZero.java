package Aggravation;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ButtonPaneZero 
{
    public static void buttonPaneZero(GridPane paneZero, Button[] buttonMain, Button buttonCenter, Button[] buttonYellow, Button[] buttonBlue)
    {
        /*** Center Button ***/
        buttonCenter.setStyle(
                "-fx-background-radius: 5em; " +
                        "-fx-min-width: 30px; " +
                        "-fx-min-height: 30px; " +
                        "-fx-max-width: 30px; " +
                        "-fx-max-height: 30px;"
        );

        /*** Attach Center Button ***/
        paneZero.add(buttonCenter, 5, 31);

        /*** Attach Buttons to Pane Zero***/
        paneZero.add(buttonMain[0], 5, 1);
        paneZero.add(buttonMain[1], 7, 1);
        paneZero.add(buttonMain[2], 9, 1);
        paneZero.add(buttonMain[3], 9, 3);
        paneZero.add(buttonMain[4], 9, 5);
        paneZero.add(buttonMain[5], 9, 7);
        paneZero.add(buttonMain[6], 9, 9);
        paneZero.add(buttonMain[7], 9, 11);

        paneZero.add(buttonMain[35], 9, 50);
        paneZero.add(buttonMain[36], 9, 52);
        paneZero.add(buttonMain[37], 9, 54);
        paneZero.add(buttonMain[38], 9, 56);
        paneZero.add(buttonMain[39], 9, 58);
        paneZero.add(buttonMain[40], 9, 60);
        paneZero.add(buttonMain[41], 7, 60);
        paneZero.add(buttonMain[42], 5, 60);
        paneZero.add(buttonMain[43], 3, 60);
        paneZero.add(buttonMain[44], 1, 60);
        paneZero.add(buttonMain[45], 1, 58);
        paneZero.add(buttonMain[46], 1, 56);
        paneZero.add(buttonMain[47], 1, 54);
        paneZero.add(buttonMain[48], 1, 52);
        paneZero.add(buttonMain[49], 1, 50);

        paneZero.add(buttonMain[77], 1, 11);
        paneZero.add(buttonMain[78], 1, 9);
        paneZero.add(buttonMain[79], 1, 7);
        paneZero.add(buttonMain[80], 1, 5);
        paneZero.add(buttonMain[81], 1, 3);
        paneZero.add(buttonMain[82], 1, 1);
        paneZero.add(buttonMain[83], 3, 1);

        /*** Top Home Base Buttons (YELLOW) ***/
        for (int i = 0; i < 4; i++) {
            buttonYellow[i] = new Button();
            buttonYellow[i].setStyle(
                    "-fx-background-radius: 5em; " +
                            "-fx-min-width: 30px; " +
                            "-fx-min-height: 30px; " +
                            "-fx-max-width: 30px; " +
                            "-fx-max-height: 30px;"
            );
        }

        /*** Attach Home Base Buttons (YELLOW) ***/
        for (int i = 0, j = 3; i < 4; i++, j += 2) {
            paneZero.add(buttonYellow[i], 5, j);
        }

        /*** Bottom Home Base Buttons (BLUE) ***/
        for (int i = 0; i < 4; i++) {
            buttonBlue[i] = new Button();
            buttonBlue[i].setStyle(
                    "-fx-background-radius: 5em; " +
                            "-fx-min-width: 30px; " +
                            "-fx-min-height: 30px; " +
                            "-fx-max-width: 30px; " +
                            "-fx-max-height: 30px;"
            );
        }

        /*** Attach Home Base Buttons (BLUE) ***/
        for (int i = 0, j = 58; i < 4; i++, j -= 2) {
            paneZero.add(buttonBlue[i], 5, j);
        }

        /******* Gridpane style and size **********/
        paneZero.setStyle(
                "-fx-border-color:transparent;" +
                        "-fx-min-width: 212px; " +
                        "-fx-min-height: 758px; " +
                        "-fx-max-width: 212px; " +
                        "-fx-max-height: 758px;"
        );
    }
}