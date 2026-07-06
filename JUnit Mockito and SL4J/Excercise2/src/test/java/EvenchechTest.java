import org.example.evencheck;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class EvenchechTest
{
    evencheck e = new evencheck();
    @ParameterizedTest
    @ValueSource(ints = {2 , 4 ,6 ,8 ,10})
    public void test(int n)
    {
        assertTrue(e.check(n));
    }
}
