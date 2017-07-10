package company.myUseful.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Tooltip - всплывающая подсказка, может применяться для любого узла
 * setTooltip(new Tooltip("Подсказка"))
 */
public class ToolTipsDemo extends Application {

    public static void main(String[] args) {
        //-Запустить JavaFX приложение-
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Установить title приложения
        primaryStage.setTitle("JavaFX Button Event Demo");
        //Создать корневой узел
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        //Создать сцену и отдать ей корневой узел
        Scene scene = new Scene(rootNode, 200, 200);
        //Поставить сцену на подмостки
        primaryStage.setScene(scene);

        //Создать элементы
        Label lbl = new Label();
        Button btnAlpha = new Button("Alpha");
        btnAlpha.setTooltip(new Tooltip("Alpha Button"));

        Button btnBeta = new Button("Beta");
        btnBeta.setTooltip(new Tooltip("Beta Button"));

        //Добавить нужные обработчики
        btnAlpha.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lbl.setText("Alpha was pressed");
            }
        });

        btnBeta.setOnAction((e) -> lbl.setText("Betta was pressed"));

        //Добавить элементы в корневой узел
        rootNode.getChildren().addAll(btnAlpha, btnBeta, lbl);

        //Показать подмостки
        primaryStage.show();
    }
}
