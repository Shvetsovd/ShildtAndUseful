package company.useful.javafx.components;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by OPER on 10.07.2017.
 */
public class RadioButtonWithConfirmButtonDemo extends Application {
    ToggleGroup tgRadioButtons;
    Button btnConfirm;
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

        //Создать кнопку подтверждения выбора
        btnConfirm = new Button("Confirm");

        //Создать Separator для визуального разделения блоков
        Separator separator = new Separator(Orientation.HORIZONTAL);
        separator.setPrefWidth(scene.getWidth());

        //Создать информационную метку
        lblInfo = new Label("Select the transport");

        //-Добавить обработчики на элементы-
        //Добавим обработчик на событие нажатия кнопки
        btnConfirm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                RadioButton rb = (RadioButton) tgRadioButtons.getSelectedToggle();
                if (rb != null) {
                    lblInfo.setText(rb.getText());
                }
            }
        });

        //Сделаем активным один из Radio Buttons
        //rbPlane.fire();

        //-Добавить элементы в корневой узел-
        rootNode.getChildren().addAll(rbTrain, rbCar, rbPlane, btnConfirm, separator, lblInfo);
        //-Показать подмостки-
        primaryStage.show();
    }
}
