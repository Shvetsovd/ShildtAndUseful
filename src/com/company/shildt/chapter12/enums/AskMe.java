package company.shildt.chapter12.enums;

import java.util.Random;

/**
 * Created by dmitry on 24.02.17.
 */
enum Answers {
    NO, YES, MAYBE, LATER, SOON, NEVER
}

class Question {
    Random rand = new Random();

    Answers ask() {
        int prob = (int) (100 * rand.nextDouble());

        if (prob < 15) {
            return Answers.MAYBE;
        } else if (prob < 30) {
            return Answers.NO;
        } else if (prob < 60) {
            return Answers.YES;
        } else if (prob < 75) {
            return Answers.LATER;
        } else if (prob < 98) {
            return Answers.SOON;
        } else {
            return Answers.NEVER;
        }
    }
}

public class AskMe {
    static void answer(Answers result) {
        switch (result) {
            case NO:
                System.out.println("Нет");
                break;
            case YES:
                System.out.println("Да");
                break;
            case MAYBE:
                System.out.println("Возможно");
                break;
            case LATER:
                System.out.println("Позднее");
                break;
            case SOON:
                System.out.println("Вскоре");
                break;
            case NEVER:
                System.out.println("Никогда");
                break;
            default:
                System.out.println("Ошибка");
        }
    }

    public static void main(String[] args) {
        Question q = new Question();
        answer(q.ask());
        answer(q.ask());
        answer(q.ask());
        answer(q.ask());
    }
}
