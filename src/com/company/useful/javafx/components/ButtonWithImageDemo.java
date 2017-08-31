package company.useful.javafx.components;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by OPER on 10.07.2017.
 */
public class ButtonWithImageDemo extends Application {
    Button btnGreenPhone;
    Button btnBluePhone;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //-Задать заголовок-
        primaryStage.setTitle("Button wit Image Demo");
        //-Создать и установить сцену-
        //Задать корневой узел
        FlowPane rootNode = new FlowPane(10, 10);
        Scene scene = new Scene(rootNode);
        primaryStage.setScene(scene);

        //-Создать кнопки с изображениями-
        btnGreenPhone = new Button("Green Phone", new ImageView("https://img.appswinc.com/2016/12/08/com.mizuvoip.mizudroid.app.jpg"));
        //btnGreenPhone.setContentDisplay(ContentDisplay.TOP);
        btnGreenPhone.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

        btnBluePhone = new Button("Blue Phone", new ImageView("https://kazinvoice.kz/all/img/tel.png"));
        //btnBluePhone.setContentDisplay(ContentDisplay.TOP);
        btnBluePhone.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        //-Добавить элементы к корневому узлу-
        rootNode.getChildren().addAll(btnGreenPhone, btnBluePhone);
        //-Показать подмостки-
        primaryStage.show();
    }
}
