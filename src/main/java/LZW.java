import java.util.*;

/**
 * @author Marek Sabo
 */
class LZW {

    private List<String> table;

    LZW(String inputString) {
        table = createLetterList(inputString);
        String codedOutput = encodeToNumbers(inputString);
        System.out.println(codedOutput);
    }

    private List<String> createLetterList(String input) {
        Set<String> set = new TreeSet<>();
        for (char c : input.toCharArray()) {
            set.add(Character.toString(c));
        }
        return new ArrayList<>(set);
    }

    private String encodeToNumbers(String remainingChars) {
        StringBuilder output = new StringBuilder();

        while (!remainingChars.isEmpty()) {
            Prefix longestPrefix = findLongestPrefix(remainingChars);
            remainingChars = remainingChars.substring(longestPrefix.getPrefixLength());

            output.append(table.indexOf(longestPrefix.getPrefixString()) + 1).append(" ");

            String nextChar = remainingChars.isEmpty() ? "" : String.valueOf(remainingChars.charAt(0));
            addToDictionary(longestPrefix.getPrefixString() + nextChar);
        }
        return output.toString();
    }

    private Prefix findLongestPrefix(String text) {
        Prefix maxPrefix = new Prefix(0, "");
        for (String s : table) {
            Prefix p = Prefix.findPrefix(text, s);
            maxPrefix = maxPrefix.getLongerPrefix(p);
        }
        return maxPrefix;
    }

    private void addToDictionary(String entry) {
        if (!table.contains(entry)) table.add(entry);
    }

    List<String> getTable() {
        return table;
    }
}
