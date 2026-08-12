package seminars.third.hw;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HWTests {

    HW hw = new HW();
    @Test
    public void testEvenOddNumber() {
        assertTrue(hw.evenOddNumber(4));

        assertFalse(hw.evenOddNumber(7));
    }
    @Test
    public void testNumberInInterval() {
        assertTrue(hw.numberInInterval(50));

        assertFalse(hw.numberInInterval(20));

        assertFalse(hw.numberInInterval(25));

        assertFalse(hw.numberInInterval(150));
    }

}








