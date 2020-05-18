package Aggravation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class Stars
{
    public static void starGenerator(GridPane starPane)
    {
        starPane.setStyle(
                "-fx-background-color:white;" +
                        "-fx-min-width: 422px; " +
                        "-fx-min-height: 370px; " +
                        "-fx-max-width: 422px; " +
                        "-fx-max-height: 370px;");
        Image image0 = new Image("image/star.jpg");
        ImageView star0 = new ImageView(image0);
        Image image1 = new Image("image/star.jpg");
        ImageView star1 = new ImageView(image1);
        Image image2 = new Image("image/star.jpg");
        ImageView star2 = new ImageView(image2);
        Image image3 = new Image("image/star.jpg");
        ImageView star3 = new ImageView(image3);
        Image image4 = new Image("image/star.jpg");
        ImageView star4 = new ImageView(image4);
        Image image5 = new Image("image/star.jpg");
        ImageView star5 = new ImageView(image5);
        Image image6 = new Image("image/star.jpg");
        ImageView star6 = new ImageView(image6);
        starPane.add(star0, 0, 65);
        starPane.add(star1, 3, 0);
        starPane.add(star2, 85, 0);
        starPane.add(star3, 90, 65);
        starPane.add(star4, 3, 127);
        starPane.add(star5, 85, 127);
        star0.setRotate(-90);
        star3.setRotate(90);
        star1.setRotate(-107);
        star2.setRotate(107);
    }
}