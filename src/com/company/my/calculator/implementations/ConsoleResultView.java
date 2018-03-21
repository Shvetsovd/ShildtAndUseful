package company.my.calculator.implementations;

import company.my.calculator.interfaces.ResultView;

/**
 * Created by user on 21.03.2018.
 */
public class ConsoleResultView extends ConsoleView implements ResultView {
    @Override
    public void show(String data) {
        super.show("Result: " + data + "\n");
    }
}
