package company.myUseful.swing.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by OPER on 06.07.2017.
 */
public class MainMenuFullExample implements ActionListener {
    JFrame frame;
    JMenuBar menuBar;
    JLabel jlabel;

    //Actions
    DebugAction setAct;
    DebugAction clearAct;
    DebugAction resumeAct;
    //иконки для кнопок панели инструментов и меню
    ImageIcon imgSet = new ImageIcon(new URL("http://icons.iconarchive.com/icons/icojam/blueberry-basic/32/check-64-icon.png"));
    ImageIcon imgClear = new ImageIcon(new URL("https://www.shareicon.net/data/2016/01/28/266349_edit_32x32.png"));
    ImageIcon imgResume = new ImageIcon(new URL("http://www.lunolikaya.megomax.ru/assets/i/refresh.png"));


    public MainMenuFullExample() throws MalformedURLException {
        //Создать и настроить главное окно
        frame = new JFrame("Main Menu Demo");
        frame.setLayout(new BorderLayout()); //---!
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Добавить информационный лейбл для отображение выбранного пункта меню
        jlabel = new JLabel();
        frame.add(jlabel, BorderLayout.CENTER); //---!

        //Создадим действия, которые будут общами для главного меню и панели инструментов
        makeActions();

        //Создать главное меню и добавить на окно
        makeMainMenu();

        //Создадим панель инструментов и добавим на главную форму
        makeToolBar();

        //Показать окно пользователю
        frame.setVisible(true);
    }

    //Класс для описания общих действий для меню и панели инструментов
    class DebugAction extends AbstractAction {
        public DebugAction(String name,
                           Icon icon,
                           int mnem,
                           int accel,
                           String tooltip) {

            super(name, icon);
            putValue(MNEMONIC_KEY, new Integer(mnem));
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(accel, InputEvent.CTRL_DOWN_MASK));
            putValue(SHORT_DESCRIPTION, tooltip);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            jlabel.setText("You selected: " + command);

            if (command.equals("Set Breakpoint")) {
                setAct.setEnabled(false);
                clearAct.setEnabled(true);
            } else if (command.equals("Clear Breakpoint")) {
                clearAct.setEnabled(false);
                setAct.setEnabled(true);
            } else if (command.equals("Resume")){
                setAct.setEnabled(true);
                clearAct.setEnabled(true);
            }

        }
    }

    private void makeActions() throws MalformedURLException {

        setAct = new DebugAction("Set Breakpoint", imgSet, KeyEvent.VK_B, KeyEvent.VK_B, "Set Breakpoint");
        clearAct = new DebugAction("Clear Breakpoint", imgClear, KeyEvent.VK_V, KeyEvent.VK_V, "Clear Breakpoint");
        resumeAct = new DebugAction("Resume", imgResume, KeyEvent.VK_R, KeyEvent.VK_R, "Set Breakpoint");

        clearAct.setEnabled(false);
    }

    private void makeMainMenu() throws MalformedURLException {

        //Создать контейнер главного меню
        menuBar = new JMenuBar();

        //Создание отдельных подменю и добавление их в контейнер
        //File...
        JMenu jmFile = new JMenu("File");
        //Установить клавишу F в качестве мнемоники пункта меню
        //мнемоника - клавиша, которая вызывает конкретный пункт подменю при активном фокусе на соответствующим меню
        //Горячая клавиша активирует пункт меню без фокуса на главном меню
        jmFile.setMnemonic(KeyEvent.VK_F);

        //Создать пункт меню и указать сразу мнемонику
        JMenuItem jmiOpen = new JMenuItem("Open", KeyEvent.VK_O);
        //Добавить горячую клавишу
        jmiOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));

        JMenuItem jmiSave = new JMenuItem("Save", KeyEvent.VK_S);
        jmiSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));

        JMenuItem jmiClose = new JMenuItem("Close", KeyEvent.VK_C);
        jmiClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));

        JMenuItem jmiExit = new JMenuItem("Exit", KeyEvent.VK_E);
        jmiExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));

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
        JCheckBoxMenuItem jmiRed = new JCheckBoxMenuItem("Red");
        JCheckBoxMenuItem jmiGreen = new JCheckBoxMenuItem("Green");
        JCheckBoxMenuItem jmiBlue = new JCheckBoxMenuItem("Blue");

        jmColors.add(jmiRed);
        jmColors.add(jmiGreen);
        jmColors.add(jmiBlue);
        jmOptions.add(jmColors);

        //Подменю Priority
        JMenu jmPriority = new JMenu("Priority");
        JRadioButtonMenuItem jmiHigh = new JRadioButtonMenuItem("High");
        JRadioButtonMenuItem jmiLow = new JRadioButtonMenuItem("Low");
        ButtonGroup bg = new ButtonGroup();
        bg.add(jmiHigh);
        bg.add(jmiLow);

        jmPriority.add(jmiHigh);
        jmPriority.add(jmiLow);
        jmOptions.add(jmPriority);

        //Подменю Debug
        JMenu jmDebug = new JMenu("Debug");
        JMenuItem jmiSetBP = new JMenuItem(setAct);
        JMenuItem jmiClearBP = new JMenuItem(clearAct);
        JMenuItem jmiResume = new JMenuItem(resumeAct);

        jmDebug.add(jmiSetBP);
        jmDebug.add(jmiClearBP);
        jmDebug.add(jmiResume);
        jmOptions.add(jmDebug);

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

    private void makeToolBar() throws MalformedURLException {

        //Создадим контейнер для панели инструментов
        JToolBar toolBar = new JToolBar("Debug");

        //Создаем кнопки для панели инструментов
        JButton jbtnSet = new JButton(setAct);

        JButton jbtnClear = new JButton(clearAct);

        JButton jbtnResume = new JButton(resumeAct);

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

        if (menuItem.equals("Exit")) {
            //Закрыть приложение, если выбран Exit
            System.exit(0);
        } else {
            //Иначе вывести на лейбл название выбранного пункта
            jlabel.setText("You selected: " + menuItem);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new MainMenuFullExample();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        });
    }
}


