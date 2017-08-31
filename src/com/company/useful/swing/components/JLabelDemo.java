package company.useful.swing.components;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by OPER on 05.07.2017.
 */
public class JLabelDemo extends JApplet {
    String imageURLPath = "http://www.bbbpics.com/resize/resize-img.php?src=http://img.bbbpics.com/images/Music/street-music-girl-headphones5570.jpg&h=380&w=596";

    @Override
    public void init() {
        try {
            SwingUtilities.invokeAndWait(() -> makeGUI());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    void makeGUI() {
        ImageIcon ii = null;
        try {
            ii = new ImageIcon(new URL(imageURLPath));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        JLabel jl = new JLabel("Picture from Internet", ii, JLabel.CENTER);
        this.add(jl);
    }

}
