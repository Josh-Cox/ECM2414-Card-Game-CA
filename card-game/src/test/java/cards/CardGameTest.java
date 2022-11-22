package cards;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

public class CardGameTest {
    
    @Test
    public void checkPackAndPlayersTest() {
        ArrayList<Card> testValidPack = new ArrayList<Card>();
        ArrayList<Card> testInvalidPack = new ArrayList<Card>();

        for (int i = 1; i <= 32; i++) {
            testValidPack.add(new Card(i));
        }

        testInvalidPack.add(new Card(5));

        assertTrue(CardGame.checkPackAndPlayers(testValidPack, 1) == false);
        assertTrue(CardGame.checkPackAndPlayers(testInvalidPack, 4) == false);
        assertTrue(CardGame.checkPackAndPlayers(testValidPack, 4) == true);

    }
}
