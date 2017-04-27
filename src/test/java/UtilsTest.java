import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Marek Sabo
 */
public class UtilsTest {

    @Test
    public void findPrefix() {
        Prefix actual = Prefix.findPrefix("ABA", "AB");
        assertEquals(new Prefix(2, "AB"), actual);

        actual = Prefix.findPrefix("ACAB", "AB");
        assertEquals(new Prefix(1, "AB"), actual);
    }

    @Test
    public void createLetterList() {
        List<String> actual = Utils.createLetterList("AABCDBCD");
        assertEquals(Arrays.asList("A", "B", "C", "D"), actual);
    }
}