package company.my.calculator;

import company.my.calculator.implementations.*;
import company.my.calculator.interfaces.Controller;

/**
 * Created by user on 21.03.2018.
 */
public class Calculator {
    private Controller controller;

    private Calculator(Controller controller) {
        this.controller = controller;
    }

    public static Calculator getConsoleCalculator(){
        return new Calculator(
                new DefaultController(
                        new ConsoleInputView(),
                        new ConsoleResultView(),
                        new ConsoleErrorView(),
                        new SimpleStatementModel()
                ));
    }
    public void start() {
        controller.start();
    }

}
