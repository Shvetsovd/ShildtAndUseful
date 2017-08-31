package company.useful.callbackExample;

/**
 * Created by dmitry on 22.01.17.
 */
public class Button {

    interface ICallback {
        void onButtonClick();
        void onMouseOver();
    }

    ICallback callback;

    public void registerCallback(ICallback callback){
        this.callback = callback;
    }

    void click(){
        System.out.println("Button  -->  Внутри метода click() класса Button: вы нажали кнопку");
        callback.onButtonClick();
    }
    void mouseOver(){
        System.out.println("Button  -->  Внутри метода mouseOver() класса Button: вы нажали кнопку");
        callback.onMouseOver();;
    }
}
