package Aggravation;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class CirclePaneOne {
    public static void circlePaneOne(GridPane circlePaneOne, Circle[] circleMain, Circle[] circleGreen, Circle[] circleRed) {
        // Circle 14 is the top center circle on gridpane 1
        // Circle 56 is the bottom center circle on gridpane 1
        /*** Attach the circles to circlePaneOne ***/
        circlePaneOne.add(circleMain[8], 1, 9);
        circlePaneOne.add(circleMain[9], 1, 7);
        circlePaneOne.add(circleMain[10], 1, 5);
        circlePaneOne.add(circleMain[11], 1, 3);
        circlePaneOne.add(circleMain[12], 1, 1);
        circlePaneOne.add(circleMain[13], 3, 1);
        circlePaneOne.add(circleMain[14], 5, 1);
        circlePaneOne.add(circleMain[15], 7, 1);
        circlePaneOne.add(circleMain[16], 9, 1);
        circlePaneOne.add(circleMain[17], 9, 3);
        circlePaneOne.add(circleMain[18], 9, 5);
        circlePaneOne.add(circleMain[19], 9, 7);
        circlePaneOne.add(circleMain[20], 9, 9);
        circlePaneOne.add(circleMain[21], 9, 11);

        circlePaneOne.add(circleMain[50], 9, 141);
        circlePaneOne.add(circleMain[51], 9, 143);
        circlePaneOne.add(circleMain[52], 9, 145);
        circlePaneOne.add(circleMain[53], 9, 147);
        circlePaneOne.add(circleMain[54], 9, 149);
        circlePaneOne.add(circleMain[55], 7, 149);
        circlePaneOne.add(circleMain[56], 5, 149);
        circlePaneOne.add(circleMain[57], 3, 149);
        circlePaneOne.add(circleMain[58], 1, 149);
        circlePaneOne.add(circleMain[59], 1, 147);
        circlePaneOne.add(circleMain[60], 1, 145);
        circlePaneOne.add(circleMain[61], 1, 143);
        circlePaneOne.add(circleMain[62], 1, 141);
        circlePaneOne.add(circleMain[63], 1, 139);

        /*** circlePaneOne Green Home Row ***/
        for (int i = 0; i < 4; i++) {
            circleGreen[i] = new Circle();
            circleGreen[i].setFill(Color.WHITE);
            circleGreen[i].setRadius(19.0);
        }

        /*** Attach Green Home Row ***/
        for (int i = 0, j = 3; i < 4; i++, j += 2) {
            circlePaneOne.add(circleGreen[i], 5, j);
        }

        /*** circlePaneOne Red Home Row ***/
        for (int i = 0; i < 4; i++) {
            circleRed[i] = new Circle();
            circleRed[i].setFill(Color.WHITE);
            circleRed[i].setRadius(19.0);
        }

        /*** Attach Red Home Row ***/
        for (int i = 0, j = 147; i < 4; i++, j -= 2) {
            circlePaneOne.add(circleRed[i], 5, j);
        }

        circlePaneOne.setRotate(60); // Rotate pane 60 degrees
        circlePaneOne.setStyle(
                "-fx-border-color:transparent;" +
                        "-fx-min-width: 212px; " +
                        "-fx-min-height: 758px; " +
                        "-fx-max-width: 212px; " +
                        "-fx-max-height: 758px;"
        );
    }
}