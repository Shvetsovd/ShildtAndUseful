package company.myUseful.nestedInner;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by user on 05.05.2017.
 */
interface MouseListener2{
    void OnClick(int x, int y);
    void onDoubleClick(int x, int y);
    void onRighntButtonClick(int x, int y);
    void onRighntButtonDoubleClick(int x, int y);
    void onMove(int x, int y);
}
class BaseMouseListener2 implements MouseListener2{

    @Override
    public void OnClick(int x, int y) {

    }

    @Override
    public void onDoubleClick(int x, int y) {

    }

    @Override
    public void onRighntButtonClick(int x, int y) {

    }

    @Override
    public void onRighntButtonDoubleClick(int x, int y) {

    }

    @Override
    public void onMove(int x, int y) {

    }
}
class Mouse2 {

    private static final List<MouseListener2> listeners = new LinkedList<>();

    public static void addListener(MouseListener2 listener){
        listeners.add(listener);
    }
    public static void removeListener(MouseListener2 listener){
        listeners.remove(listener);
    }

    private void onMouseClicked(int x, int y){
        //...
        for (MouseListener2 listener : listeners){
            listener.OnClick(x, y);
        }
    }
}
class UserClass2 {
    public static void main(String[] args) {
       Mouse2.addListener(new BaseMouseListener2(){
           @Override
           public void OnClick(int x, int y) {
               //Do something useful
           }

           @Override
           public void onDoubleClick(int x, int y) {
               //Do something useful
           }
       });
    }
}
