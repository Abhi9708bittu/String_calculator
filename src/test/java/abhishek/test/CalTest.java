package abhishek.test;
import abhishek.Cal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalTest {
    Cal calculator = new Cal();
    @Test
    void testEmptyString() {
        assertEquals("0.0", calculator.add(""));
    }
    @Test
    void testOneNumber() {
        assertEquals("1.0", calculator.add("1"));
    }
    @Test
    void testTwoNumbers() {
        assertEquals("3.0", calculator.add("1,2"));
    }
    @Test
    void testManyNumbers() {
        assertEquals("6.6", calculator.add("1.1,2.2,3.3"));
    }
    @Test
    void testNewlineSeparator() {
        assertEquals("6.0", calculator.add("1\n2,3"));
    }
    @Test
    void testInvalidNewlinePlacement() {
        assertEquals("Number expected but '\\n' found at position 6.", calculator.add("175.2,\n35"));
    }
    @Test
    void testMissingNumberAtEnd() {
        assertEquals("Number expected but EOF found.", calculator.add("1,3,"));
    }
    @Test
    void testCustomDelimiterSemicolon() {
        assertEquals("3.0", calculator.add("//;\n1;2"));
    }
    @Test
    void testCustomDelimiterPipe() {
        assertEquals("6.0", calculator.add("//|\n1|2|3"));
    }
    @Test
    void testCustomDelimiterWord() {
        assertEquals("5.0", calculator.add("//sep\n2sep3"));
    }
    @Test
    void testCustomDelimiterError() {
        assertEquals("'|' expected but ',' found at position 3.", calculator.add("//|\n1|2,3"));
    }
    @Test
    void testNegativeNumber() {
        assertEquals("Negative not allowed : -1", calculator.add("-1,2"));
    }
    @Test
    void testMultipleNegatives() {
        assertEquals("Negative not allowed : -4\nNegative not allowed : -5", calculator.add("2,-4,-5"));
    }
    @Test
    void testMultipleErrors() {
        assertEquals("Negative not allowed : -1\nNumber expected but ',' found at position 3.\nNegative not allowed : -2", calculator.add("-1,, -2"));
    }
    @Test
    void testMultiply() {
        assertEquals("6.0", calculator.multiply("1,2,3"));
    }
    @Test
    void testMultiplyWithCustomDelimiter() {
        assertEquals("24.0", calculator.multiply("//|\n2|3|4"));
    }
}