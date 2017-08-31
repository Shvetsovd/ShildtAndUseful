package company.useful.swing.components;

import javax.swing.*;
import java.awt.*;

/**
 * Created by OPER on 05.07.2017.
 */
public class JTabbedPaneDemo {
    JFrame frame;
    JTabbedPane jtp;

    public JTabbedPaneDemo() {
        frame = new JFrame("Tabs");
        frame.setLayout(new FlowLayout());
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jtp = new JTabbedPane();
        jtp.addTab("Cities", new CitiesPanel());
        jtp.addTab("Colors", new ColorsPanel());
        jtp.addTab("Flavours", new FlovourPanel());

        frame.add(jtp);

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JTabbedPaneDemo());
    }
}

class CitiesPanel extends JPanel {
    public CitiesPanel() {
        JButton b1 = new JButton("New York");
        this.add(b1);

        JButton b2 = new JButton("Moscow");
        this.add(b2);

        JButton b3 = new JButton("Lipetsk");
        this.add(b3);
    }
}

class ColorsPanel extends JPanel {
    public ColorsPanel() {
        JCheckBox c1 = new JCheckBox("Red");
        this.add(c1);

        JCheckBox c2 = new JCheckBox("Green");
        this.add(c2);

        JCheckBox c3 = new JCheckBox("Blue");
        this.add(c3);
    }
}

class FlovourPanel extends JPanel {
    public FlovourPanel() {
        JComboBox<String> jc = new JComboBox<>();
        jc.addItem("Vanilla");
        jc.addItem("Chocolate");
        jc.addItem("Strawberry");

        this.add(jc);
    }
}
