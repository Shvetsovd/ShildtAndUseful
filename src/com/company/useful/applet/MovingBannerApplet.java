package company.useful.applet;

import java.applet.Applet;
import java.awt.*;

/*
 <applet code = "MovingBannerApplet" width = 100 height = 100>
 </applet>
*/
public class MovingBannerApplet extends Applet {
    String msg = "Moving bannerText ";
    volatile boolean stopFlag = false;
    Thread t = null;

    @Override
    public void init() {
        setBackground(Color.black);
        setBackground(Color.WHITE);
    }

    @Override
    public void start() {
        stopFlag = false;
        t = new Thread(() -> {
            while (true) {
                try {
                    repaint();
                    Thread.sleep(250);

                    if (stopFlag) {
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    @Override
    public void paint(Graphics g) {
        char c = msg.charAt(0);
        msg = msg.substring(1, msg.length());
        msg += c;
        g.drawString(msg, 50, 50);
    }

    @Override
    public void stop() {
        stopFlag = true;
        t = null;
    }
}
