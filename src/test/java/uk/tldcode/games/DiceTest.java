package uk.tldcode.games;

import org.junit.Test;
import uk.tldcode.games.dice.*;

import static org.junit.Assert.assertTrue;

public class DiceTest {

    @Test
    public void testDice(){
        Die d4 = new D4();
        Die d6 = new D6();
        Die d8 = new D8();
        Die d10 = new D10();
        Die d10L = new D10L();
        Die d12 = new D12();
        Die d20 = new D20();
        Die d20S = new D20S();
        Die d100 = new D100();

        int i = 100;
        while (i-- > 0) {
            int roll = d4.roll();
            assertTrue(roll < 5 && roll > 0);
        }
        i = 100;
        while (i-- > 0) {
            int roll = d6.roll();
            assertTrue(roll < 7 && roll > 0);
        }

        i = 100;
        while (i-- > 0) {
            int roll = d8.roll();
            assertTrue(roll < 9 && roll > 0);
        }

        i = 100;
        while (i-- > 0) {
            int roll = d10.roll();
            assertTrue(roll < 10 && roll >= 0);
        }

        i = 100;
        while (i-- > 0) {
            int roll = d10L.roll();
            assertTrue(roll % 10 == 0 && roll < 91 && roll >= 0);
        }

        i = 100;
        while (i-- > 0) {
            int roll = d12.roll();
            assertTrue(roll < 13 && roll > 0);
        }

        i = 100;
        while (i-- > 0) {
            int roll = d20.roll();
            assertTrue(roll < 21 && roll > 0);
        }

        i = 100;
        while (i-- > 0) {
            int roll = d20S.roll();
            assertTrue(roll < 10 && roll >= 0);
        }

        i = 100;
        while (i-- > 0) {
            int roll = d100.roll();
            assertTrue(roll < 100 && roll >= 0);
        }

    }
}
