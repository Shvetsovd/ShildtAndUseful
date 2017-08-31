package company.useful.applet.layouts;

import java.applet.Applet;
import java.awt.*;

/**
 * Created by OPER on 29.06.2017.
 */
public class GridLayoutDemo extends Applet {
    private static final int n = 4;

    @Override
    public void init() {
        this.setLayout(new GridLayout(4, 4));
        this.setFont(new Font("SansSerif", Font.BOLD, 24));

        for (int i = 0; i < n * n; i++) {
            this.add(new Button("" + (i + 1)));
        }
    }
}
