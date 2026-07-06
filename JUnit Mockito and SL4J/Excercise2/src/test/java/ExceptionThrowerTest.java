import org.example.ExceptionThrower;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
public class ExceptionThrowerTest
{
    @Test
    public void testThrower()
    {
        ExceptionThrower e = new ExceptionThrower();
        assertThrows(ArithmeticException.class , ()->{
            e.thrower();
        });
    }

}
