package company.myUseful.applet;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by OPER on 29.06.2017.
 */
public class ChoiceDemo extends Applet implements ItemListener {
    Choice os, browser;

    @Override
    public void init() {
        os = new Choice();
        browser = new Choice();

        os.add("Windows");
        os.add("Android");
        os.add("Solaris");
        os.add("MacOS");

        os.addItemListener(this);
        this.add(os);

        browser.add("Internet Explorer");
        browser.add("Chrome");
        browser.add("Opera");
        browser.add("Mozilla Firefox");

        browser.addItemListener(this);
        this.add(browser);

    }

    @Override
    public void paint(Graphics g) {
        g.drawString("OS: " + os.getSelectedItem(), 10, 100);
        g.drawString("Browser: " + browser.getSelectedItem(), 10, 120);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        repaint();
    }
}
