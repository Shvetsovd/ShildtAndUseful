package company.myUseful.javafx.menu;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;


/**
 * Created by user on 10.07.2017.
 */
public class MenuToolBarContextMenuDemo extends Application {
    MenuBar mbMainMenu;
    ToolBar tbDebug;
    ContextMenu cmEditMenu;

    //Для простоты зададим единый обработчик событий для всех пунктов меню
    EventHandler<ActionEvent> menuHandler;

    TextField tf;
    Separator separator;
    Label lblInfo;

    public static void main(String[] args) {
        //-Запустить JavaFX приложение-
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //-Установить заголовок-
        primaryStage.setTitle("Menu Demonstartor");

        //-Создать и установить сцену на подмостки-
        //Создать корневой узел
        BorderPane rootNode = new BorderPane();
        //Создать сцену
        Scene scene = new Scene(rootNode, 300, 300);
        //Установить сцену
        primaryStage.setScene(scene);

        //-Создать элементы интерфейса-

        //Создать общий обработчик пунктов меню, который передает в Label выбранный пункт.
        //Это делаем в данном случае до создания меню, т.к. пункты меню в соответствующих методах
        //привязываются к этому обработчику
        menuHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = ((MenuItem) event.getTarget()).getText();
                if (name.equals("Exit")) {
                    Platform.exit();
                } else {
                    lblInfo.setText(name + " selected");
                }
            }
        };
        //Создать главное меню
        makeMainMenu();
        //Создать панель инструментов
        makeToolBar();
        //Создать всплывающее контекстное меню
        makeContextMenu();

        //Текстовое поле для контекстного меню
        tf = new TextField();
        tf.setPrefColumnCount(20);
        tf.setPromptText("Some text here");
        tf.setContextMenu(cmEditMenu);

        separator = new Separator();
        separator.setPrefWidth(scene.getWidth());

        lblInfo = new Label("Selected menu item: ");

        //-Задать обработчики событий интерфейса-


        //Обработчик, который отображает контекстное меню для TextField tf
        rootNode.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent event) {
                cmEditMenu.show(rootNode, event.getScreenX(), event.getScreenY());
            }
        });

        //-Добавить элементы интерфейса к корневому узлу-
        //Верх
        rootNode.setTop(mbMainMenu);

        //Центр
        FlowPane rootCenterPane = new FlowPane(10, 10);
        rootCenterPane.setAlignment(Pos.CENTER);
        rootCenterPane.getChildren().addAll(tf, separator, lblInfo);
        rootNode.setCenter(rootCenterPane);

        //Низ
        rootNode.setBottom(tbDebug);

        //-Показать подмостки-
        primaryStage.show();
    }

    private void makeMainMenu() {
        mbMainMenu = new MenuBar();

        makeMainMenuFile();
        makeMainMenuOptions();
        MakeMainMenuHelp();
    }

    private void makeMainMenuFile() {
        //-Пункт главного меню - File-
        Menu menuFile = new Menu("_File");

        //-Элементы меню File-
        MenuItem open = new MenuItem("Open");
        open.setAccelerator(KeyCombination.keyCombination("shortcut+O"));

        MenuItem close = new MenuItem("Close");
        close.setAccelerator(KeyCombination.keyCombination("shortcut+C"));

        MenuItem save = new MenuItem("Save");
        save.setAccelerator(KeyCombination.keyCombination("shortcut+S"));

        MenuItem exit = new MenuItem("Exit");
        exit.setAccelerator(KeyCombination.keyCombination("shortcut+E"));

        //-Добавить элементы в меню File-
        menuFile.getItems().addAll(
                open,
                close,
                save,
                new SeparatorMenuItem(),
                exit
        );

        //-Установить обработчики для элементов меню-
        open.setOnAction(menuHandler);
        close.setOnAction(menuHandler);
        save.setOnAction(menuHandler);
        exit.setOnAction(menuHandler);

        //-Добавить меню File в главное меню-
        mbMainMenu.getMenus().add(menuFile);

    }

    private void makeMainMenuOptions() {
        //-Пункт главного меню - Options-
        Menu menuOptions = new Menu("Options");

        //-Создать элементы меню Options-
        //Подменю Colors
        Menu menuColors = new Menu("Colors");
        CheckMenuItem cmiRed = new CheckMenuItem("Red");
        CheckMenuItem cmiGreen = new CheckMenuItem("Green");
        CheckMenuItem cmiBlue = new CheckMenuItem("Blue");
        cmiRed.setSelected(true);
        menuColors.getItems().addAll(cmiRed, cmiGreen, cmiBlue);

        //Подменю Priority
        Menu menuPriority = new Menu("Priority");
        RadioMenuItem rbmiHigh = new RadioMenuItem("High");
        RadioMenuItem rbmiLow = new RadioMenuItem("Low");

        ToggleGroup tgPriority = new ToggleGroup();
        rbmiHigh.setToggleGroup(tgPriority);
        rbmiLow.setToggleGroup(tgPriority);
        rbmiHigh.setSelected(true);

        menuPriority.getItems().addAll(rbmiHigh, rbmiLow);

        //Пункт меню Reset
        MenuItem miReset = new MenuItem("Reset");

        //-Добавить элементы в меню Options-
        menuOptions.getItems().addAll(
                menuColors,
                menuPriority,
                new SeparatorMenuItem(),
                miReset
        );

        //-Установить обработчики для элементов меню-
        //Обработчик, который отображает в информационном Label lblInfo выбранный Radio Button из меню Priority
        tgPriority.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (newValue == null) {
                    return;
                }
                RadioMenuItem rmiSelected = (RadioMenuItem)newValue;

                lblInfo.setText("Priority selected is " + rmiSelected.getText());
            }
        });

        cmiRed.setOnAction(menuHandler);
        cmiGreen.setOnAction(menuHandler);
        cmiBlue.setOnAction(menuHandler);
        rbmiHigh.setOnAction(menuHandler);
        rbmiLow.setOnAction(menuHandler);
        miReset.setOnAction(menuHandler);

        //-Добавить меню Options в главное меню-
        mbMainMenu.getMenus().add(menuOptions);


    }

    private void MakeMainMenuHelp() {
        //Создать меню Help
        Menu menuHelp = new Menu("Help");

        //Создать подменю
        MenuItem miAbout = new MenuItem("About", new ImageView("https://www.css.msu.ru/images/32x32/help.png"));
        menuHelp.getItems().add(miAbout);

        //установить обработчики
        miAbout.setOnAction(menuHandler);
        //Добавить меню Help в главное меню
        mbMainMenu.getMenus().add(menuHelp);

    }

    private void makeToolBar() {
        //Создать контейнер панели инструментов
        tbDebug = new ToolBar();

        //Создать кнопки панели инструментов
        Button btnSet = new Button("Set", new ImageView("http://icons.iconarchive.com/icons/icojam/blueberry-basic/32/check-64-icon.png"));
        btnSet.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        btnSet.setTooltip(new Tooltip("Set"));

        Button btnClear = new Button("Clear", new ImageView("https://www.shareicon.net/data/2016/01/28/266349_edit_32x32.png"));
        btnClear.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        btnClear.setTooltip(new Tooltip("Clear"));

        Button btnResume = new Button("Resume", new ImageView("http://www.lunolikaya.megomax.ru/assets/i/refresh.png"));
        btnResume.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        btnResume.setTooltip(new Tooltip("Resume"));

        //Установить обработчики кнопок панели инструментов
        EventHandler<ActionEvent> ehToolBarButtons = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lblInfo. setText(((Button)event.getTarget()).getText());
            }
        };

        btnSet.setOnAction(ehToolBarButtons);
        btnClear.setOnAction(ehToolBarButtons);
        btnResume.setOnAction(ehToolBarButtons);

        //Добавить кнопки панели в контейнер панели инструментов
        tbDebug.getItems().addAll(btnSet, btnClear, btnResume);

    }

    private void makeContextMenu() {
        //Создать контейнер контекстного меню
        cmEditMenu = new ContextMenu();
        //Создать элементы контекстного меню
        MenuItem cmCut = new MenuItem("Cut");
        MenuItem cmCopy = new MenuItem("Copy");
        MenuItem cmPaste = new MenuItem("Paste");

        //Установить обработчики элементов контекстного меню
        cmCut.setOnAction(menuHandler);
        cmCopy.setOnAction(menuHandler);
        cmPaste.setOnAction(menuHandler);

        //Добавить элементы в контекстное меню
        cmEditMenu.getItems().addAll(
                cmCut,
                cmCopy,
                cmPaste
        );
    }
}
