package company.useful.video;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

// "https://www.youtube.com/embed/EOQ0ZY8h1RE"

public class VideoPlayer extends Application {
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws Exception {
        WebView webview = new WebView();
        webview.getEngine().load(
                "https://www.youtube.com/embed/EOQ0ZY8h1RE"
        );

        webview.setPrefSize(640, 390);

        stage.setScene(new Scene(webview));
        stage.setTitle("Video");
        stage.show();
    }
}
