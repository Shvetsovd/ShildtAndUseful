package company.myUseful.javafx.skeletons;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by OPER on 07.07.2017.
 */
public class JavaFXSkeletonFull extends Application {

    public static void main(String[] args) {
        //Launch javaFX application
        Application.launch(args);
    }


    /**
     * Init method use for initialization of user JavaFX class
     * This method is executing in main thread,
     * so you can't create stages, scenes and etc here
     * You can use (override) or ignore this method
     */
    @Override
    public void init() throws Exception {
        //System.out.println("init()...");

        super.init();
    }

    /**
     * Start method is a point for execute application in JavaFX Application Thread
     * Must be override in any JavaFX application
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        //System.out.println("start()...");

        //Title for application windows
        primaryStage.setTitle("JavaFX Skeleton");

        //Create root panel with flow components layout
        FlowPane rootNode = new FlowPane();

        //Create the scene on pane and set scene dimensions
        Scene scene = new Scene(rootNode, 300, 200);

        //Set the scene on stage
        primaryStage.setScene(scene);

        //Show the stage with its components
        primaryStage.show();
    }

    /**
     * Stop method will execute before terminating javaFX application
     * You can release some resourses here
     * You can use (override) or ignore this method
     */
    @Override
    public void stop() throws Exception {
        //System.out.println("stop()...");
        super.stop();
    }
}
