package company.my.calculator.implementations;

import company.my.calculator.exceptions.StatementExecuteException;
import company.my.calculator.interfaces.*;

/**
 * Created by user on 21.03.2018.
 */
public class DefaultController implements Controller {
    private InputView inputView;
    private ResultView resultView;
    private ErrorView errorView;

    private Model model;

    public DefaultController(InputView inputView,
                             ResultView resultView,
                             ErrorView errorView,
                             Model model) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.errorView = errorView;
        this.model = model;

        inputView.addStatementInputListener((s) -> {
            try {
                double result = model.calculate(s);
                resultView.show(String.format("%.2f", result));
            } catch (StatementExecuteException e) {
                errorView.show(e.getMessage());
            }
            inputView.show(null);
        });
    }

    @Override
    public void start() {
        inputView.show(null);
    }
}
