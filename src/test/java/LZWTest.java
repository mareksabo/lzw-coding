import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Marek Sabo
 */
public class LZWTest {

    private LZW lzw;

    @Before
    public void setUp() throws Exception {
//        lzw = new LZW("ALOHA");
    }

    @Test
    public void findPrefix() {
        Prefix actual = Prefix.findPrefix("AAB", "AB");
        assertEquals(new Prefix(2, "AB"), actual);

        actual = Prefix.findPrefix("ACAB", "AB");
        assertEquals(new Prefix(1, "AB"), actual);
    }

}