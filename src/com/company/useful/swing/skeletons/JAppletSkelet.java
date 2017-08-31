package company.useful.swing.skeletons;

import javax.swing.*;
import java.awt.*;

/**
 * Created by OPER on 05.07.2017.
 */
public class JAppletSkelet extends JApplet {
    @Override
    public void init() {
        try {
            SwingUtilities.invokeAndWait(() -> makeGUI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void makeGUI() {
        this.setLayout(new FlowLayout());   //Set your layout here
        this.setSize(600, 400);             //Set frame size here

        //Create and add your GUI components here
    }
}
