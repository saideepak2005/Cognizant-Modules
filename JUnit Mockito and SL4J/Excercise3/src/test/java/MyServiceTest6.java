import org.example.ExternalApi6;
import org.example.MyService6;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class MyServiceTest6
{
    @Test
    public void testInteractionOrder()
    {
        ExternalApi6 mockApi = mock(ExternalApi6.class);

        MyService6 service = new MyService6(mockApi);

        service.process();

        InOrder inOrder = inOrder(mockApi);

        inOrder.verify(mockApi).firstMethod();
        inOrder.verify(mockApi).secondMethod();
    }
}