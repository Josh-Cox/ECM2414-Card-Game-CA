package cards;

import java.util.Random;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Player extends Thread {
    // attributes
    private int playerNumber;
    private ArrayList<Card> hand = new ArrayList<Card>();
    private int pickUpDeck;
    private int discardDeck;

    // contructor
    public Player(int number) {
        this.playerNumber = number;
        this.pickUpDeck = number;

        if (number == CardGame.numPlayers) {
            this.discardDeck = 1;
        }
        else {
            this.discardDeck = number + 1;
        }
    }

    // Overriden run method
    @Override
    public void run() {

        try {
            FileWriter logger = new FileWriter(("player" + this.playerNumber + "_output.txt"), true);
            logger.write("player " +
            this.playerNumber +
            " inial hand " + 
            this.getCurrentHand());

            logger.close();

        } catch (IOException e) {
            System.out.println(e);
        }

        while (!CardGame.winner) {
            if (this.playerWon() == true) {
                CardGame.winner = true;
                CardGame.winner(this.playerNumber);
                break;
            }

            // check for winner before starting atomic action
            if (!CardGame.winner) {
                Card cardDrawn = this.getDeckFromNumber(this.pickUpDeck).takeCard();
    
                if (cardDrawn != null) {
                    Card cardDiscarded = this.discardCard(cardDrawn);
                    this.getDeckFromNumber(this.discardDeck).addCard(cardDiscarded);
                    logTurn(cardDrawn.getValue(), cardDiscarded.getValue());
                }
            }
        }
    }

    public CardDeck getDeckFromNumber(int deckNum) {
        for (CardDeck deck : CardGame.decks) {
            if(deck.getDeckNumber() == deckNum) {
                return deck;
            }
        }
        return null;
    }


    /**
     * Player adds card to hand and discard a non-preferred card
     * @param newCard
     * @return discarded card
     */
    public Card discardCard(Card newCard) {
        this.hand.add(newCard);
        boolean preferred = true;
        Card discarded = new Card(0);
        Random rand = new Random();

        while (preferred == true) {
            int randomNum = (int) Math.floor(rand.nextInt(5));
            if (this.hand.get(randomNum).getValue() != this.playerNumber) {
                preferred = false;
                discarded = this.hand.get(randomNum);
                this.hand.remove(randomNum);
            }
        }
        return discarded;
    }

    /**
     * Log players actions for that turn to player file
     * @param cardDrawn
     * @param cardDiscarded
     */
    public void logTurn(int cardDrawn, int cardDiscarded) {

        try {
            FileWriter logger = new FileWriter(("player" + this.playerNumber + "_output.txt"), true);
            // write card pickup
            logger.write("\n\nplayer " +
            this.playerNumber +
            " draws a " +
            cardDrawn +
            " from deck " +
            this.pickUpDeck);

            // write card discard
            logger.write("\nplayer " +
            this.playerNumber +
            " discards a " +
            cardDiscarded +
            " to deck " +
            this.discardDeck);

            // write card discard
            logger.write("\nplayer " +
            this.playerNumber +
            " current hand is " +
            this.getCurrentHand());

            logger.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Checks if the player has won
     * @return
     */
    public boolean playerWon() {
        boolean won = true;

        for (int i = 0; i < 3; i++) {
            if (this.hand.get(i).getValue() != this.hand.get(i + 1).getValue()) {
                won = false;
            }
        }

        return won;
    }

    /**
     * Write game results to file
     */
    public void gameOver(int winnerNum) {

        // sleep so player doesn't pickup any cards after winner has been found
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            
        }
        try {
            FileWriter logger = new FileWriter(("player" + this.playerNumber + "_output.txt"), true);

            if (winnerNum == this.playerNumber) {

                // this player wins
                logger.write("\n\nplayer " +
                this.playerNumber +
                " wins\nplayer " +
                this.playerNumber +
                " exits\nplayer " +
                this.playerNumber +
                " final hand: " +
                this.getCurrentHand());
            }
            else {

                // another player wins
                logger.write("\n\nplayer " +
                winnerNum +
                " has informed player " +
                this.playerNumber +
                " that player " +
                winnerNum +
                " has won\nplayer " +
                this.playerNumber +
                " exits\nplayer " +
                this.playerNumber +
                " final hand: " +
                this.getCurrentHand());
            }


            logger.close();
        } catch (IOException e) {
            System.out.println(e);
        }
     
    }

    public String getCurrentHand() {
        String currentHand = "";
        for (Card card : hand) {
            currentHand = currentHand + " " + Integer.toString(card.getValue());
        }

        return currentHand;
    }

    // setters
    public void setHand (ArrayList<Card> cards){
        this.hand = cards;
    }

    public void setPickUpDeck(int deckNumber) {
        this.pickUpDeck = deckNumber;
    }

    public void setDiscardDeck(int deckNumber) {
        this.discardDeck = deckNumber;
    }

    // getters
    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public int getPlayerNumber() {
        return this.playerNumber;
    }

    public int getPickUpDeck() {
        return this.pickUpDeck;
    }

    public int getDiscardDeck() {
        return this.discardDeck;
    }
}
