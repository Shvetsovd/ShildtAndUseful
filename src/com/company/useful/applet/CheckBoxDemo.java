package company.useful.applet;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by OPER on 29.06.2017.
 */
public class CheckBoxDemo extends Applet implements ItemListener {
    Checkbox win, android, solaris, macos;

    @Override
    public void init() {
        win = new Checkbox("Windows", null, true);
        win.addItemListener(this);
        add(win);

        android = new Checkbox("Android");
        android.addItemListener(this);
        add(android);

        solaris = new Checkbox("Solaris");
        solaris.addItemListener(this);
        add(solaris);

        macos = new Checkbox("MacOS");
        macos.addItemListener(this);
        add(macos);

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawString("Current state: ", 6, 80);
        g.drawString("Windows: " + win.getState(), 6, 100);
        g.drawString("Android: " + android.getState(), 6, 120);
        g.drawString("Solaris: " + solaris.getState(), 6, 140);
        g.drawString("MacOS: " + macos.getState(), 6, 160);
    }
}
