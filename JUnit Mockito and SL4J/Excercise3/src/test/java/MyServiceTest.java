import org.example.ExternalApi;
import org.example.MyService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class MyServiceTest
{
    @Test
    public void Externalapi()
    {
        ExternalApi mockapi = mock(ExternalApi.class);
        when( mockapi.getdata()).thenReturn("Mock Data");
        MyService s = new MyService(mockapi);
        String r = s.fetchdata();
        verify(mockapi).getdata();
        assertEquals("Mock Data" ,r);
    }
}
