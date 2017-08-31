package company.useful.javafx.components;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by OPER on 10.07.2017.
 */
public class ImageDemo extends Application {
    Image image;
    ImageView imageView;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Установить заголовок окна
        primaryStage.setTitle("Image Demo");
        //Создать корневой узел
        FlowPane rootNode = new FlowPane();
        //Создать сцену с привязкой корневого узла
        Scene scene = new Scene(rootNode);
        //Добавить сцену на подмостки
        primaryStage.setScene(scene);

        //загрузить изображение при помощи класса Image

        //В класс Image можно загрузить изображение
        // из URL
        // Если URL имеет неправильный формат, то будет считать это как путь к файлу на диске и грузить оттуда
        // из InputStream
        image = new Image("http://www.bbbpics.com/resize/resize-img.php?src=" +
                "http://img.bbbpics.com/images/Music/street-music-girl-headphones5570.jpg&h=380&w=596");

        //Показать изображение при помощи класса ImageView

        //В ImageView можно грузить как Image, так и напрямую URL
        imageView = new ImageView(image);
        //Добавть компоненты к корневову узлу
        rootNode.getChildren().add(imageView);
        //показать подмостки
        primaryStage.show();

    }
}
