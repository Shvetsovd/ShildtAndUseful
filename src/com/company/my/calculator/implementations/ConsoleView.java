package company.my.calculator.implementations;


import company.my.calculator.interfaces.View;

import java.io.PrintStream;

/**
 * Created by user on 21.03.2018.
 */
public class ConsoleView implements View<String> {
    private final PrintStream out = System.out;

    @Override
    public void show(String data) {
        System.out.println(">" + data);
    }

    @Override
    public void hide() {

    }
}
