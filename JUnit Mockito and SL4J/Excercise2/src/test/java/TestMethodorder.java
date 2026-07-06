import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestMethodorder
{
    @Test
    @Order(1)
    public void one()
    {
        System.out.println("First one");
    }
    @Test
    @Order(2)
    public void two()
    {
        System.out.println("second one");
    }
    @Test
    @Order(3)
    public void three()
    {
        System.out.println("third one");
    }
}
