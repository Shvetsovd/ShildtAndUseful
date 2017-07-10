package company.myUseful.javafx.components;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by OPER on 10.07.2017.
 */
public class TogleButtonDemo extends Application {
    ToggleButton btnOnOff;
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
        //Создать Label
        lblInfo = new Label("Push the button");

        //-Установить обработчики событий-
        btnOnOff.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (btnOnOff.isSelected()){
                    lblInfo.setText("Button is on");
                } else {
                    lblInfo.setText("Button is off");
                }
            }
        });

        //-Добавить элементы на корневой узел сцены-
        rootNode.getChildren().addAll(btnOnOff, lblInfo);
        //-Показать подмостки-
        primaryStage.show();
    }
}
