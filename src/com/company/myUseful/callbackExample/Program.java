package company.myUseful.callbackExample;

/**
 * Created by dmitry on 22.01.17.
 */
public class Program {
    public static void main(String[] args) {

        Button button = new Button();
        ButtonHandlers handlers = new ButtonHandlers();

        button.registerCallback(handlers);

        button.click();
        button.mouseOver();

    }



}
