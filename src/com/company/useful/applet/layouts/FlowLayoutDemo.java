package company.useful.applet.layouts;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by OPER on 29.06.2017.
 */
public class FlowLayoutDemo extends Applet implements ItemListener {
    Checkbox win, android, solaris, mac;

    @Override
    public void init() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        win = new Checkbox("Windows");
        android = new Checkbox("Android");
        solaris = new Checkbox("Solaris");
        mac = new Checkbox("Mac");

        win.addItemListener(this);
        android.addItemListener(this);
        solaris.addItemListener(this);
        mac.addItemListener(this);

        this.add(win);
        this.add(android);
        this.add(solaris);
        this.add(mac);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawString("Windows: " + win.getState(), 10, 100);
        g.drawString("Android: " + android.getState(), 10, 120);
        g.drawString("Solaris: " + solaris.getState(), 10, 140);
        g.drawString("MacOS: " + mac.getState(), 10, 160);
    }
}
