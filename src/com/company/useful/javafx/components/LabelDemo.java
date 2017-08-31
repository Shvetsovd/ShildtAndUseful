package company.useful.javafx.components;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by OPER on 07.07.2017.
 */
public class LabelDemo extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX LabelDemo Demo");

        FlowPane rootNode = new FlowPane();

        Scene scene = new Scene(rootNode, 300, 200);
        primaryStage.setScene(scene);

        //Create LabelDemo
        Label label = new Label("This is JavaFX label!");
        //Add LabelDemo to root node
        rootNode.getChildren().add(label);

        primaryStage.show();

    }
}
