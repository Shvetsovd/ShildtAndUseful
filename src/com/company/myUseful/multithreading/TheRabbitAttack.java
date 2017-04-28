package company.myUseful.multithreading;

/**
 * Created by OPER on 28.04.2017.
 */
public class TheRabbitAttack {
    public static void main(String[] args) {
        new Rabbit(2);
    }
}

class Rabbit {
    static int rabbitCount;
    int rabbitId;
    int childrenCount;

    public Rabbit(int childrenCount) {
        this.childrenCount = childrenCount;

        synchronized (Rabbit.class) {
            rabbitId = rabbitCount++;
            //System.out.println("new Rabbit: " + rabbitId);
        }
        new Thread(() -> print()).start();
    }

    void print()  {
        for (int i = 0; i < childrenCount; i++) {
            System.out.println(getSpaces(rabbitId) + rabbitId);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Rabbit(childrenCount);
        }
    }

    String getSpaces(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Count of spaces must be > 0");
        }
        String result = "";
        for (int i = 0; i < count; i++) {
            result += " ";
        }
        return result;
    }
}
