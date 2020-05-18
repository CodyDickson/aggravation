package Aggravation;
import javafx.scene.shape.Rectangle;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class BaseButtons
{
    public static void baseButtons(GridPane basePaneZero, GridPane basePaneOne, GridPane basePaneTwo, Button[] buttonYellowBase, Button[] buttonBlueBase,
                                   Button[] buttonGreenBase, Button[] buttonMagentaBase, Button[] buttonRedBase, Button[] buttonOrangeBase)
    {
        basePaneZero.setStyle(
                "-fx-background-base:white;" +
                        "-fx-border-base:transparent;" +
                        "-fx-min-width: 212px; " +
                        "-fx-min-height: 900px; " +
                        "-fx-max-width: 212px; " +
                        "-fx-max-height: 900px;"
        );
        basePaneZero.setHgap(5);
        basePaneZero.setVgap(5);

        /*********** Yellow Base Buttons ******************/
        for (int i = 0; i < 4; i++) {
            buttonYellowBase[i] = new Button();
            buttonYellowBase[i].setStyle(
                    "-fx-background-radius: 5em; " +
                            "-fx-min-width: 30px; " +
                            "-fx-min-height: 30px; " +
                            "-fx-max-width: 30px; " +
                            "-fx-max-height: 30px;"
            );
        }

        /*********** Blue Base Buttons *****************/
        for (int i = 0; i < 4; i++) {
            buttonBlueBase[i] = new Button();
            buttonBlueBase[i].setStyle(
                    "-fx-background-radius: 5em; " +
                            "-fx-min-width: 30px; " +
                            "-fx-min-height: 30px; " +
                            "-fx-max-width: 30px; " +
                            "-fx-max-height: 30px;"
            );
        }

        /******* Attaching Yellow and Blue Buttons to Start Base **********/
        for (int i = 0, j = 4; i < 4; i++, j += 4) {
            basePaneZero.add(buttonYellowBase[i], j, 4);
        }

        for (int i = 0, j = 4; i < 4; i++, j += 4) {
            basePaneZero.add(buttonBlueBase[i], j, 164);
        }

        basePaneOne.setRotate(60); // Rotate pane 60 degrees
        basePaneOne.setStyle(
                "-fx-background-base:white;" +
                        "-fx-border-base:transparent;" +
                        "-fx-min-width: 212px; " +
                        "-fx-min-height: 900px; " +
                        "-fx-max-width: 212px; " +
                        "-fx-max-height: 900px;"
        );
        basePaneOne.setHgap(5);
        basePaneOne.setVgap(5);

        /*********** Green Base Buttons ******************/
        for (int i = 0; i < 4; i++) {
            buttonGreenBase[i] = new Button();
            buttonGreenBase[i].setStyle(
                    "-fx-background-radius: 5em; " +
                            "-fx-min-width: 30px; " +
                            "-fx-min-height: 30px; " +
                            "-fx-max-width: 30px; " +
                            "-fx-max-height: 30px;"
            );
        }

        /*********** Red Base Buttons *****************/
        for (int i = 0; i < 4; i++) {
            buttonRedBase[i] = new Button();
            buttonRedBase[i].setStyle(
                    "-fx-background-radius: 5em; " +
                            "-fx-min-width: 30px; " +
                            "-fx-min-height: 30px; " +
                            "-fx-max-width: 30px; " +
                            "-fx-max-height: 30px;"
            );
        }

        /******* Attaching Green and Red Buttons to Start Base **********/
        for (int i = 0, j = 4; i < 4; i++, j += 4) {
            basePaneOne.add(buttonGreenBase[i], j, 4);
        }

        for (int i = 0, j = 4; i < 4; i++, j += 4) {
            basePaneOne.add(buttonRedBase[i], j, 164);
        }

        basePaneTwo.setRotate(-60); // Rotate pane -60 degrees
        basePaneTwo.setStyle(
                "-fx-background-base:white;" +
                        "-fx-border-base:transparent;" +
                        "-fx-min-width: 212px; " +
                        "-fx-min-height: 900px; " +
                        "-fx-max-width: 212px; " +
                        "-fx-max-height: 900px;"
        );
        basePaneTwo.setHgap(5);
        basePaneTwo.setVgap(5);

        /*********** Orange Base Buttons ******************/
        for (int i = 0; i < 4; i++) {
            buttonOrangeBase[i] = new Button();
            buttonOrangeBase[i].setStyle(
                    "-fx-background-radius: 5em; " +
                            "-fx-min-width: 30px; " +
                            "-fx-min-height: 30px; " +
                            "-fx-max-width: 30px; " +
                            "-fx-max-height: 30px;"
            );
        }

        /*********** Magenta Base Buttons *****************/
        for (int i = 0; i < 4; i++) {
            buttonMagentaBase[i] = new Button();
            buttonMagentaBase[i].setStyle(
                    "-fx-background-radius: 5em; " +
                            "-fx-min-width: 30px; " +
                            "-fx-min-height: 30px; " +
                            "-fx-max-width: 30px; " +
                            "-fx-max-height: 30px;"
            );
        }

        /******* Attaching Orange and Magenta Buttons to Start Base **********/
        for (int i = 0, j = 4; i < 4; i++, j += 4) {
            basePaneTwo.add(buttonOrangeBase[i], j, 4);
        }

        for (int i = 0, j = 4; i < 4; i++, j += 4) {
            basePaneTwo.add(buttonMagentaBase[i], j, 164);
        }
    }
}