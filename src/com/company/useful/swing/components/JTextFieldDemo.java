package company.useful.swing.components;

import javax.swing.*;
import java.awt.*;

/**
 * Created by OPER on 05.07.2017.
 */
public class JTextFieldDemo extends JApplet {
    JTextField jtf;
    @Override
    public void init() {
        try {
            SwingUtilities.invokeAndWait(() -> makeGUI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void makeGUI() {

        //Установим диспетчер компоновки
        this.setLayout(new FlowLayout());

        //создать текстовое поле
        jtf = new JTextField(15);

        //Добавить обработчик нажатия на Enter
        jtf.addActionListener(e -> showStatus(jtf.getText()));

        //Добавить текстовое поле на окно
        this.add(jtf);

    }
}
