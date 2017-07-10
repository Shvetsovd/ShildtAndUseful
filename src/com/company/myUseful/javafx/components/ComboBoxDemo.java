package company.myUseful.javafx.components;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by OPER on 10.07.2017.
 */
public class ComboBoxDemo extends Application {
    ComboBox<String> cbTransport;
    Label lblSelectedTransport;

    public static void main(String[] args) {
        //-Запустить JavaFX приложение-
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //-Установить заголовок-
        primaryStage.setTitle("JavaFX Skeleton");

        //-Создать и установить сцену на подмостки-
        //Создать корневой узел
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        //Создать сцену
        Scene scene = new Scene(rootNode, 300, 200);
        //Установить сцену
        primaryStage.setScene(scene);

        //-Создать элементы интерфейса-

        //ComboBox
        //Создадим список элементов для ComboBox
        ObservableList<String> listTransport = FXCollections.observableArrayList(
                "Train1",
                "Car1",
                "Airplane1",
                "Train2",
                "Car2",
                "Airplane2");
        //Создаем ComboBox на основе списка
        cbTransport = new ComboBox<>(listTransport);
        //Установим возможность редактирования пунктов ComboBox
        cbTransport.setEditable(false);
        //Установим стартовый выбор
        cbTransport.setValue("Train1");

        //Создадим информационный Label
        lblSelectedTransport = new Label("Selected transport:");

        //-Задать обработчики событий интерфейса-
        cbTransport.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lblSelectedTransport.setText("Selected transport: " + cbTransport.getValue());
            }
        });

        //-Добавить элементы интерфейса к корневому узлу-
        rootNode.getChildren().addAll(cbTransport, lblSelectedTransport);
        //-Показать подмостки-
        primaryStage.show();
    }
}
