package cards;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardTest {
    
    @Test
    public void getValueTest() {
        Card testCard = new Card(5);
        assertTrue(testCard.getValue() == 5);
    }
}

