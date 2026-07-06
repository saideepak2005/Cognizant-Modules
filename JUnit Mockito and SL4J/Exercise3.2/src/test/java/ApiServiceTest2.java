import org.example.ApiService2;
import org.example.RestClient2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ApiServiceTest2
{
    @Test
    public void testServiceWithMockRestClient()
    {
        RestClient2 mockRestClient = mock(RestClient2.class);

        when(mockRestClient.getResponse()).thenReturn("Mock Response");

        ApiService2 apiService = new ApiService2(mockRestClient);

        String result = apiService.fetchData();

        assertEquals("Fetched Mock Response", result);
    }
}