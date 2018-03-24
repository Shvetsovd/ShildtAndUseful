package company.my.interview;

import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by user on 24.03.2018.
 */
public class CharsCountTask {
    public static void main(String[] args) {
        String charsCount;
        //charsCount = getCharsCount("bcvbbcva");
        charsCount = getCharsCount2("bcvbbcva");
        System.out.println(charsCount);
    }

    private static String getCharsCount(String src) {
        Map<Character, Integer> chars = new LinkedHashMap<>();
        for (char c : src.toCharArray()) {
            chars.merge(c, 1, (v1, v2) -> v1 + v2);
        }
        String result = "";
        for (Character character : chars.keySet()) {
            result += chars.get(character);
            result += character;
        }
        return result;
    }

    private static String getCharsCount2(String src) {
        Map<Character, Long> collect = CharBuffer.wrap(src.toCharArray())
                .chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return collect.toString();
    }
}
