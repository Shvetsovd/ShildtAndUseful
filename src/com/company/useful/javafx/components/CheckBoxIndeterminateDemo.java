package company.useful.javafx.components;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by OPER on 10.07.2017.
 */
public class CheckBoxIndeterminateDemo extends Application {
    Label lblHeader;
    Separator separator;
    CheckBox chbWeb, chbDesktop, chbMobile;
    Label lblLastActionInfo;
    Label lblSelectedCheckBoxes;

    public static void main(String[] args) {
        //Запустить приложение
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //-Задать заголовок-
        primaryStage.setTitle("CheckBox Demo");
        //-Создать и установить сцену-
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rootNode, 230, 180);
        primaryStage.setScene(scene);

        //-Создать элементы-
        //Создать Label-заголовок
        lblHeader = new Label("Select Deployment Options");
        //Создать сепаратор
        separator = new Separator(Orientation.HORIZONTAL);
        separator.setPrefWidth(scene.getWidth());

        //Создать CheckBoxes
        chbWeb = new CheckBox("Web");
        //Разрешить неопределенное состояние флажка
        chbWeb.setIndeterminate(true);

        chbDesktop = new CheckBox("Desktop");
        //Разрешить неопределенное состояние флажка
        chbDesktop.setIndeterminate(true);

        chbMobile = new CheckBox("Mobile");
        //Разрешить неопределенное состояние флажка
        chbMobile.setIndeterminate(true);

        //Создать Label, информирующий о последнем действии с Check Boxes
        lblLastActionInfo = new Label("No Deployment Selected");

        //Создать Label, содержащий список всех выбранных ChexkBox
        lblSelectedCheckBoxes = new Label("Target list: <none>");

        //-Добавить обработчики событий для элементов-
        chbWeb.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (chbWeb.isIndeterminate()) {
                    lblLastActionInfo.setText("Web Deployment Indeterminate");
                } else if (chbWeb.isSelected()) {
                    lblLastActionInfo.setText("Web Deployment Selected");
                } else {
                    lblLastActionInfo.setText("Web Deployment Cleared");
                }
                lblSelectedCheckBoxes.setText("Target List: "
                        + getSelectedCheckBoxesInfo());
            }
        });
        chbDesktop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (chbDesktop.isIndeterminate()) {
                    lblLastActionInfo.setText("Desktop Deployment Indeterminate");
                } else if (chbDesktop.isSelected()) {
                    lblLastActionInfo.setText("Desktop Deployment Selected");
                } else {
                    lblLastActionInfo.setText("Desktop Deployment Cleared");
                }
                lblSelectedCheckBoxes.setText("Target List: "
                        + getSelectedCheckBoxesInfo());
            }
        });

        chbMobile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (chbMobile.isIndeterminate()){
                    lblLastActionInfo.setText("Mobile Deployment Indeterminate");
                }else
                if (chbMobile.isSelected()) {
                    lblLastActionInfo.setText("Mobile Deployment Selected");
                } else {
                    lblLastActionInfo.setText("Mobile Deployment Cleared");
                }
                lblSelectedCheckBoxes.setText("Target List: "
                        + getSelectedCheckBoxesInfo());
            }
        });


        //-Добавить элементы к корневому узлу-
        rootNode.getChildren().addAll(
                lblHeader,
                separator,
                chbWeb,
                chbDesktop,
                chbMobile,
                lblLastActionInfo,
                lblSelectedCheckBoxes
        );

        //-Показать подмостки-
        primaryStage.show();
    }

    //Метод
    private String getSelectedCheckBoxesInfo() {
        String result = "";
        if (chbWeb.isSelected()) {
            result += chbWeb.getText() + " ";
        }
        if (chbDesktop.isSelected()) {
            result += chbDesktop.getText() + " ";
        }
        if (chbMobile.isSelected()) {
            result += chbMobile.getText();
        }

        if (result.equals("")) {
            return "<none>";
        }
        return result;
    }
}
