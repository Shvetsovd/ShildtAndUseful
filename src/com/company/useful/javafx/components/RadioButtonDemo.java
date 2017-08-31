package company.useful.javafx.components;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by OPER on 10.07.2017.
 */
public class RadioButtonDemo extends Application {
    ToggleGroup tgRadioButtons;
    Label lblInfo;

    public static void main(String[] args) {
        //Запустить приложение
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //-Установить заголовок-
        primaryStage.setTitle("RadioButton Demo");

        //-Создать и установить сцену-
        //Создать корневой узел
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        //Создать сцену
        Scene scene = new Scene(rootNode, 180, 180);
        //Установить сцену
        primaryStage.setScene(scene);

        //-Создать элементы-
        //Создать Radio Buttons
        RadioButton rbTrain = new RadioButton("Train");
        RadioButton rbCar = new RadioButton("Car");
        RadioButton rbPlane = new RadioButton("Airplane");

        //Создать группу для кнопок
        tgRadioButtons = new ToggleGroup();
        //Назначить эту группу для Radio Buttons
        rbTrain.setToggleGroup(tgRadioButtons);
        rbCar.setToggleGroup(tgRadioButtons);
        rbPlane.setToggleGroup(tgRadioButtons);

        //Создать информационную метку
        lblInfo = new Label();

        //-Добавить обработчики событий-

        // Первый способ - добавить обработчик выбора на каждый RadioButton
        /*rbTrain.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lblInfo.setText("Train");
            }
        });
        rbCar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lblInfo.setText("Car");
            }
        });
        rbPlane.setOnAction((e) -> lblInfo.setText("Airplane"));*/

        //Второй способ - добавить обработчик изменения сразу на всю группу
        tgRadioButtons.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                RadioButton rb = (RadioButton) newValue;
                lblInfo.setText(rb.getText());
            }
        });

        //Сделать активным один из Radio Buttons
        rbPlane.fire();

        //-Добавить элементы в корневой узел-
        rootNode.getChildren().addAll(rbTrain, rbCar, rbPlane, lblInfo);
        //-Показать подмостки-
        primaryStage.show();
    }
}
