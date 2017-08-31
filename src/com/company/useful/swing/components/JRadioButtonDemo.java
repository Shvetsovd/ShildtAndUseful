package company.useful.swing.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by OPER on 05.07.2017.
 */
public class JRadioButtonDemo implements ActionListener {
    JFrame jframe;
    JLabel jl;

    public JRadioButtonDemo() {
        jframe = new JFrame("JRadioButtonDemo");
        jframe.setLayout(new FlowLayout());
        jframe.setSize(600, 400);

        JRadioButton b1 = new JRadioButton("A");
        b1.addActionListener(this);
        jframe.add(b1);

        JRadioButton b2 = new JRadioButton("B");
        b2.addActionListener(this);
        jframe.add(b2);

        JRadioButton b3 = new JRadioButton("C");
        b3.addActionListener(this);
        jframe.add(b3);

        ButtonGroup bg = new ButtonGroup();
        bg.add(b1);
        bg.add(b2);
        bg.add(b3);

        jl = new JLabel("Select one");
        jframe.add(jl);

        jframe.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jl.setText("You selected: " + e.getActionCommand());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JRadioButtonDemo());
    }
}
