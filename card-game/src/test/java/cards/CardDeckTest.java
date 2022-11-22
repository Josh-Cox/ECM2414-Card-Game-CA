package cards;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardDeckTest {
    
    @Test
    public void takeCardTest() {
        CardDeck testDeck = new CardDeck(1);
        ArrayList<Card> testCards = new ArrayList<Card>();

        // create test deck
        for (int i = 1; i < 5 ; i++) {
            Card newTestCard = new Card(i);
            testCards.add(newTestCard);
        }
        testDeck.setDeckContent(testCards);
        int initialLength = testDeck.getDeckContent().size();
        assertTrue(testDeck.takeCard().getValue() == 1);
        assertTrue(initialLength - 1 == testDeck.getDeckContent().size());
    }

    @Test
    public void addCardTest() {
        CardDeck testDeck = new CardDeck(1);
        ArrayList<Card> testCards = new ArrayList<Card>();

        // create test deck
        for (int i = 1; i < 5 ; i++) {
            Card newTestCard = new Card(i);
            testCards.add(newTestCard);
        }
        testDeck.setDeckContent(testCards);
        
        // add a card
        Card newCard = new Card(6);
        testDeck.addCard(newCard);

        // size of list
        int size = testDeck.getDeckContent().size();

        assertTrue(testDeck.getDeckContent().get(size - 1).getValue() == 6);
    }

    @Test
    public void getDeckNumberTest() {
        CardDeck testDeck = new CardDeck(1);
        assertTrue(testDeck.getDeckNumber() == 1);
    }

    @Test
    public void getAndSetDeckContentTest() {
        CardDeck testDeck = new CardDeck(1);
        ArrayList<Card> testCards = new ArrayList<Card>();

        // create test deck
        for (int i = 1; i < 5 ; i++) {
            Card newTestCard = new Card(i);
            testCards.add(newTestCard);
        }
        testDeck.setDeckContent(testCards);

        assertEquals(testDeck.getDeckContent(), testCards);
    }
}
