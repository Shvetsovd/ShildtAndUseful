package company.myUseful.swing.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by OPER on 05.07.2017.
 */
public class JCheckBoxDemo extends JApplet implements ItemListener{
    JLabel jl;

    @Override
    public void init() {
        try {
            SwingUtilities.invokeAndWait(() -> makeGui());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void makeGui() {
        this.setLayout(new FlowLayout());

        JCheckBox cb = new JCheckBox("C");
        cb.addItemListener(this);
        this.add(cb);

        cb = new JCheckBox("C++");
        cb.addItemListener(this);
        this.add(cb);

        cb = new JCheckBox("Java");
        cb.addItemListener(this);
        this.add(cb);

        cb = new JCheckBox("Perl");
        cb.addItemListener(this);
        this.add(cb);

        jl = new JLabel("Select languages");
        this.add(jl);

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JCheckBox cb = (JCheckBox)e.getItem();

        if (cb.isSelected()){
            jl.setText(cb.getText() + " is selected");
        } else {
            jl.setText(cb.getText() + " is cleared");
        }
    }
}
