import org.junit.Assert;

import java.util.List;

/**
 * @author Marek Sabo
 */
public class Main {

    private static final String EXAMPLE_TEXT = "wabba_wabba_wabba_wabba_woo_woo_woo";
    private static final String SUBMIT_TEXT = "/WED/WE/WEE/WEB/WET";


    public static void main(String[] args) {
        processText(EXAMPLE_TEXT);
        processText(SUBMIT_TEXT);
    }

    private static void processText(String text) {
        System.out.println("Original: " + text);
        EncodeLZW encodeLzw = new EncodeLZW(text);
        String codedString = encodeLzw.getCodedOutput();
        System.out.println("Coded string: " + codedString);

        DecodeLZW decodeLZW = new DecodeLZW(codedString, Utils.createLetterList(text));
        String decodedString = decodeLZW.getOriginalText();
        System.out.println("Decoded string: " + decodedString);
        printTable(decodeLZW.getTable());
        System.out.println();
        System.out.println();

        Assert.assertEquals(text, decodedString);
        Assert.assertEquals(encodeLzw.getTable(), decodeLZW.getTable());
    }

    private static void printTable(List<String> table) {
        System.out.println("== TABLE ==");
        for (int i = 0; i < table.size(); i++) {
            System.out.println(i + 1 + "\t" + table.get(i));
        }
        System.out.println("===========");
    }
}
