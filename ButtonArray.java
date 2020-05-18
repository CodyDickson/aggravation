package Aggravation;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ButtonArray 
{
    public static void buttonArray(Button[] buttonMain)
    {          
    /***************Button Panes are buttons that represent the marbles for the game. ************************************/
        /*** Generate the entire button array ***/
        for (int i = 0; i < 84; i++) 
        {
            buttonMain[i] = new Button();
            buttonMain[i].setStyle(
                    "-fx-background-radius: 5em; " +
                            "-fx-min-width: 30px; " +
                            "-fx-min-height: 30px; " +
                            "-fx-max-width: 30px; " +
                            "-fx-max-height: 30px;"
            );
        }
    }
}