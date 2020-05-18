package Aggravation;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DevConsole {
    public static void display (Button opponent, Button home, Button center) {
        Stage window = new Stage();
        // Prevents user from interacting with the board while this window is active
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Developer Console");
        window.setMinWidth(500);
        window.setMinHeight(300);

        Label label = new Label();
        label.setText("Please select the game state you would like to change to.");

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close() );

        VBox design = new VBox(10);
        design.getChildren().addAll(label, opponent, home, center, closeButton);
        design.setAlignment(Pos.CENTER);

        Scene scene = new Scene(design);
        window.setScene(scene);
        window.showAndWait();
    }
}
