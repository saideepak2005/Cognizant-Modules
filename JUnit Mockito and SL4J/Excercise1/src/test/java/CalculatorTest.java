import org.example.Calculator;
import static  org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest
{
    @Test
    public void CalculatorTest()
    {
        Calculator c = new Calculator();
        assertEquals(6 , c.add(2 , 4));
    }
}
