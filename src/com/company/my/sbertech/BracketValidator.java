package company.my.sbertech;

/* Java */
import java.util.*;

public class BracketValidator {
    public static boolean isSymmetric(char[] expr) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Deque<Character> stck = new ArrayDeque<>();

        for (char c : expr) {
            if (c == '(' || c == '[' || c == '{') {
                stck.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stck.isEmpty()) {
                    return false;
                }
                char top = stck.pop();
                if (map.get(top) != c) {
                    return false;
                }
            }
        }
        return stck.isEmpty();
    }
}
