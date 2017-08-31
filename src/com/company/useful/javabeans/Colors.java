package company.useful.javabeans;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

/**
 * Java Bean - это класс с определенной (в каком-то смысле стандартизованной) внутренней архитектурой.
 * Главным достоинством Bean'ов является возможность многократного переиспользования данного компонента в самых различных системах и модулях,
 * это своеобразный образцовый "кирпичик"
 * <p>
 * Основными требованиями к структуре класса являются:
 * - все поля должны быть private
 * - у полей должны быть геттеры и сеттеры (если поле только для чтения, то только геттеры; только для записи - сеттеры)
 * - иногда выделяют требование наличия конструктора по умолчанию, т.е. без параметров
 * <p>
 * Важной особенностью Bean'ов является способность анализа и самоанализа доступных свойств, событий и других элементов, соответствующих контракту к Bean'у
 * <p>
 * Распознавание свойств:
 * геттеры и сеттеры должны выполнять следующий контракт именования (для свойства с именем N)
 * простые свойства
 * public T getN()
 * public void setN(T value)
 * <p>
 * индексированные свойства
 * public T[] getN()
 * public void setN(T[] values)
 * public T getN(int index)
 * public void setN(int index, T value)
 * <p>
 * <p>
 * Распознавание событий:
 * public void addTListener(TListener listener)
 * public void addTListener(TListener listener) throws TooManyListenersException
 * public void removeTListener(TListener listener)
 */
public class Colors extends Canvas implements Serializable {
    transient private Color color;
    private boolean rectangular;

    public Colors() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                change();
            }
        });
    }

    public boolean getRectangular() {
        return rectangular;
    }

    public void setRectangular(boolean rectangular) {
        this.rectangular = rectangular;
        repaint();
    }

    private void change() {
        color = randomColor();
        repaint();
    }

    private Color randomColor() {
        int r = (int) (255 * Math.random());
        int g = (int) (255 * Math.random());
        int b = (int) (255 * Math.random());
        return new Color(r, g, b);
    }

    @Override
    public void paint(Graphics g) {
        Dimension d = getSize();
        int h = d.height;
        int w = d.width;
        g.setColor(color);
        if (rectangular) {
            g.fillRect(0, 0, w - 1, h - 1);
        } else {
            g.fillOval(0, 0, w - 1, h - 1);
        }
    }
}
