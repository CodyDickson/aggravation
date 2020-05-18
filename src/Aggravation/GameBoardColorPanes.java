package Aggravation;
import javafx.scene.shape.Rectangle;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class GameBoardColorPanes
{
    public static void colorPanes(GridPane colorPaneZero, GridPane colorPaneOne, GridPane colorPaneTwo, Rectangle rectangleYellowBase, Rectangle rectangleBlueBase,
                                   Rectangle rectangleGreenBase, Rectangle rectangleRedBase, Rectangle rectangleOrangeBase, Rectangle rectangleWhiteBase)
    {
        colorPaneZero.setStyle(
                "-fx-background-color:white;" +
                        "-fx-border-color:transparent;" +
                        "-fx-min-width: 212px; " +
                        "-fx-min-height: 900px; " +
                        "-fx-max-width: 212px; " +
                        "-fx-max-height: 900px;");
        colorPaneZero.setHgap(0);
        colorPaneZero.setVgap(768);             // Create gaps between bases.

        colorPaneZero.add(rectangleYellowBase, 0, 0);
        colorPaneZero.add(rectangleBlueBase, 0, 1);

        colorPaneOne.setRotate(60); // Rotate pane 60 degrees
        colorPaneOne.setStyle(
                "-fx-background-color:white;" +
                        "-fx-border-color:transparent;" +
                        "-fx-min-width: 212px; " +
                        "-fx-min-height: 900px; " +
                        "-fx-max-width: 212px; " +
                        "-fx-max-height: 900px;");
        colorPaneOne.setHgap(0);
        colorPaneOne.setVgap(768);                   // Create gaps between bases.

        colorPaneOne.add(rectangleGreenBase, 0, 0);
        colorPaneOne.add(rectangleRedBase, 0, 1);

        colorPaneTwo.setRotate(-60); // Rotate pane 60 degrees
        colorPaneTwo.setStyle(
                "-fx-background-color:white;" +
                        "-fx-border-color:transparent;" +
                        "-fx-min-width: 212px; " +
                        "-fx-min-height: 900px; " +
                        "-fx-max-width: 212px; " +
                        "-fx-max-height: 900px;");
        colorPaneTwo.setHgap(0);
        colorPaneTwo.setVgap(768);              // Create gaps between bases.

        colorPaneTwo.add(rectangleOrangeBase, 0, 0);
        colorPaneTwo.add(rectangleWhiteBase, 0, 1);
    }
}