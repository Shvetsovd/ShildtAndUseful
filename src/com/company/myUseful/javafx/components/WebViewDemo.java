package company.myUseful.javafx.components;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * Created by OPER on 07.07.2017.
 */
public class WebViewDemo extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX WebViewDemo Demo");

        FlowPane rootNode = new FlowPane();

        Scene scene = new Scene(rootNode);
        primaryStage.setScene(scene);

        //Create LabelDemo
        WebView view = new WebView();
        view.getEngine().load("https://ya.ru/");
        //Add LabelDemo to root node
        rootNode.getChildren().add(view);

        primaryStage.show();

    }
}
