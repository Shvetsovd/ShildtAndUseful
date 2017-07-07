package company.myUseful.javafx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * Created by OPER on 07.07.2017.
 */
public class WebBrowserDemo extends Application {
    private Scene scene;
    private BorderPane root;

    private Button btnBack, btnGo, btnMenu;
    private TextField tfURL;
    private WebView webView;

    private Separator separator;
    private ProgressBar loadProgress;
    /*private int btnBackRotateAngle;*/


    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Set the scene and root pane
        primaryStage.setTitle("Simple JavaFX Web Browser");

        root = new BorderPane();
        root.setPadding(new Insets(5, 0, 0, 0));

        scene = new Scene(root, 1024, 768);
        primaryStage.setScene(scene);

        //Make GUI components and set on root pane
        makeGUI(primaryStage, scene, root);

        //Show main window
        primaryStage.show();
    }

    private void makeGUI(Stage primaryStage, Scene scene, BorderPane root) {
        //Create components---!

        //Create web view
        webView = new WebView();
        webView.setEffect(new InnerShadow(5, Color.BLACK));
        webView.getEngine().load("https://ya.ru/");

        //Create a progress bar for loading page
        loadProgress = new ProgressBar();
        loadProgress.setPrefWidth(scene.getWidth());
        //loadProgress.setEffect(new Reflection(0.0, 0.2, 0.5, 0.0));
        loadProgress.progressProperty().bind(webView.getEngine().getLoadWorker().progressProperty());

        //Create text field for url address
        tfURL = new TextField();
        tfURL.setEditable(true);
        tfURL.setEffect(new Glow(0.3));
        tfURL.setPromptText("Enter URL here");
        tfURL.setPrefWidth(0.83 * scene.getWidth());

        //Create button "Back"
        btnBack = new Button("Back", new ImageView("http://www.miankoutu.com/uploadfiles/2015-9-24/201592483215539.png"));
        btnBack.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        //Add some effects
        btnBack.setEffect(new Reflection(0.0, 0.7, 0.5, 0.0));
       /* Rotate btnBackRotate = new Rotate();
        btnBackRotateAngle = 0;
        btnBack.getTransforms().add(btnBackRotate);*/

        //Create button "Go"
        btnGo = new Button("Go", new ImageView("http://www.parabola.cz/img_menu/prihlasit-se.png"));
        btnGo.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        btnGo.setEffect(new Reflection(0.0, 0.7, 0.5, 0.0));

        //Create button "Menu"
        btnMenu = new Button("Menu", new ImageView("https://cms.unov.org/UNTERM/Content/options_2.png"));
        btnMenu.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        btnMenu.setEffect(new Reflection(0.0, 0.7, 0.5, 0.0));

        //Create separator
        separator = new Separator();
        separator.setPrefWidth(0.5 * scene.getWidth());

        //Add event handlers---!
        //Back button click
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                WebHistory history = webView.getEngine().getHistory();

                int currentIndex = history.getCurrentIndex();
                if (currentIndex > 0) {
                    WebHistory.Entry previousEntry = history.getEntries().get(currentIndex - 1);
                    webView.getEngine().load(previousEntry.getUrl());
                    history.go(-1);


                }
                /*btnBackRotateAngle += 90;
                btnBackRotate.setAngle(btnBackRotateAngle);
                btnBackRotate.setPivotX(btnBack.getWidth() / 2);
                btnBackRotate.setPivotY(btnBack.getHeight() / 2);*/
            }
        });

        //Go button click
        btnGo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                webView.getEngine().load(tfURL.getText());
            }
        });

        //Address field Enter down
        tfURL.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tfURL.selectAll();
            }
        });
        tfURL.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    String url = tfURL.getText();
                    if (!url.startsWith("http")) {
                        url = "https://" + url;
                    }
                    webView.getEngine().load(url);
                }
            }
        });

        //Add handle on web view actions (set address on address field)
        webView.getEngine().setOnStatusChanged(new EventHandler<WebEvent<String>>() {
            @Override
            public void handle(WebEvent<String> event) {
                tfURL.setText(webView.getEngine().getLocation());
            }
        });

        //Resize window event
        scene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                tfURL.setPrefWidth(0.83 * scene.getWidth());
                separator.setPrefWidth(0.5 * scene.getWidth());
                webView.setPrefWidth(scene.getHeight());
                webView.setPrefHeight(scene.getHeight());
                loadProgress.setPrefWidth(scene.getWidth());

            }
        });

        //Add elements on root pane---!
        //Top
        FlowPane topPane = new FlowPane(10, 10);
        topPane.getChildren().addAll(btnBack, tfURL, btnGo, btnMenu, separator);
        topPane.setAlignment(Pos.CENTER);
        root.setTop(topPane);
        //Center
        root.setCenter(webView);
        //Bottom
        root.setBottom(loadProgress);

    }
}
