package cards;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;

public class PlayerTest {

    @Test
    public void discardCardTest() {
        Player testPlayer = new Player(3);
        Card testPickUpCard = new Card(1);
        ArrayList<Card> testHand = new ArrayList<Card>();

        // create test hand
        for (int i = 1; i < 5 ; i++) {
            Card testCard = new Card(i);
            testHand.add(testCard);
        }
        // set test hand
        testPlayer.setHand(testHand);

        assertTrue(testPlayer.discardCard(testPickUpCard).getValue() != 3);

    }

    @Test
    public void getDeckFromNumberTest() {
        Player testPlayer = new Player(1);
        CardGame.decks.add(new CardDeck(1));
        CardDeck testDeck = new CardDeck(3);
        CardGame.decks.add(testDeck);
        CardGame.decks.add(new CardDeck(4));

        assertTrue(testPlayer.getDeckFromNumber(3) == testDeck);

    }

    @Test
    public void playerWonTest() {
        Player testWinner = new Player(1);
        Player testLoser = new Player(2);
        ArrayList<Card> winningHand = new ArrayList<Card>();
        ArrayList<Card> losingHand = new ArrayList<Card>();

        // create winning and losing hand
        for (int i = 1; i < 5 ; i++) {
            Card winnerCard = new Card(1);
            Card loserCard = new Card(i);
            winningHand.add(winnerCard);
            losingHand.add(loserCard);
        }
        testWinner.setHand(winningHand);
        testLoser.setHand(losingHand);

        
        // set playerWon()
        assertTrue(testWinner.playerWon() == true);
        assertTrue(testLoser.playerWon() == false);
    }

    @Test
    public void getAndSetHandTest() {
        Player testPlayer = new Player(1);
        ArrayList<Card> testHand = new ArrayList<Card>();
        for (int i = 1; i < 5 ; i++) {
            Card testCard = new Card(i);
            testHand.add(testCard);
        }
        testPlayer.setHand(testHand);
        assertEquals(testHand, testPlayer.getHand());
    }

    @Test
    public void getPlayerNumberTest() {
        int playerTestNum = 10;
        Player testPlayer = new Player(playerTestNum);
        assertEquals(testPlayer.getPlayerNumber(), playerTestNum);
    }

    @Test
    public void getAndSetPickUpDeckTest() {
        Player testPlayer = new Player(1);
        testPlayer.setPickUpDeck(1);

        assertTrue(testPlayer.getPickUpDeck() == 1);
    }

    @Test
    public void getAndSetDiscardDeckTest() {
        Player testPlayer = new Player(1);
        testPlayer.setDiscardDeck(2);

        assertTrue(testPlayer.getDiscardDeck() == 2);
    }
}
