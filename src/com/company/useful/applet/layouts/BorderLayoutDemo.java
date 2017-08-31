package company.useful.applet.layouts;

import java.applet.Applet;
import java.awt.*;

/**
 * Created by OPER on 29.06.2017.
 */
public class BorderLayoutDemo extends Applet {
    Button btnLeft, btnRight, btnTop, btnSouth;
    TextArea areaCenter;

    @Override
    public void init() {
        this.setLayout(new BorderLayout());

        btnLeft = new Button("Left");
        btnRight = new Button("Right");
        btnTop = new Button("Top");
        btnSouth = new Button("South");
        areaCenter = new TextArea(15,30);

        this.add(btnLeft, BorderLayout.WEST);
        this.add(btnRight, BorderLayout.EAST);
        this.add(btnTop, BorderLayout.NORTH);
        this.add(btnSouth, BorderLayout.SOUTH);
        this.add(areaCenter, BorderLayout.CENTER);
    }
}
