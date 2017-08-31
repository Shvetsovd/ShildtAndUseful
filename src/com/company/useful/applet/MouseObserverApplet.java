package company.useful.applet;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * Created by OPER on 28.06.2017.
 */
public class MouseObserverApplet extends Applet {
    String msg = "";
    int x = 0;
    int y = 0;

    @Override
    public void init() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                x = e.getX();
                y = e.getY();

                int clickCount = e.getClickCount();
                msg = clickCount + " Click";
                repaint();
            }


        });

        addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                showStatus("Mouse position > " + x + " : " + y);
                //repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, x, y);
    }
}
