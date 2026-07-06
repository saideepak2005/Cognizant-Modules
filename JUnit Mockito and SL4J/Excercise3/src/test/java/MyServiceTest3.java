import org.example.ExternalApi3;
import org.example.MyService3;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MyServiceTest3
{
    @Test
    public void testVoidMethod()
    {
        ExternalApi3 mockApi = mock(ExternalApi3.class);

        doNothing().when(mockApi).sendData("Mockito");

        MyService3 service = new MyService3(mockApi);

        service.process();

        verify(mockApi).sendData("Mockito");
    }
}