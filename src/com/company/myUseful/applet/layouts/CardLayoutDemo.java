package company.myUseful.applet.layouts;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by OPER on 29.06.2017.
 */
public class CardLayoutDemo extends Applet implements ActionListener {
    CardLayout cardLO;
    Panel osCardsContainer;
    Button win, other;
    Checkbox winXP, win7, win8, android, solaris, mac;

    @Override
    public void init() {
        win = new Button("Windows");
        other = new Button("Other");
        win.addActionListener(this);
        other.addActionListener(this);
        this.add(win);
        this.add(other);

        cardLO = new CardLayout();
        osCardsContainer = new Panel(cardLO);


        winXP = new Checkbox("Windows XP");
        win7 = new Checkbox("Windows 7");
        win8 = new Checkbox("Windows 8");
        android = new Checkbox("Android");
        solaris = new Checkbox("Solaris");
        mac = new Checkbox("MacOS");

        Panel winPanel = new Panel();
        winPanel.add(winXP);
        winPanel.add(win7);
        winPanel.add(win8);

        Panel otherOSPanel = new Panel();
        otherOSPanel.add(android);
        otherOSPanel.add(solaris);
        otherOSPanel.add(mac);

        osCardsContainer.add(winPanel, "Windows");
        osCardsContainer.add(otherOSPanel, "Other");

        this.add(osCardsContainer);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(win)){
            cardLO.show(osCardsContainer, "Windows");
        }
        if (e.getSource().equals(other)){
            cardLO.show(osCardsContainer, "Other");
        }
    }
}
