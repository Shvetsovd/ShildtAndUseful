package company.my.calculator.interfaces;

/**
 * Created by user on 21.03.2018.
 */
public interface InputView extends View<String>{
    void addStatementInputListener(InputViewListener listener);
    void removeStatementInputListener(InputViewListener listener);
}
