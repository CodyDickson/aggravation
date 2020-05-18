package Aggravation;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ButtonPaneOne
{
    public static void buttonPaneOne(GridPane paneOne, Button[] buttonMain, Button[] buttonGreen, Button[] buttonRed)
    {
        /*********** Attaching top half of buttons to gridpane **********/
        paneOne.add(buttonMain[8], 1, 9);
        paneOne.add(buttonMain[9], 1, 7);
        paneOne.add(buttonMain[10], 1, 5);
        paneOne.add(buttonMain[11], 1, 3);
        paneOne.add(buttonMain[12], 1, 1);
        paneOne.add(buttonMain[13], 3, 1);
        paneOne.add(buttonMain[14], 5, 1);
        paneOne.add(buttonMain[15], 7, 1);
        paneOne.add(buttonMain[16], 9, 1);
        paneOne.add(buttonMain[17], 9, 3);
        paneOne.add(buttonMain[18], 9, 5);
        paneOne.add(buttonMain[19], 9, 7);
        paneOne.add(buttonMain[20], 9, 9);
        paneOne.add(buttonMain[21], 9, 11);

        /******** Attaching bottom half of buttons to gridpane *************/
        paneOne.add(buttonMain[50], 9, 57);
        paneOne.add(buttonMain[51], 9, 59);
        paneOne.add(buttonMain[52], 9, 61);
        paneOne.add(buttonMain[53], 9, 63);
        paneOne.add(buttonMain[54], 9, 65);
        paneOne.add(buttonMain[55], 7, 65);
        paneOne.add(buttonMain[56], 5, 65);
        paneOne.add(buttonMain[57], 3, 65);
        paneOne.add(buttonMain[58], 1, 65);
        paneOne.add(buttonMain[59], 1, 63);
        paneOne.add(buttonMain[60], 1, 61);
        paneOne.add(buttonMain[61], 1, 59);
        paneOne.add(buttonMain[62], 1, 57);
        paneOne.add(buttonMain[63], 1, 55);

        /*** Bottom Home Base Buttons (GREEN) ***/
        for (int i = 0; i < 4; i++) {
            buttonGreen[i] = new Button();
            buttonGreen[i].setStyle(
                    "-fx-background-radius: 5em; " +
                            "-fx-min-width: 30px; " +
                            "-fx-min-height: 30px; " +
                            "-fx-max-width: 30px; " +
                            "-fx-max-height: 30px;"
            );
        }

        /*** Attach Home Base Buttons (GREEN) ***/
        for (int i = 0, j = 3; i < 4; i++, j += 2) {
            paneOne.add(buttonGreen[i], 5, j);
        }

        /*** Bottom Home Base Buttons (RED) ***/
        for (int i = 0; i < 4; i++) {
            buttonRed[i] = new Button();
            buttonRed[i].setStyle(
                    "-fx-background-radius: 5em; " +
                            "-fx-min-width: 30px; " +
                            "-fx-min-height: 30px; " +
                            "-fx-max-width: 30px; " +
                            "-fx-max-height: 30px;"
            );
        }

        /*** Attach Home Base Buttons (RED) ***/
        for (int i = 0, j = 63; i < 4; i++, j -= 2) {
            paneOne.add(buttonRed[i], 5, j);
        }

        /******* Gridpane style and size **********/
        paneOne.setRotate(60); // Rotate pane 60 degrees
        paneOne.setStyle(
                "-fx-border-color:transparent;" +
                        "-fx-min-width: 212px; " +
                        "-fx-min-height: 758px; " +
                        "-fx-max-width: 212px; " +
                        "-fx-max-height: 758px;"
        );
    }
}