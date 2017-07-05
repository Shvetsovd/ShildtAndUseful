package company.myUseful.swing.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by OPER on 05.07.2017.
 */
public class JComboBoxDemo extends JApplet {
    JComboBox<String> jcb;
    JLabel jl;
    ImageIcon imgAndroid, imgIOS, imgWin, imgLinux;

    String osNames[] = {"Android", "iOS", "Windows", "Linux"};

    @Override
    public void init() {
        try {
            SwingUtilities.invokeAndWait(() -> makeGUI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void makeGUI() {
        //Load the images
        try {
            imgAndroid = new ImageIcon(new URL("http://4.bp.blogspot.com/-tCMwa4xW7lc/VMK3vGHmXqI/AAAAAAAABpc/Lrswl9jiNa4/s1600/android4.png"));
            imgIOS = new ImageIcon(new URL("http://www.ru.w3eacademy.com/ios/images/ios-logo.png"));
            imgWin = new ImageIcon(new URL("http://www.cischool.ru/wp-content/uploads/2016/11/win7-www-e1479978033472.png"));
            imgLinux = new ImageIcon(new URL("http://clansites.net/wp-content/uploads/2013/05/Tux-271x300.png"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        this.setLayout(new FlowLayout());

        jcb = new JComboBox<>(osNames);
        this.add(jcb);

        jcb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String choice = (String) jcb.getSelectedItem();
                switch (choice){
                    case "Android":
                        jl.setIcon(imgAndroid);
                        break;
                    case "iOS":
                        jl.setIcon(imgIOS);
                        break;
                    case "Windows":
                        jl.setIcon(imgWin);
                        break;
                    case "Linux":
                        jl.setIcon(imgLinux);
                        break;

                }
            }
        });

        jl = new JLabel(imgAndroid);
        this.add(jl);


    }
}
