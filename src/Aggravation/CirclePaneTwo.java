package Aggravation;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class CirclePaneTwo 
{
    public static void circlePaneTwo(GridPane circlePaneTwo, Circle[] circleMain, Circle[] circleOrange, Circle[] circleMagenta)
    {
        /*** Attach the circles to circlePaneTwo ***/
        circlePaneTwo.add(circleMain[22], 9, 179);
        circlePaneTwo.add(circleMain[23], 9, 181);
        circlePaneTwo.add(circleMain[24], 9, 183);
        circlePaneTwo.add(circleMain[25], 9, 185);
        circlePaneTwo.add(circleMain[26], 9, 187);
        circlePaneTwo.add(circleMain[27], 7, 187);
        circlePaneTwo.add(circleMain[28], 5, 187);
        circlePaneTwo.add(circleMain[29], 3, 187);
        circlePaneTwo.add(circleMain[30], 1, 187);
        circlePaneTwo.add(circleMain[31], 1, 185);
        circlePaneTwo.add(circleMain[32], 1, 183);
        circlePaneTwo.add(circleMain[33], 1, 181);
        circlePaneTwo.add(circleMain[34], 1, 179);

        circlePaneTwo.add(circleMain[64], 1, 9);
        circlePaneTwo.add(circleMain[65], 1, 7);
        circlePaneTwo.add(circleMain[66], 1, 5);
        circlePaneTwo.add(circleMain[67], 1, 3);
        circlePaneTwo.add(circleMain[68], 1, 1);
        circlePaneTwo.add(circleMain[69], 3, 1);
        circlePaneTwo.add(circleMain[70], 5, 1);
        circlePaneTwo.add(circleMain[71], 7, 1);
        circlePaneTwo.add(circleMain[72], 9, 1);
        circlePaneTwo.add(circleMain[73], 9, 3);
        circlePaneTwo.add(circleMain[74], 9, 5);
        circlePaneTwo.add(circleMain[75], 9, 7);
        circlePaneTwo.add(circleMain[76], 9, 9);

        /*** circlePaneTwo Orange Home Row ***/
        for (int i = 0; i < 4; i++) {
            circleOrange[i] = new Circle();
            circleOrange[i].setFill(Color.WHITE);
            circleOrange[i].setRadius(19.0);
        }

        /*** Attach Orange Home Row ***/
        for (int i = 0, j = 3; i < 4; i++, j += 2) {
            circlePaneTwo.add(circleOrange[i], 5, j);
        }

        /*** circlePaneTwo Magenta Home Row ***/
        for (int i = 0; i < 4; i++) {
            circleMagenta[i] = new Circle();
            circleMagenta[i].setFill(Color.WHITE);
            circleMagenta[i].setRadius(19.0);
        }

        /*** Attach Magenta Home Row***/
        for (int i = 0, j = 185; i < 4; i++, j -= 2) {
            circlePaneTwo.add(circleMagenta[i], 5, j);
        }

        circlePaneTwo.setRotate(-60); // Rotate pane 60 degrees
        circlePaneTwo.setStyle(
                "-fx-border-color:transparent;" +
                        "-fx-min-width: 212px; " +
                        "-fx-min-height: 758px; " +
                        "-fx-max-width: 212px; " +
                        "-fx-max-height: 758px;"
        );
    }
}