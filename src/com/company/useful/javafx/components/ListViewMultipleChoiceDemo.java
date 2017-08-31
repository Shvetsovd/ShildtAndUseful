package company.useful.javafx.components;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


/**
 * Created by OPER on 10.07.2017.
 */
public class ListViewMultipleChoiceDemo extends Application {
    ListView<String> lwTransport;
    Label lblSelectedTransportInfo;

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
        Scene scene = new Scene(rootNode, 180, 150);
        //Установить сцену
        primaryStage.setScene(scene);

        //-Создать элементы-
        //ListView
        //Создать список элементов
        ObservableList<String> transportTypes =
                FXCollections.observableArrayList(
                        "Train1",
                        "Car1",
                        "Airplane1",
                        "Train2",
                        "Car2",
                        "Airplane2");
        //Создать ListView с этим списком
        lwTransport = new ListView<>(transportTypes);
        //Установим модель выбора элементов - один элемент(по умолчанию) или несколько
        lwTransport.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //Установить желаемый размер ListView
        lwTransport.setPrefWidth(80);
        lwTransport.setPrefHeight(130);

        //Создадим информационный Label
        lblSelectedTransportInfo = new Label("Select the transport");

        //-Добавить обработчик выбора из ListView-
        //Получим модель выбора
        MultipleSelectionModel<String> selectionModel = lwTransport.getSelectionModel();
        //обработчик
        selectionModel.selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                //Получим список выбранных элементов ListView
                ObservableList<String> selectedItems = selectionModel.getSelectedItems();

                String selected = "";
                for (String selectedItem : selectedItems) {
                    selected += "\n" + selectedItem;
                }

                lblSelectedTransportInfo.setText("Transport selected is: " + selected);
            }
        });

        //Добавить элементы интерфейса на корневой узел
        rootNode.getChildren().addAll(lwTransport, lblSelectedTransportInfo);

        //Показать подмостки
        primaryStage.show();
    }
}





















