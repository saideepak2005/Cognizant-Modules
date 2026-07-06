import org.example.ExternalApi5;
import org.example.MyService5;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MyServiceTest5
{
    @Test
    public void testMultipleReturns()
    {
        ExternalApi5 mockApi = mock(ExternalApi5.class);

        when(mockApi.getdata())
                .thenReturn("First")
                .thenReturn("Second")
                .thenReturn("Third");

        MyService5 service = new MyService5(mockApi);

        assertEquals("First", service.fetchdata());
        assertEquals("Second", service.fetchdata());
        assertEquals("Third", service.fetchdata());
    }
}