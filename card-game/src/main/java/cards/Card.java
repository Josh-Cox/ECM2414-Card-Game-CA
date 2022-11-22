package cards;

public class Card {
    // attributes
    private int value;
    
    // contructor
    public Card(int value) {
        this.value = value;
    }

    // methods
    synchronized public int getValue() {
        return this.value;
    }
}