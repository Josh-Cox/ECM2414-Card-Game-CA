package cards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;

public class CardGame {
    // arrays for decks and players
    public static ArrayList<CardDeck> decks = new ArrayList<CardDeck>();
    public static ArrayList<Player> players = new ArrayList<Player>();
    public static ArrayList<Card> pack = new ArrayList<Card>();

    public static int numPlayers = 0;
    public static boolean winner = false;

    public static void main(String[] args) {
        startGame();
    }

    /**
     * Tells players who the winner is
     * @param playerNum
     */
    public static void winner(int playerNum) {
        for (Player player : players) {
            player.gameOver(playerNum);
        }
        for (CardDeck deck : decks) {
            deck.logContent();
        }
        System.out.println("Player " + playerNum + " Won!");
    }

    /**
     * Checks if pack and number of players is valid
     * @param pack
     * @param numOfPlayers
     * @return pack validity
     */
    public static boolean checkPackAndPlayers(ArrayList<Card> pack, int numOfPlayers) {
        if (numOfPlayers < 2) {
            System.out.println("Must be 2 or more players to start game");
            return false;
        }
        
        if (pack.size() != (numOfPlayers * 8)) {
            System.out.println("Number of cards in pack is invalid");
            return false;
        }

        return true;
    }


    /**
     * Create player files
     */
    public static void createFiles() {

        // delete all pre-existing files
        // for (File file : new File("./playerLogs").listFiles()) {
        //     file.delete();
        // }

        // for (File file : new File("ECM2414/deckLogs").listFiles()) {
        //     file.delete();
        // }

        // create file for each player
        for (Player player : players) {
            try {
                File newFile = new File("player" + player.getPlayerNumber() + "_output.txt");
                newFile.createNewFile();
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        // create file for each deck
        for (CardDeck deck : decks) {
            try {
                File newFile = new File("deck" + deck.getDeckNumber() + "_output.txt");
                newFile.createNewFile();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
    
    /**
     * Starts the game
     */
    public static void startGame() {
        // create pack of cards from file
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Number of players: ");
            numPlayers = Integer.parseInt(bufferRead.readLine());
            System.out.print("Pack filename: ");
            String filename = bufferRead.readLine();

            ArrayList<Integer> values = Pack.getPack(filename);

            for (Integer value : values) {
                pack.add(new Card(value));
            }
            
        } catch (IOException e) {
            System.out.println(e);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }


        if (checkPackAndPlayers(pack, numPlayers)) {

            // rng
            Random rand = new Random();

            // instantiate players
            for (int i = 1; i <= numPlayers; i++) {

                Player newPlayer = new Player(i);
                ArrayList<Card> newPlayerHand = new ArrayList<Card>();

                // get 4 random cards and assign to player hand
                for (int j = 1; j <= 4; j++) {
                    int cardPos = rand.nextInt(pack.size());
                    newPlayerHand.add(pack.get(cardPos));
                    pack.remove(0);
                }

                newPlayer.setHand(newPlayerHand);
                players.add(newPlayer);
            }
            
            // instantiate decks
            for (int i = 1; i <= numPlayers; i++) {

                CardDeck newDeck = new CardDeck(i);
                ArrayList<Card> newDeckContent = new ArrayList<Card>();

                // get 4 random cards and assign to deck content
                for (int j = 1; j <= 4; j++) {
                    int cardPos = rand.nextInt(pack.size());
                    // System.out.println(cardPos);
                    newDeckContent.add(pack.get(cardPos));
                    pack.remove(0);
                }

                newDeck.setDeckContent(newDeckContent);
                decks.add(newDeck);
            }

        }

        // create player files
        createFiles();

        // start player threads
        for (Player player : players) {
            player.start();
        }
    }
}