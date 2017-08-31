package company.useful.applet;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by OPER on 29.06.2017.
 */
public class CheckBoxGroupDemo extends Applet implements ItemListener {
    Checkbox win, android, solaris, macos;
    CheckboxGroup osGrp;

    @Override
    public void init() {
        osGrp = new CheckboxGroup();
        win = new Checkbox("Windows", osGrp, true);
        android = new Checkbox("Android", osGrp, false);
        solaris = new Checkbox("Solaris", osGrp, false);
        macos = new Checkbox("MacOS", osGrp, false);

        win.addItemListener(this);
        android.addItemListener(this);
        solaris.addItemListener(this);
        macos.addItemListener(this);

        add(win);
        add(android);
        add(solaris);
        add(macos);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        String msg;
        msg = "Now active: " + osGrp.getSelectedCheckbox().getLabel();
        g.drawString(msg, 10, 100);
    }
}
