package company.useful.swing.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by OPER on 06.07.2017.
 */
public class MainMenuWithIconsAndTooltips implements ActionListener {
    JFrame frame;
    JMenuBar menuBar;
    JLabel jlabel;


    public MainMenuWithIconsAndTooltips() throws MalformedURLException {
        //Создать и настроить главное окно
        frame = new JFrame("Main Menu Demo");
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Добавить информационный лейбл для отображение выбранного пункта меню
        jlabel = new JLabel();
        frame.add(jlabel);

        //Создать главное меню и добавить на окно
        makeMainMenu();

        //Показать окно пользователю
        frame.setVisible(true);
    }

    private void makeMainMenu() throws MalformedURLException {

        //Создать контейнер главного меню
        menuBar = new JMenuBar();

        //Создание отдельных подменю и добавление их в контейнер
        //File...
        JMenu jmFile = new JMenu("File");

        JMenuItem jmiOpen = new JMenuItem("Open");
        JMenuItem jmiSave = new JMenuItem("Save");
        JMenuItem jmiClose = new JMenuItem("Close");
        JMenuItem jmiExit = new JMenuItem("Exit");

        jmFile.add(jmiOpen);
        jmFile.add(jmiSave);
        jmFile.add(jmiClose);
        jmFile.addSeparator();
        jmFile.add(jmiExit);
        //Добавляем меню File  в главное меню
        menuBar.add(jmFile);

        //Options...
        JMenu jmOptions = new JMenu("Options");
        //Подменю Colors
        JMenu jmColors = new JMenu("Colors");
        JMenuItem jmiRed = new JMenuItem("Red");
        JMenuItem jmiGreen = new JMenuItem("Green");
        JMenuItem jmiBlue = new JMenuItem("Blue");
        jmColors.add(jmiRed);
        jmColors.add(jmiGreen);
        jmColors.add(jmiBlue);
        jmOptions.add(jmColors);

        //Подменю Priority
        JMenu jmPriority = new JMenu("Priority");
        JMenuItem jmiHigh = new JMenuItem("High");
        JMenuItem jmiLow = new JMenuItem("Low");
        jmPriority.add(jmiHigh);
        jmPriority.add(jmiLow);
        jmOptions.add(jmPriority);

        //Подменю Reset
        JMenuItem jmiReset = new JMenuItem("Reset");
        jmOptions.addSeparator();
        jmOptions.add(jmiReset);
        //Добавляем меню Options  в главное меню
        menuBar.add(jmOptions);

        //Help...
        JMenu jmHelp = new JMenu("Help");
        JMenuItem jmiAbout = new JMenuItem("About");
        //Добавим иконку к пункту меню
        jmiAbout.setIcon(new ImageIcon(new URL("https://www.css.msu.ru/images/32x32/help.png")));
        //Добавим подсказку к пункту меню
        jmiAbout.setToolTipText("Press to open \"About\" window");
        jmHelp.add(jmiAbout);
        //Добавляем меню Help  в главное меню
        menuBar.add(jmHelp);


        //Добавим обработчики событий для всех пунктов главного меню
        jmiOpen.addActionListener(this);
        jmiSave.addActionListener(this);
        jmiClose.addActionListener(this);
        jmiExit.addActionListener(this);
        jmiRed.addActionListener(this);
        jmiGreen.addActionListener(this);
        jmiBlue.addActionListener(this);
        jmiHigh.addActionListener(this);
        jmiLow.addActionListener(this);
        jmiReset.addActionListener(this);
        jmiAbout.addActionListener(this);

        //Установить главное меню для фрейма
        frame.setJMenuBar(menuBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Выясним, какой пункт меню выбрал пользователь
        String menuItem = e.getActionCommand();

        if (menuItem.equals("Exit")) {
            //Закрыть приложение, если выбран Exit
            System.exit(0);
        } else {
            //Иначе вывести на лейбл название выбранного пункта
            jlabel.setText("You pressed: " + menuItem);
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            try {
                new MainMenuWithIconsAndTooltips();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        });
    }
}
