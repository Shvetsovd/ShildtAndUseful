package company.useful.applet;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by OPER on 29.06.2017.
 */
public class ButtonDemo2 extends Applet implements ActionListener {
    String msg = "";
    Button buttons[] = new Button[3];

    @Override
    public void init() {
        Button yes = new Button("Yes");
        Button no = new Button("No");
        Button maybe = new Button("Maybe");

        buttons[0] = (Button) add(yes);
        buttons[1] = (Button) add(no);
        buttons[2] = (Button) add(maybe);

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(this);
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < buttons.length; i++) {
            if (e.getSource() == buttons[i]) {
                msg = "Вы нажали " + buttons[i].getLabel();
                repaint();
                break;
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 20, 20);
    }
}
