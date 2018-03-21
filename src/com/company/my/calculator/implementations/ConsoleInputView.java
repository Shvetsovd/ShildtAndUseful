package company.my.calculator.implementations;

import company.my.calculator.interfaces.InputView;
import company.my.calculator.interfaces.InputViewListener;

import java.io.BufferedReader;
import java.io.Console;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by user on 21.03.2018.
 */
public class ConsoleInputView extends ConsoleView implements InputView {
    private List<InputViewListener> inputListeners;

    public ConsoleInputView() {
        inputListeners = new LinkedList<>();
    }

    @Override
    public void show(String data) {
        super.show("Input statement for calculate:");
        Scanner in = new Scanner(System.in);
        String inputLine = in.nextLine();
        if (inputLine.trim().toLowerCase().equals("exit")){
            System.exit(0);
        }
        signalInputListeners(inputLine);
    }

    private void signalInputListeners(String statement) {
        for (InputViewListener listener : inputListeners){
            listener.apply(statement);
        }
    }

    @Override
    public void addStatementInputListener(InputViewListener listener) {
        inputListeners.add(listener);
    }

    @Override
    public void removeStatementInputListener(InputViewListener listener) {
        inputListeners.remove(listener);
    }
}
