import org.example.NetworkClient4;
import org.example.NetworkService4;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class NetworkServiceTest4
{
    @Test
    public void testServiceWithMockNetworkClient()
    {
        NetworkClient4 mockNetworkClient = mock(NetworkClient4.class);

        when(mockNetworkClient.connect()).thenReturn("Mock Connection");

        NetworkService4 networkService = new NetworkService4(mockNetworkClient);

        String result = networkService.connectToServer();

        assertEquals("Connected to Mock Connection", result);
    }
}