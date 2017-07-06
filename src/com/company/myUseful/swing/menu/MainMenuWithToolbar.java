package company.myUseful.swing.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by OPER on 06.07.2017.
 */
public class MainMenuWithToolbar implements ActionListener {
    JFrame frame;
    JMenuBar menuBar;
    JLabel jlabel;


    public MainMenuWithToolbar() throws MalformedURLException {
        //Создать и настроить главное окно
        frame = new JFrame("Main Menu Demo");
        frame.setLayout(new BorderLayout()); //---!
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Добавить информационный лейбл для отображение выбранного пункта меню
        jlabel = new JLabel();
        frame.add(jlabel, BorderLayout.CENTER); //---!

        //Создать главное меню и добавить на окно
        makeMainMenu();

        //Создадим панель инструментов и добавим на главную форму
        makeToolBar();

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

    private void makeToolBar() throws MalformedURLException {

        //Создадим контейнер для панели инструментов
        JToolBar toolBar = new JToolBar("Debug");

        //иконки для кнопок панели инструментов
        ImageIcon imgSet = new ImageIcon(new URL("http://icons.iconarchive.com/icons/icojam/blueberry-basic/32/check-64-icon.png"));
        ImageIcon imgClear = new ImageIcon(new URL("https://www.shareicon.net/data/2016/01/28/266349_edit_32x32.png"));
        ImageIcon imgResume = new ImageIcon(new URL("http://www.lunolikaya.megomax.ru/assets/i/refresh.png"));

        //Создаем кнопки для панели инструментов
        JButton jbtnSet = new JButton(imgSet);
        jbtnSet.setActionCommand("Set Breakpoint");
        jbtnSet.setToolTipText("Set Breakpoint");

        JButton jbtnClear = new JButton(imgClear);
        jbtnClear.setActionCommand("Clear Breakpoint");
        jbtnClear.setToolTipText("Clear Breakpoint");

        JButton jbtnResume = new JButton(imgResume);
        jbtnResume.setActionCommand("Resume");
        jbtnResume.setToolTipText("Resume");

        //Добавим обработчики событий для кнопок меню
        jbtnSet.addActionListener(this);
        jbtnClear.addActionListener(this);
        jbtnResume.addActionListener(this);

        //Добавляем кнопки на контейнер панели
        toolBar.add(jbtnSet);
        toolBar.add(jbtnClear);
        toolBar.add(jbtnResume);

        //Добавим контейнер на главное окно
        frame.add(toolBar, BorderLayout.NORTH);

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
        SwingUtilities.invokeLater(() -> {
            try {
                new MainMenuWithToolbar();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        });
    }
}
