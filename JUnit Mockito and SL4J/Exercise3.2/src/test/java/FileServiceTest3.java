import org.example.FileReader3;
import org.example.FileService3;
import org.example.FileWriter3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FileServiceTest3
{
    @Test
    public void testServiceWithMockFileIO()
    {
        FileReader3 mockFileReader = mock(FileReader3.class);
        FileWriter3 mockFileWriter = mock(FileWriter3.class);

        when(mockFileReader.read()).thenReturn("Mock File Content");

        FileService3 fileService = new FileService3(mockFileReader, mockFileWriter);

        String result = fileService.processFile();

        assertEquals("Processed Mock File Content", result);

        verify(mockFileWriter).write("Mock File Content");
    }
}