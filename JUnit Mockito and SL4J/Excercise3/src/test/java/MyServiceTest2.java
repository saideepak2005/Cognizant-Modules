package org.example;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class MyServiceTest2 {

    @Test
    public void testArgumentMatcher() {

        ExternalApi2 mockApi = mock(ExternalApi2.class);

        MyService2 service = new MyService2(mockApi);
        service.process();
        verify(mockApi).FindData(anyString());

    }
}