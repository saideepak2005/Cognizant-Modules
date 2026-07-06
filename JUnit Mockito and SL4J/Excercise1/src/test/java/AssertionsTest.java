//package org.sample;
import static org.junit.Assert.*;
import org.junit.Test;
public class AssertionsTest
{
    @Test
    public void TestAssertions()
    {
        assertEquals(5 , 1+4);
        assertTrue(6>4);
        assertFalse(2==6);
        assertNull(null);
        assertNotNull(new Object());
    }
}