import org.example.ExternalApi7;
import org.example.MyService7;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class MyServiceTest7
{
    @Test
    public void testVoidMethodException()
    {
        ExternalApi7 mockApi = mock(ExternalApi7.class);

        doThrow(new RuntimeException("Exception"))
                .when(mockApi)
                .sendData();

        MyService7 service = new MyService7(mockApi);

        assertThrows(RuntimeException.class, () -> {
            service.process();
        });

        verify(mockApi).sendData();
    }
}