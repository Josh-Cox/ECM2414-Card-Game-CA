package cards;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CardDeck {
    
    // attributes
    private int deckNumber;
    private ArrayList<Card> content = new ArrayList<Card>();

    // constructor
    public CardDeck(int number) {
        this.deckNumber = number;
    }

    /**
     * Logs the content of deck to respective deck files
     */
    public void logContent() {
        String deckContent = "";
        for (Card card : content) {
            deckContent = deckContent + " " + Integer.toString(card.getValue());
        }
        try {
            FileWriter logger = new FileWriter("deck" + this.deckNumber + "_output.txt");
            logger.write("deck" + this.deckNumber + " contents: " + deckContent);
            logger.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Get card from top of deck (Synchronized for Thread safety)
     * @return Next Card
     */
    synchronized public Card takeCard() {
        if (this.content.size() != 0) {
            Card card = this.content.get(0);
            this.content.remove(0);
            return card;
        }
        else {
            return null;
        }
    }
    
    /**
     * Add card to bottom of deck (Synchronized for Thread safety)
     * @param card
     */
    synchronized public void addCard(Card card) {
        this.content.add(card);
    }   

    // setters
    public void setDeckContent(ArrayList<Card> content) {
        this.content = content;
    }
    
    // getters
    public int getDeckNumber() {
        return this.deckNumber;
    }

    synchronized public ArrayList<Card> getDeckContent() {
        return this.content;
    }
}