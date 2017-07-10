package company.myUseful.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by user on 10.07.2017.
 */
public class DisableNodeDemo extends Application {
    ToggleButton btnOnOff;
    TextField tf;
    Label lblInfo;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //-Задать заголовок-
        primaryStage.setTitle("Toogle Button Demo");
        //-Создать и установить сцену-
        //Создать корневой узел
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        //Создать сцену
        Scene scene = new Scene(rootNode, 300, 200);
        //Установить сцену
        primaryStage.setScene(scene);

        //-Создать элементы-
        //Создать кнопку
        btnOnOff = new ToggleButton("On/Off");
        btnOnOff.setSelected(false);

        //Создать TextField
        tf = new TextField();
        tf.setPrefColumnCount(20);
        tf.setPromptText("Push the button for disable text field");
        //Создать Label
        lblInfo = new Label("Text field enabled");


        //-Установить обработчики событий-
        btnOnOff.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (btnOnOff.isSelected()){
                    tf.setDisable(true);
                    lblInfo.setText("Text field disabled");
                } else {
                    tf.setDisable(false);
                    lblInfo.setText("Text field enabled");
                }
            }
        });

        //-Добавить элементы на корневой узел сцены-
        rootNode.getChildren().addAll(btnOnOff, tf, lblInfo);
        //-Показать подмостки-
        primaryStage.show();
    }
}
