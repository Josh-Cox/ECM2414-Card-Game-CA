package cards;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

public class PackTest {

    @Test
    public void getPackValidTest() throws IOException {
        ArrayList<Integer> testValidPack = Pack.getPack("/ECM2414-Card-Game-CA/default");
        
        assertTrue(testValidPack.size() == 32);
        assertTrue(testValidPack.get(0) == 5);
        assertTrue(testValidPack.get(31) == 4);
    }
}
