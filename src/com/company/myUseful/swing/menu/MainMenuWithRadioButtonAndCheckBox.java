package company.myUseful.swing.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by OPER on 06.07.2017.
 */
public class MainMenuWithRadioButtonAndCheckBox implements ActionListener {
    JFrame frame;
    JMenuBar menuBar;
    JLabel jlabel;


    public MainMenuWithRadioButtonAndCheckBox() {
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

    private void makeMainMenu() {

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
        //Пункты в виде CheckBox
        JCheckBoxMenuItem jmiRed = new JCheckBoxMenuItem("Red");
        JCheckBoxMenuItem jmiGreen = new JCheckBoxMenuItem("Green");
        JCheckBoxMenuItem jmiBlue = new JCheckBoxMenuItem("Blue");
        jmColors.add(jmiRed);
        jmColors.add(jmiGreen);
        jmColors.add(jmiBlue);
        jmOptions.add(jmColors);

        //Подменю Priority
        JMenu jmPriority = new JMenu("Priority");
        //Создадим пункты в виде RadioButton
        JRadioButtonMenuItem jmiHigh = new JRadioButtonMenuItem("High");
        JRadioButtonMenuItem jmiLow = new JRadioButtonMenuItem("Low");
        //Объединим в группу
        ButtonGroup bg = new ButtonGroup();
        bg.add(jmiHigh);
        bg.add(jmiLow);
        //Добавим в меню Options
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

        if (menuItem.equals("Exit")){
            //Закрыть приложение, если выбран Exit
            System.exit(0);
        } else {
            //Иначе вывести на лейбл название выбранного пункта
            jlabel.setText("You pressed: " + menuItem);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainMenuWithRadioButtonAndCheckBox::new);
    }
}
