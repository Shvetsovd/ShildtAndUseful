package company.myUseful.swing.components;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by OPER on 05.07.2017.
 */
public class JTableDemo extends JApplet {
    @Override
    public void init() {
        try {
            SwingUtilities.invokeAndWait(() -> makeGUI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void makeGUI() {
        String[] colHead = {"ФИО", "Адрес", "Телефон"};

        String[][] data = {
                {"Иванов И.И.", "г.Липецк, пр-т 60 лет СССР, д. 34", "+7(904)2158697"},
                {"Петров С.С.", "г.Липецк, пр-т Победы, д. 1а", "+7(951)2176354"},
                {"Сидоров Н.Н.", "г.Липецк, ул. Ю.Натуралистов, д. 54", "+7(904)2181325"},
                {"Языков А.А.", "г.Липецк, ул.Московская, д. 12", "+7(999)7879642"},
                {"Швецов Д.Л.", "г.Липецк, ул. Теперика д.19", "+7(904)2178642"},
                {"Ташинова Е.С.", "С.Троицкое", "+7(903)5956428"},
        };

        //Создать таблицу
        JTable table = new JTable(data, colHead);

        //Добавить ее на панель прокрутки
        JScrollPane sp = new JScrollPane(table);
        this.add(sp);
    }
}
