package company.myUseful.swing.components;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by OPER on 05.07.2017.
 */
public class JScrollPaneDemo extends JApplet {
    @Override
    public void init() {
        try {
            SwingUtilities.invokeAndWait(() -> makeGUI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void makeGUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(20, 20));

        int b = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                panel.add(new JButton("Button " + b));
                b++;
            }
        }
        JScrollPane sc = new JScrollPane(panel);

        this.add(sc, BorderLayout.CENTER);
    }
}
