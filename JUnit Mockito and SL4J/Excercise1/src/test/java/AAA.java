import static org.junit.Assert.*;

import org.example.Calculator;
import org.junit.*;
public class AAA
{
    private Calculator c;
    @Before
    public void setup()
    {
        System.out.println("Before Creating clacultor Object");
        c = new Calculator();
    }
    @After
    public void tearDown()
    {
        System.out.println("Teardown: Cleaning up");
        c = null;
    }
    @Test
    public void testadd()
    {
        int a =2 , b = 4;
        int r = a+b;
        assertEquals(6 , r);
    }
}
