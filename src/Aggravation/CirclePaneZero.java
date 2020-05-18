package Aggravation;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class CirclePaneZero 
{
    public static void circlePaneZero(GridPane circlePaneZero, Circle[] circleMain, Circle circleCenterMain, Circle[] circleYellow, Circle[] circleBlue)
    {
        // Circle Zero is the top center circle on the board
        // The count goes clockwise around the board

        /*** Center Circle ***/
        circleCenterMain.setFill(Color.WHITE);
        circleCenterMain.setRadius(19);

        /*** Attach the Center Button Circle ***/
        circlePaneZero.add(circleCenterMain, 5, 67);

        /*** Attach the circles to circlePaneZero ***/
        circlePaneZero.add(circleMain[0], 5, 1);
        circlePaneZero.add(circleMain[1], 7, 1);
        circlePaneZero.add(circleMain[2], 9, 1);
        circlePaneZero.add(circleMain[3], 9, 3);
        circlePaneZero.add(circleMain[4], 9, 5);
        circlePaneZero.add(circleMain[5], 9, 7);
        circlePaneZero.add(circleMain[6], 9, 9);
        circlePaneZero.add(circleMain[7], 9, 11);

        circlePaneZero.add(circleMain[35], 9, 120);
        circlePaneZero.add(circleMain[36], 9, 122);
        circlePaneZero.add(circleMain[37], 9, 124);
        circlePaneZero.add(circleMain[38], 9, 126);
        circlePaneZero.add(circleMain[39], 9, 128);
        circlePaneZero.add(circleMain[40], 9, 130);
        circlePaneZero.add(circleMain[41], 7, 130);
        circlePaneZero.add(circleMain[42], 5, 130);
        circlePaneZero.add(circleMain[43], 3, 130);
        circlePaneZero.add(circleMain[44], 1, 130);
        circlePaneZero.add(circleMain[45], 1, 128);
        circlePaneZero.add(circleMain[46], 1, 126);
        circlePaneZero.add(circleMain[47], 1, 124);
        circlePaneZero.add(circleMain[48], 1, 122);
        circlePaneZero.add(circleMain[49], 1, 120);

        circlePaneZero.add(circleMain[77], 1, 11);
        circlePaneZero.add(circleMain[78], 1, 9);
        circlePaneZero.add(circleMain[79], 1, 7);
        circlePaneZero.add(circleMain[80], 1, 5);
        circlePaneZero.add(circleMain[81], 1, 3);
        circlePaneZero.add(circleMain[82], 1, 1);
        circlePaneZero.add(circleMain[83], 3, 1);

        /*** circlePaneZero Yellow Home Row ***/
        for (int i = 0; i < 4; i++) {
            circleYellow[i] = new Circle();
            circleYellow[i].setFill(Color.WHITE);
            circleYellow[i].setRadius(19.0);
        }

        /*** Attach Yellow Home Row***/
        for (int i = 0, j = 3; i < 4; i++, j += 2) {
            circlePaneZero.add(circleYellow[i], 5, j);
        }

        /*** circlePaneZero Blue Home Row ***/
        for (int i = 0; i < 4; i++) {
            circleBlue[i] = new Circle();
            circleBlue[i].setFill(Color.WHITE);
            circleBlue[i].setRadius(19.0);
        }

        /*** Attach Blue Home Row***/
        for (int i = 0, j = 128; i < 4; i++, j -= 2) {
            circlePaneZero.add(circleBlue[i], 5, j);
        }

        /*** Gridpane style and size ***/
        circlePaneZero.setStyle(
                "-fx-border-color:transparent;" +
                        "-fx-min-width: 212px; " +
                        "-fx-min-height: 758px; " +
                        "-fx-max-width: 212px; " +
                        "-fx-max-height: 758px;"
        );
    }
}