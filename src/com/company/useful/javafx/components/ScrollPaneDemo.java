package company.useful.javafx.components;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by OPER on 10.07.2017.
 */
public class ScrollPaneDemo extends Application {
    Label lblBigText;
    Button btnRestScroll;

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
        Scene scene = new Scene(rootNode, 250, 250);
        //Установить сцену
        primaryStage.setScene(scene);

        //-Создать элементы интерфейса-
        //Label с длинным текстом
        lblBigText = new Label(
                "JavaFX — платформа на основе Java\n" +
                        "для создания приложений с насыщенным графическим интерфейсом.\n" +
                        "Может использоваться как для создания настольных приложений,\n" +
                        "запускаемых непосредственно из-под операционных систем,\n" +
                        "так и для интернет-приложений (RIA), работающих в браузерах,\n" +
                        " и для приложений на мобильных устройствах.\n" +
                        "JavaFX призвана заменить использовавшуюся ранее библиотеку Swing.\n" +
                        " Платформа JavaFX конкурирует с\n" +
                        "Microsoft Silverlight, Adobe Flash и аналогичными системами."
        );

        //Панель прокрутки - ее можно прицепить к любому узлу сцены
        ScrollPane sp = new ScrollPane();
        //Установим желаемые размеры прокручиваемого элемента
        sp.setPrefViewportWidth(200);
        sp.setPrefViewportHeight(120);

        //Назначим Label прокручиваемым элементом
        sp.setContent(lblBigText);

        //Кнопка сброса положения скроллбара в нули
        btnRestScroll = new Button("Reset Scroll");

        //-Задать обработчики событий интерфейса-
        btnRestScroll.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sp.setHvalue(0);
                sp.setVvalue(0);
            }
        });

        //-Добавить элементы интерфейса к корневому узлу-
        rootNode.getChildren().addAll(sp, btnRestScroll);

        //-Показать подмостки-
        primaryStage.show();
    }
}
