package company.useful.javafx.components;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by OPER on 10.07.2017.
 */
public class TextFieldWithPasswordDemo extends Application {
    Label lblInvite;
    TextField tfLogin;
    PasswordField psfPassword;
    Button btnOk;
    Separator separator;
    Label lblResultInfo;

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
        Scene scene = new Scene(rootNode, 280, 200);
        //Установить сцену
        primaryStage.setScene(scene);

        //-Создать элементы интерфейса-

        //Label приглащения
        lblInvite = new Label("Please, enter your login and password");

        //TextField для логина
        tfLogin = new TextField();
        tfLogin.setPrefColumnCount(20);
        tfLogin.setPromptText("Enter your login here");

        //PasswordField для пароля
        psfPassword = new PasswordField();
        psfPassword.setPrefColumnCount(20);
        psfPassword.setPromptText("Enter your password here");

        //Кнопка OK
        btnOk = new Button("Ok");

        //Separator
        separator = new Separator();
        separator.setPrefWidth(scene.getWidth());

        //Label, отображающий результаты ввода
        lblResultInfo = new Label("");

        //-Задать обработчики событий интерфейса-
        //Добавим обработчик на нажатие клавиши Enter в текстовых полях
        tfLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showUserData();
            }
        });
        psfPassword.setOnAction((e) -> showUserData());

        //Обработчик нажатия на клавишу OK
        btnOk.setOnAction((e) -> showUserData());


        //-Добавить элементы интерфейса к корневому узлу-
        rootNode.getChildren().addAll(lblInvite, tfLogin, psfPassword, btnOk, separator, lblResultInfo);
        //-Показать подмостки-
        primaryStage.show();
    }

    private void showUserData() {
        lblResultInfo.setText("Your entered: " + tfLogin.getText() + "/" + psfPassword.getText());
    }
}
