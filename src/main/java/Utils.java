import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Marek Sabo
 */
class Utils {

    static List<String> createLetterList(String input) {
        Set<String> set = new TreeSet<>();
        for (char c : input.toCharArray()) {
            set.add(Character.toString(c));
        }
        return new ArrayList<>(set);
    }

    static Prefix findLongestPrefix(String text, List<String> table) {
        Prefix maxPrefix = new Prefix(0, "");
        for (String s : table) {
            Prefix p = Prefix.findPrefix(text, s);
            maxPrefix = maxPrefix.getLongerPrefix(p);
        }
        return maxPrefix;
    }
}
