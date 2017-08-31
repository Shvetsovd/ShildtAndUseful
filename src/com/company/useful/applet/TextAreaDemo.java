package company.useful.applet;

import java.applet.Applet;
import java.awt.*;

/**
 * Created by OPER on 29.06.2017.
 */
public class TextAreaDemo extends Applet {
    TextArea editor;
    @Override
    public void init() {
        String text = "Java is one of the best programming language created ever, " +
                "and I am not saying this because I am a passionate Java developer, " +
                "but Java has proved it in last 20 years. " +
                "Two decades is a big time for any Programming language, " +
                "and Java has gained strength every passing day. " +
                "Though there are times, when Java development slows down, " +
                "but Java has responded well. " +
                "Earlier with groundbreaking changes in the form of Enum, " +
                "Generics, and Autoboxing in Java 5, " +
                "performance improvement with Java 6, " +
                "and Google's choice of language for Android apps development, " +
                "keeps Java as front line programming language.";

        editor = new TextArea(text, 15, 50, TextArea.SCROLLBARS_VERTICAL_ONLY);
        this.add(editor);
    }
}
