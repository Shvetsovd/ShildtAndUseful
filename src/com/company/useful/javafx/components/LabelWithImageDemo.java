package company.useful.javafx.components;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by OPER on 10.07.2017.
 */
public class LabelWithImageDemo extends Application {
    Label lblWithImage;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Задать заголовок
        primaryStage.setTitle("Image in Label Demo");
        //Создать корневой узел
        FlowPane rootNode = new FlowPane();
        //Создать сцену
        Scene scene = new Scene(rootNode);
        //Установить сцену на подмостки
        primaryStage.setScene(scene);

        //Создать Label с изображением
        ImageView iv = new ImageView("http://www.bbbpics.com/resize/resize-img.php?src=" +
                "http://img.bbbpics.com/images/Music/street-music-girl-headphones5570.jpg&h=380&w=596");
        lblWithImage = new Label("Label text", iv);
            //Установим расположение текста и графики друг относительно друга в метке
        lblWithImage.setContentDisplay(ContentDisplay.BOTTOM);

        //Добавить узлы к корневому узлу
        rootNode.getChildren().add(lblWithImage);
        //Показать подмостки
        primaryStage.show();
    }
}
