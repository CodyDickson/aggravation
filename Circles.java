package Aggravation;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class Circles
{
    public static void circleGenerator(Circle circleCenter, Circle circleRim)
    {
        circleCenter.setRadius(25);
        circleCenter.setStroke(Color.BLACK); // Set circle stroke color
        circleCenter.setFill(Color.WHITE);

        circleRim.setRadius(130);
        circleRim.setStroke(Color.BLACK); // Set circle stroke color
        circleRim.setFill(Color.BLACK);
    }
}