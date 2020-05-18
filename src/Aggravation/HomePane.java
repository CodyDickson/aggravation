package Aggravation;

import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class HomePane {
    public static void homePane(GridPane homePaneZero, GridPane homePaneOne, GridPane homePaneTwo, Rectangle homeRectangleYellow, Rectangle homeRectangleBlue,
                                Rectangle homeRectangleGreen, Rectangle homeRectangleRed, Rectangle homeRectangleOrange, Rectangle homeRectangleWhite)
    {
        homePaneZero.setStyle(
                "-fx-border-color:transparent;" +
                        "-fx-min-width: 212px; " +
                        "-fx-min-height: 758px; " +
                        "-fx-max-width: 212px; " +
                        "-fx-max-height: 758px;"
        );

        homePaneZero.add(homeRectangleYellow, 27, 21);
        homePaneZero.add(homeRectangleBlue, 27, 188);

        homePaneOne.setRotate(60); // Rotate pane 60 degrees
        homePaneOne.setStyle(
                "-fx-border-color:transparent;" +
                        "-fx-min-width: 212px; " +
                        "-fx-min-height: 758px; " +
                        "-fx-max-width: 212px; " +
                        "-fx-max-height: 758px;"
        );

        homePaneOne.add(homeRectangleGreen, 27, 21);
        homePaneOne.add(homeRectangleRed, 27, 188);

        homePaneTwo.setRotate(-60); // Rotate pane -60 degrees
        homePaneTwo.setStyle(
                "-fx-border-color:transparent;" +
                        "-fx-min-width: 212px; " +
                        "-fx-min-height: 758px; " +
                        "-fx-max-width: 212px; " +
                        "-fx-max-height: 758px;"
        );

        homePaneTwo.add(homeRectangleOrange, 27, 21);
        homePaneTwo.add(homeRectangleWhite, 27, 188);
    }
}
