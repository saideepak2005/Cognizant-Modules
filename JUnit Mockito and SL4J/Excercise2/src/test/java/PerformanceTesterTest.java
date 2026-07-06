import static org.junit.jupiter.api.Assertions.*;

import org.example.PerformanceTester;
import org.junit.jupiter.api.Test;
import java.time.Duration;
public class PerformanceTesterTest
{
    @Test
    public void Testperformance()
    {
        PerformanceTester p = new PerformanceTester();
        assertTimeout(Duration.ofSeconds(5) , ()-> {
            p.performTask();
        });
    }
}
