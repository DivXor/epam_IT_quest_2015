package kz.epam.quiz.dao;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ContainsTest {

    @Test
    public void testName() throws Exception {
        String test = "some sentence";
        boolean tence = test.contains("tence");
        boolean sentn = test.contains("sentn");
        assertTrue(tence);
        assertFalse(sentn);
    }
}
