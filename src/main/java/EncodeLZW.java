import java.util.*;

/**
 * @author Marek Sabo
 */
class EncodeLZW {

    private List<String> table;
    private String codedOutput;

    EncodeLZW(String inputString) {
        table = Utils.createLetterList(inputString);
        codedOutput = encodeToNumbers(inputString);
    }

    private String encodeToNumbers(String remainingChars) {
        StringBuilder output = new StringBuilder();

        while (!remainingChars.isEmpty()) {
            Prefix longestPrefix = Utils.findLongestPrefix(remainingChars, table);
            remainingChars = remainingChars.substring(longestPrefix.getPrefixLength());

            output.append(table.indexOf(longestPrefix.getPrefixString()) + 1).append(" ");

            String nextChar = remainingChars.isEmpty() ? "" : String.valueOf(remainingChars.charAt(0));
            addToDictionary(longestPrefix.getPrefixString() + nextChar);
        }
        return output.toString();
    }

    private void addToDictionary(String entry) {
        if (!table.contains(entry)) table.add(entry);
    }

    List<String> getTable() {
        return table;
    }

    String getCodedOutput() {
        return codedOutput;
    }
}
