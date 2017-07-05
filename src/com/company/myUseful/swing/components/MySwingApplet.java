package company.myUseful.swing.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by user on 05.07.2017.
 */
public class MySwingApplet extends JApplet {
    JButton jbtnAlpha;
    JButton jbtnBeta;
    JLabel jlab;

    @Override
    public void init() {
        try {
            SwingUtilities.invokeAndWait(() -> makeGUI());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    private void makeGUI() {
        setLayout(new FlowLayout());

        jbtnAlpha = new JButton("Alpha");
        jbtnBeta = new JButton("Beta");

        jbtnAlpha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlab.setText("Alpha was pressed");
            }
        });

        jbtnBeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlab.setText("Beta was pressed");
            }
        });

        jlab = new JLabel("Press a button");

        this.add(jbtnAlpha);
        this.add(jbtnBeta);
        this.add(jlab);
    }
}
