package company.myUseful.javafx.components;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by OPER on 10.07.2017.
 */
public class TreeViewDemo extends Application {
    TreeView<String> tvFood;
    Label lblPathToProduct;

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
        Scene scene = new Scene(rootNode, 310, 460);
        //Установить сцену
        primaryStage.setScene(scene);

        //-Создать элементы интерфейса-
        //Метка, которая будет содержать путь до продукта
        lblPathToProduct = new Label("No selection");

        //Дерево продуктов
        //Сначала формируем все дерево, а потом добавим в TreeView
        //Вершина - Food
        TreeItem<String> tiRoot = new TreeItem<>("Food");

        //Ветвь - Food -> Fruit
        TreeItem<String> tiFruit = new TreeItem<>("Fruit");
        //Ветвь Food -> Fruit -> Apples
        TreeItem<String> tiApples = new TreeItem<>("Apples");
        tiApples.getChildren().add(new TreeItem<>("Fuji"));
        tiApples.getChildren().add(new TreeItem<>("Winesap"));
        tiApples.getChildren().add(new TreeItem<>("Jonathan"));
        tiFruit.getChildren().add(tiApples);
        //Добавим еще пару фруктов
        tiFruit.getChildren().add(new TreeItem<>("Orange"));
        tiFruit.getChildren().add(new TreeItem<>("Pears"));
        //Добавим ветку фрукты к узлу Food
        tiRoot.getChildren().add(tiFruit);

        //Ветвь - Food -> Vegetables
        TreeItem<String> tiVegetables = new TreeItem<>("Vegetables");
        tiVegetables.getChildren().add(new TreeItem<>("Corn"));
        tiVegetables.getChildren().add(new TreeItem<>("Peas"));
        tiVegetables.getChildren().add(new TreeItem<>("Broccoli"));
        tiVegetables.getChildren().add(new TreeItem<>("Beans"));
        tiRoot.getChildren().add(tiVegetables);

        //Ветвь - Food -> Nuts
        TreeItem<String> tiNuts = new TreeItem<>("Nuts");
        tiNuts.getChildren().add(new TreeItem<>("Walnuts"));
        tiNuts.getChildren().add(new TreeItem<>("Peanuts"));
        tiNuts.getChildren().add(new TreeItem<>("Pecans"));
        tiRoot.getChildren().add(tiNuts);

        //Теперь создаем древовидное представление и добавляем туда наше дерево
        tvFood = new TreeView<>(tiRoot);
        tvFood.setPrefHeight(350);

        //-Задать обработчики событий интерфейса-

        //Выбор элемента дерева
        //Сначала получим модель выбора (один или несколько элементов)
        MultipleSelectionModel<TreeItem<String>> selectionModel =
                tvFood.getSelectionModel();
        //Повесим на нее обработчик
        selectionModel.selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
            @Override
            public void changed(
                    ObservableValue<? extends TreeItem<String>> observable,
                    TreeItem<String> oldValue,
                    TreeItem<String> newValue
            ) {
                if (newValue != null) {
                    String path = newValue.getValue();
                    TreeItem<String> tmp = newValue.getParent();

                    while (tmp != null){
                        path = tmp.getValue()+ " -> " + path;
                        tmp = tmp.getParent();
                    }
                    lblPathToProduct.setText(path);
                }
            }
        });

        //-Добавить элементы интерфейса к корневому узлу-
        rootNode.getChildren().addAll(tvFood, lblPathToProduct);
        //-Показать подмостки-
        primaryStage.show();
    }
}
