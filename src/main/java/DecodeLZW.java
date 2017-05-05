import java.util.Arrays;
import java.util.List;

/**
 * @author Marek Sabo
 */
class DecodeLZW {

    private List<String> table;
    private String originalText;

    DecodeLZW(String codedString, List<String> alphabet) {
        table = alphabet;
        originalText = decodeToText(codedString);
    }

    private String decodeToText(String codedString) {
        StringBuilder builder = new StringBuilder();
        String previous = "";
        for (int number : stringToDecreasedIntArray(codedString)) {
            String current = getStringFromDictionary(previous, number);
            builder.append(current);
            addToDictionary(previous + current.charAt(0));
            previous = current;
        }
        return builder.toString();
    }

    private String getStringFromDictionary(String previous, int number) {
        if (number >= table.size()) {
            addToDictionary(previous + previous.charAt(0));
        }
        return table.get(number);
    }

    private int[] stringToDecreasedIntArray(String numbers) {
        return Arrays.stream(numbers.split(" ")).mapToInt(Integer::valueOf).map(x -> x - 1).toArray();
    }

    private void addToDictionary(String entry) {
        if (!table.contains(entry)) table.add(entry);
    }

    List<String> getTable() {
        return table;
    }

    String getOriginalText() {
        return originalText;
    }
}
