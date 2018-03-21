package company.my.automate.base;


import company.my.automate.base.exception.AutomateException;
import company.my.automate.module.box.Box;
import company.my.automate.module.iodevice.IODevice;

import java.util.*;

/**
 * Created by user on 02.03.2018.
 */
public abstract class AutomateBase<T> implements Automate<T> {
    protected IODevice io;
    protected List<Box<T>> boxes;
    private Map<Integer, Box<T>> boxCodes;
    private final int numberOfBoxes;
    private final int masterKey;

    public AutomateBase(IODevice io, int numberOfBoxes, int masterKey) {
        if (numberOfBoxes <= 0) {
            throw new IllegalArgumentException("Number of boxes must be positive: " + numberOfBoxes);
        }

        this.io = io;
        this.numberOfBoxes = numberOfBoxes;
        this.masterKey = masterKey;

        boxCodes = new HashMap<>();

    }

    @Override
    public void start() {
        final String separatorLine = "//-";
        int code = 0;
        while (true) {
            int userInput = -1;
            io.clear();
            io.write(separatorLine);
            io.write("ДОБРО ПОЖАЛОВАТЬ!");
            io.write("Выберите опцию:");
            io.write("1. Положить в автомат");
            io.write("2. Забрать из автомата");

            userInput = Integer.parseInt(io.read());
            io.write(separatorLine);
            io.clear();
            switch (userInput) {
                case 0:
                    io.write("Введите мастер-ключ:");
                    userInput = Integer.parseInt(io.read());
                    if (userInput == masterKey) {
                        serviceMenu();
                    }
                    break;
                case 1:
                    Box<T> box = null;
                    try {
                        box = findEmptyBox();
                        if (box == null) {
                            throw new AutomateException("К сожалению, в автомате нет пустых ячеек");
                        }
                    } catch (AutomateException e) {
                        io.write(e.getMessage());
                        io.read();
                        break;
                    }
                    io.write("Ячейка #" + box.getId() + " открыта");
                    io.write("Положите ваш объект в ячейку:");
                    T userObject = getUserObject();
                    try {
                        code = put(userObject, box);
                    } catch (AutomateException e) {
                        io.write(e.getMessage());
                        io.read();
                    }
                    io.write("Пожалуйста, закройте ячейку #" + box.getId());
                    io.write("Ваш код: " + code);
                    io.write("Спасибо за визит!");
                    io.read();
                    break;
                case 2:
                    io.write("Введите ваш код:");
                    code = Integer.parseInt(io.read());
                    try {
                        T containObject = get(code);
                        io.write("Заберите ваш объект: " + containObject.toString());
                        io.write("Хорошего дня!");
                        io.read();
                    } catch (AutomateException e) {
                        io.write(e.getMessage());
                        io.read();
                    }
                    break;
            }
        }
    }

    private void serviceMenu() {
        io.clear();
        io.write("СЕРВИС МЕНЮ:");
        io.write("1. Самодиагностика автомата");
        io.write("2. Открыть все ячеёки");
        io.write("3. Выключить автомат");
        int userInput = Integer.parseInt(io.read());

        switch (userInput) {
            case 1:
                automateSelfTesting();
                break;
            case 2:
                openAllBoxes();
                break;
            case 3:
                io.write("Для выключения автомата введите мастер-ключ: ");
                int code = Integer.parseInt(io.read());
                if (code == masterKey) {
                    System.exit(0);
                }
                break;
        }
        io.read();
        io.clear();
    }

    @Override
    public String toString() {
        return "AutomateBase{" +
                "\n IODevice=" + io +
                "\n Total boxes=" + numberOfBoxes +
                "\n Boxes=" + boxes +
                "\n BoxCodes=" + boxCodes +
                "\n MasterKey=" + masterKey +
                "\n}";
    }

    private void automateSelfTesting() {
        io.write("Программа самодиагностики автомата...\n");
        io.write(this.toString());
        io.write("");
    }

    protected abstract T getUserObject();

    @Override
    public int put(T o, Box<T> box) throws AutomateException {
        int code = 0;
        box.open();
        box.put(o);
        Random random = new Random();
        while (true) {
            code = random.nextInt(100);
            if ((code != masterKey) && (boxCodes.get(code) == null)) {
                boxCodes.put(code, box);
                break;
            }
        }
        return code;
    }

    private Box<T> findEmptyBox() {
        for (int i = 0; i < numberOfBoxes; i++) {
            if (boxes.get(i).isEmpty()) {
                return boxes.get(i);
            }
        }
        return null;
    }

    @Override
    public T get(int code) throws AutomateException {
        Box<T> box = boxCodes.remove(code);
        if (box == null) {
            throw new AutomateException("Неверный код!");
        }
        io.write("Ячейка #" + box.getId() + " открыта");
        return box.open();
    }

    private void openAllBoxes() {
        for (int i = 0; i < numberOfBoxes; i++) {
            Box<T> box = boxes.get(i);
            T boxContain = box.open();
            io.write("Ячейка #" + box.getId() + " Открыта! Объект внутри: " + boxContain);
        }
        boxCodes = new HashMap<>();
        System.gc();
    }
}
