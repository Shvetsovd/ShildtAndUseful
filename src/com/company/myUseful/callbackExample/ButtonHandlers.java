package company.myUseful.callbackExample;

/**
 * Created by dmitry on 22.01.17.
 */
public class ButtonHandlers implements Button.ICallback{

    @Override
    public void onButtonClick() {
        System.out.println("ButtonHandlers  -->  Вызов обработчика onButtonClick()\n");
    }

    @Override
    public void onMouseOver() {
        System.out.println("ButtonHandlers  -->  Вызов обработчика onMouseOver()\n");
    }
}
