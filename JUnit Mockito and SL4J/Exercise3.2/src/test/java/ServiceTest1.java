import org.example.Repository1;
import org.example.Service1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ServiceTest1
{
    @Test
    public void testServiceWithMockRepository()
    {
        Repository1 mockRepository = mock(Repository1.class);

        when(mockRepository.getData())
                .thenReturn("Mock Data");

        Service1 service = new Service1(mockRepository);

        String result = service.processData();

        assertEquals("Processed Mock Data", result);
    }
}