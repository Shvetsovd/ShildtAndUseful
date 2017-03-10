//package company.shildt.chapter13;

import java.applet.Applet;
import java.awt.*;

/*
  <applet code = "SimpleApplet" width = "200" height = "400">
  </applet>
 */
public class SimpleApplet extends Applet {
    public void paint(Graphics g) {
        g.drawString("Простейший апплет", 20, 20);
    }
}
