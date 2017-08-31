package company.useful.swing.components;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * Created by OPER on 05.07.2017.
 */
public class JListDemo extends JApplet {
    JList<String> jlist;
    JScrollPane jspForJList;
    JLabel jl;

    String cities[] = {"Moscow", "St.Peterburg", "Lipetsk",
            "Voronexh", "Tula", "Ryazan",
            "Samara", "Sochi", "Smolensk"};


    @Override
    public void init() {
        try {
            SwingUtilities.invokeAndWait(() -> makeGUI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void makeGUI() {
        this.setLayout(new FlowLayout());
        jlist = new JList<>(cities);
        jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jspForJList = new JScrollPane(jlist);
        jspForJList.setPreferredSize(new Dimension(120, 90));

        jl = new JLabel("Select the city");

        jlist.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int idx = jlist.getSelectedIndex();
                if (idx != -1){
                    jl.setText("Current Selection: " + cities[idx]);
                } else {
                    jl.setText("Select the city");
                }
            }
        });

        this.add(jspForJList);
        this.add(jl);

    }
}
