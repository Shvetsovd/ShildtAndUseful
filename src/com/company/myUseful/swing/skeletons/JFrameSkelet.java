package company.myUseful.swing.skeletons;

import javax.swing.*;
import java.awt.*;

/**
 * Created by OPER on 05.07.2017.
 */
public class JFrameSkelet {
    //GUI component fields
    private JFrame frame;


    public JFrameSkelet() {

        //Create the main frame of application
        frame = new JFrame("Title");        //set the frame title here
        frame.setSize(600, 400);            //set the frame size here
        frame.setLayout(new FlowLayout());  //set your layout here
        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );


        //add you GUI component on frame here

        //Show the main frame
        frame.setVisible(true);
    }


    public static void main(String[] args) {

        //Run Swing application
        SwingUtilities.invokeLater(JFrameSkelet::new);
    }

}
