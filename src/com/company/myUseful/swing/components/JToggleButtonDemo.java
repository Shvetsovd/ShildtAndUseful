package company.myUseful.swing.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by OPER on 05.07.2017.
 */
public class JToggleButtonDemo extends JApplet {
    JToggleButton jtbtn;
    JLabel jl;

    @Override
    public void init() {
        try {
            SwingUtilities.invokeAndWait(() -> makeGUI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void makeGUI() {
        this.setLayout(new FlowLayout());
        jtbtn = new JToggleButton("On / Off");
        jtbtn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (jtbtn.isSelected()){
                    jl.setText("Button is on");
                } else {
                    jl.setText("Button is off");
                }
            }
        });


        jl = new JLabel("Button is off");

        this.add(jtbtn);
        this.add(jl);
    }
}
