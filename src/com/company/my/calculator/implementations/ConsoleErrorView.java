package company.my.calculator.implementations;

import company.my.calculator.interfaces.ErrorView;

/**
 * Created by user on 21.03.2018.
 */
public class ConsoleErrorView extends ConsoleView implements ErrorView {
    @Override
    public void show(String data) {
        super.show("Error: " + data + "\n");
    }
}
