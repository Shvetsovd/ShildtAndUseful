package company.useful.nestedInner;

import java.util.LinkedList;
import java.util.List;

interface MouseListener{
    void OnClick(int x, int y);
}

class Mouse {

    private static final List<MouseListener> listeners = new LinkedList<>();

    public static void addListener(MouseListener listener){
        listeners.add(listener);
    }
    public static void removeListener(MouseListener listener){
        listeners.remove(listener);
    }

    private void onMouseClicked(int x, int y){
        //...
        for (MouseListener listener : listeners){
            listener.OnClick(x, y);
        }
    }
}

class UserClass{
    public UserClass() {
        Mouse.addListener(new MouseListener() {
            @Override
            public void OnClick(int x, int y) {
                //User do something useful
            }
        });
    }
}




