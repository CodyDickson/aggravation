package Aggravation;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class CircleArray 
{
    public static void generateCircleArray(Circle[] circle)
    {          
        /*** Generates the entire circle array ***/
        for (int i = 0; i < 84; i++) {
            circle[i] = new Circle();
            circle[i].setFill(Color.WHITE);
            circle[i].setRadius(19.0);
        }
    }
}