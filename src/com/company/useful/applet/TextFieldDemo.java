package company.useful.applet;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by OPER on 29.06.2017.
 */
public class TextFieldDemo extends Applet implements ActionListener {
    TextField nameField, passField;
    Label nameLabel, passLabel;

    @Override
    public void init() {
        nameLabel = new Label("Name", Label.RIGHT);
        passLabel = new Label("Password", Label.RIGHT);

        nameField = new TextField(20);
        passField = new TextField(20);
        passField.setEchoChar('*');

        nameField.addActionListener(this);
        passField.addActionListener(this);

        this.add(nameLabel);
        this.add(nameField);
        this.add(passLabel);
        this.add(passField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        String msg = "";
        msg = "Name: " + nameField.getText();
        g.drawString(msg, 10, 100);

        msg = "Selected: " + nameField.getSelectedText();
        g.drawString(msg, 10, 120);

        msg = "Password: " + passField.getText();
        g.drawString(msg, 10, 160);

        msg = "Selected: " + passField.getSelectedText();
        g.drawString(msg, 10, 180);
    }
}
