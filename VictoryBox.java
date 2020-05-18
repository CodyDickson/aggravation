package Aggravation;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class VictoryBox {
    public static void display(String message) {
        Stage window = new Stage();
        // Prevents user from interacting with the board while this window is active
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Victory!");
        window.setMinWidth(300);
        window.setMinHeight(300);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Close and View Board");
        closeButton.setOnAction(e -> window.close() );

        VBox design = new VBox(10);
        design.getChildren().addAll(label, closeButton);
        design.setAlignment(Pos.CENTER);

        Scene scene = new Scene(design);
        window.setScene(scene);
        window.showAndWait();
    }
}
