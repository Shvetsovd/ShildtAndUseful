package company.myUseful.javafx.skeletons;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class JavaFXSkeletonRusComments extends Application {

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
        FlowPane rootNode = new FlowPane();
        //Создать сцену
        Scene scene = new Scene(rootNode, 300, 200);
        //Установить сцену
        primaryStage.setScene(scene);

        //-Создать элементы интерфейса-
        //-Задать обработчики событий интерфейса-

        //-Добавить элементы интерфейса к корневому узлу-
        //-Показать подмостки-
        primaryStage.show();
    }

}
