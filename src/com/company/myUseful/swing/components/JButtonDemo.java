package company.myUseful.swing.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by OPER on 05.07.2017.
 */
public class JButtonDemo implements ActionListener {
    JFrame jfrm;

    JButton btnAndroid;
    ImageIcon iconForBtnAndroid = new ImageIcon(new URL("http://4.bp.blogspot.com/-tCMwa4xW7lc/VMK3vGHmXqI/AAAAAAAABpc/Lrswl9jiNa4/s1600/android4.png"));

    JButton btnIOS;
    ImageIcon iconForBtnIOS = new ImageIcon(new URL("http://www.iphone-mods.ru/wp-content/uploads/2016/12/121-300x218.png"));

    JLabel jl;

    public JButtonDemo() throws MalformedURLException {

        //Create the main frame
        jfrm = new JFrame("Swing Button Application");
        jfrm.setSize(400, 600);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set layout for main frame
        jfrm.setLayout(new FlowLayout());

        //Create the buttons and actions
        btnAndroid = new JButton(iconForBtnAndroid);
        btnAndroid.setActionCommand("Android");
        btnAndroid.addActionListener(this);

        btnIOS = new JButton(iconForBtnIOS);
        btnIOS.setActionCommand("iOS");
        btnIOS.addActionListener(this);

        //Add buttons to main frame
        this.jfrm.add(btnAndroid);
        this.jfrm.add(btnIOS);

        //Create and add the info label
        jl = new JLabel("Select the OS", JLabel.LEFT);
        jfrm.add(jl);

        jfrm.setVisible(true);

    }

    //Add ActionListener for Button press event
    @Override
    public void actionPerformed(ActionEvent e) {
        jl.setText("You choice: " + e.getActionCommand());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new JButtonDemo();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        });
    }
}
