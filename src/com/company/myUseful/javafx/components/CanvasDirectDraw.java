package company.myUseful.javafx.components;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * Created by OPER on 10.07.2017.
 */
public class CanvasDirectDraw extends Application {
    GraphicsContext gc;
    Button btnChangeColor;
    Color[] colors = {Color.BLUE, Color.RED, Color.GREEN, Color.BLACK};
    int currentColorIdx;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Установим title приложения
        primaryStage.setTitle("Canvas Direct Draw");
        //Создадим корневой узел
        FlowPane rootNode = new FlowPane();
        rootNode.setAlignment(Pos.CENTER);
        //Создадим сцены и введем корневой узел
        Scene scene = new Scene(rootNode, 450, 450);
        //Установим сцену на подмостки
        primaryStage.setScene(scene);
        //Создадим Canvas
        Canvas canvas = new Canvas(400, 400);
        //Получим его графический контекст
        gc = canvas.getGraphicsContext2D();
        //Отрисуем элементы
        gc.strokeLine(0, 0, 200, 200);
        gc.strokeOval(100, 100, 200, 200);
        gc.strokeRect(0, 200, 50, 200);
        gc.fillOval(0, 0, 20, 20);
        gc.fillRect(100, 320, 300, 40);
        //Создадим кнопку изменения цвета
        btnChangeColor = new Button("Change color");
        //Добавим обработчик кнопке
        btnChangeColor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gc.setStroke(colors[currentColorIdx]);
                gc.setFill(colors[currentColorIdx]);

                //Перерисуем элементы, которые должны изменить цвет
                gc.strokeLine(0, 0, 200, 200);
                gc.fillText("This is drawn on the canvas", 60, 50);
                gc.fillRect(100, 320, 300, 40);

                currentColorIdx = ++currentColorIdx % colors.length;

            }
        });
        //Добавим узлы к корневому узлу
        rootNode.getChildren().addAll(canvas, btnChangeColor);
        //Покажем подмостки
        primaryStage.show();
    }
}
