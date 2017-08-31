package company.useful.swing;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by user on 05.07.2017.
 */
class PaintPanel extends JPanel{
    Insets ins;
    Random r;

    public PaintPanel() {
        this.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        r = new Random();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x, y, x1, y1;

        int height = this.getHeight();
        int width = this.getWidth();

        ins = this.getInsets();

        for (int i = 0; i < 10; i++) {
            x = r.nextInt(width - ins.left);
            y = r.nextInt(height - ins.bottom);

            x1 = r.nextInt(width - ins.left);
            y1 = r.nextInt(height - ins.bottom);

            g.drawLine(x, y, x1, y1);
        }
    }
}
public class PaintDemo {
    JFrame jfrm;
    PaintPanel pp;


    public PaintDemo() {
        jfrm = new JFrame("Paint Demo");
        jfrm.setSize(200, 150);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pp = new PaintPanel();
        jfrm.add(pp);

        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new PaintDemo());
    }
}
