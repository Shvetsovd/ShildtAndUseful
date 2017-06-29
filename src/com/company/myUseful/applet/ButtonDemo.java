package company.myUseful.applet;

import company.myUseful.callbackExample.*;

import java.applet.Applet;
import java.awt.*;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by OPER on 29.06.2017.
 */
public class ButtonDemo extends Applet implements ActionListener {
    String msg = "";
    Button yes, no, maybe;

    @Override
    public void init() {
        yes = new Button("Yes");
        no = new Button("No");
        maybe = new Button("Maybe");

        yes.addActionListener(this);
        no.addActionListener(this);
        maybe.addActionListener(this);

        add(yes);
        add(no);
        add(maybe);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msgBtn = e.getActionCommand();
        msg = "Вы нажали " + msgBtn;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 20, 20);
    }
}
