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
        LZW lzw = new LZW(text);
        printTable(lzw.getTable());
        System.out.println();
        System.out.println();
        System.out.println();
    }

    private static void printTable(List<String> table) {
        System.out.println("== TABLE ==");
        for (int i = 0; i < table.size(); i++) {
            System.out.println(i + 1 + "\t" + table.get(i));
        }
        System.out.println("===========");
    }
}
