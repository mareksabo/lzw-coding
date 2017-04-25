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
            String current = table.get(number);
            builder.append(current);
            addToDictionary(previous + current.charAt(0));
            previous = current;
        }
        return builder.toString();
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
