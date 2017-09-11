package company.eckel.gui;

import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

public class Test {

}

class MouseClickEvent{
    int x, y;

    public MouseClickEvent(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
interface MouseClickListener{
    void mouseClickAction(MouseClickEvent event);
}

class Mouse {

    private static final List<MouseClickListener> listeners = new LinkedList<>();

    public static void addMouseClickListener(MouseClickListener listener){
        listeners.add(listener);
    }
    public static void removeListener(MouseClickListener listener){
        listeners.remove(listener);
    }

    private void onMouseClicked(int x, int y){
        //...
        for (MouseClickListener listener : listeners){
            listener.mouseClickAction(new MouseClickEvent(x, y));
        }
    }
}

class UserClass{
    public UserClass() {
        Mouse.addMouseClickListener(new MouseClickListener() {

            @Override
            public void mouseClickAction(MouseClickEvent event) {
                //Do something useful
            }
        });
    }
}
