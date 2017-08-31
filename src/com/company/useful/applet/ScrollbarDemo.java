package company.useful.applet;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by OPER on 29.06.2017.
 */
public class ScrollbarDemo extends Applet implements AdjustmentListener, MouseMotionListener {
    Scrollbar vSB, hSB;
    String msg = "";

    @Override
    public void init() {
        int width = this.getWidth();
        int height = this.getHeight();

        vSB = new Scrollbar(Scrollbar.VERTICAL, 0, 1, 0, height);
        vSB.setPreferredSize(new Dimension(20, 100));

        hSB = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, width);
        hSB.setPreferredSize(new Dimension(100, 20));

        vSB.addAdjustmentListener(this);
        hSB.addAdjustmentListener(this);

        this.addMouseMotionListener(this);

        this.add(vSB);
        this.add(hSB);
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        hSB.setValue(x);
        vSB.setValue(y);

        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void paint(Graphics g) {
        int x = hSB.getValue();
        int y = vSB.getValue();

        String msg = "Mouse position: " + x + "-" + y;
        this.showStatus(msg);

        g.drawLine(x, 0, x, this.getHeight());
        g.drawLine(0, y, this.getWidth(), y);
    }
}
