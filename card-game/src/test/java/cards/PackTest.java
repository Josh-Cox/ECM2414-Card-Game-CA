package cards;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

public class PackTest {

    @Test
    public void getPackTest() throws IOException {
        ArrayList<Integer> testPack = Pack.getPack("/ECM2414-Card-Game-CA/default");

        // assertTrue(testPack.size() != 0);
        assertTrue(testPack.size() == 32);
    }
}
