package company.myUseful.applet;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by OPER on 29.06.2017.
 */
public class ListChoiceDemo extends Applet implements ActionListener {
    List os, browser;
    String msg = "";

    @Override
    public void init() {
        os = new List(4, true);
        browser = new List(4, false);

        os.add("Windows");
        os.add("Android");
        os.add("Solaris");
        os.add("MacOS");

        os.addActionListener(this);
        this.add(os);

        browser.add("Internet Explorer");
        browser.add("Chrome");
        browser.add("Opera");
        browser.add("Mozilla Firefox");
        browser.select(1);

        browser.addActionListener(this);
        this.add(browser);
    }

    @Override
    public void paint(Graphics g) {
        msg = "Selected OS: ";
        int indx[] = os.getSelectedIndexes();
        for (int i = 0; i < indx.length; i++) {
            msg += os.getItem(indx[i]) + " ";
        }
        g.drawString(msg, 10, 100);

        msg = "Selected browser: ";
        msg += browser.getSelectedItem();
        g.drawString(msg, 10, 120);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
