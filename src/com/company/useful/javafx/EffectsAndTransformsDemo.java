package company.useful.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

/**
 * Основные эффекты (Effect):
 * Bloom - увеличение яркости самых ярких частей узла
 * BoxBlur - Размывает узел, делает его нерезким
 * DropShadow - Отбрасывание тени на задний план
 * Glow - свечение
 * InnerShasow - внутренняя тень
 * Lighting - создает теневые эффекты источника света
 * <p>
 * Основные преобразования (Transform):
 * Rotate - вращение узла вокруг заданной точки
 * Scale - масштабирование узла
 * Shear - наклон
 * Translate - перемещение
 */
public class EffectsAndTransformsDemo extends Application {
    //Элементы окна
    Button btnRotate, btnScale, btnGlow, btnShadow;

    //параметры эффектов
    double angle = 0.0;
    double glowVal = 0.0;
    boolean shadow = false;
    double scaleFactor = 1.0;

    public static void main(String[] args) {
        //-Запустить JavaFX приложение-
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //-Установить заголовок-
        primaryStage.setTitle("Effects and Transforms Demo");

        //-Создать и установить сцену на подмостки-
        //Создать корневой узел
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        //Создать сцену
        Scene scene = new Scene(rootNode, 300, 200);
        //Установить сцену
        primaryStage.setScene(scene);

        //-Создать элементы интерфейса-
        //Создадим эффекты
        Glow efGlow = new Glow(glowVal);
        InnerShadow efInShadow = new InnerShadow(10.0, Color.RED);
        Rotate efRotate = new Rotate();
        Scale efScale = new Scale(scaleFactor, scaleFactor);

        //Создадим кнопки и привяжем к ним эффекты
        btnGlow = new Button("Glow");
        btnGlow.setEffect(efGlow);

        btnRotate = new Button("Rotate");
        btnRotate.getTransforms().add(efRotate);

        btnScale = new Button("scale");
        btnScale.getTransforms().add(efScale);

        btnShadow = new Button("Shadow");
        btnShadow.setEffect(efInShadow);

        //-Задать обработчики событий интерфейса-
        btnGlow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                glowVal = (glowVal + 0.1) % 1.0;
                efGlow.setLevel(glowVal);
            }
        });

        btnRotate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                angle += 30.0;
                efRotate.setAngle(angle);
                efRotate.setPivotX(btnRotate.getWidth() / 2);
                efRotate.setPivotY(btnRotate.getHeight() / 2);
            }
        });

        btnScale.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scaleFactor += 0.1;
                if (scaleFactor > 1.0){
                    scaleFactor = 0.4;
                }

                efScale.setX(scaleFactor);
                efScale.setY(scaleFactor);
            }
        });

        btnShadow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                shadow = !shadow;
                if (shadow){
                    btnShadow.setEffect(efInShadow);
                    btnShadow.setText("Shadow On");
                } else {
                    btnShadow.setEffect(null);
                    btnShadow.setText("Shadow Off");
                }
            }
        });

        //-Добавить элементы интерфейса к корневому узлу-
        rootNode.getChildren().addAll(btnGlow, btnRotate, btnScale, btnShadow);
        //-Показать подмостки-
        primaryStage.show();
    }
}



















