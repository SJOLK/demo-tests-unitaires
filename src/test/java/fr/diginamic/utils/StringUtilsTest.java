package fr.diginamic.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void testNominalCases() {
        // Simple insert, delete, and substitution cases
        assertEquals(1, StringUtils.levenshteinDistance("chat", "chats"));
        assertEquals(1, StringUtils.levenshteinDistance("machins", "machine"));
        assertEquals(1, StringUtils.levenshteinDistance("aviron", "avion"));
        assertEquals(2, StringUtils.levenshteinDistance("distance", "instance"));
        assertEquals(2, StringUtils.levenshteinDistance("Chien", "Chine"));
    }

    @Test
    public void testEdgeCases() {
        // Case sensitivity test
        assertEquals(1, StringUtils.levenshteinDistance("Java", "java"));

        // Empty strings
        assertEquals(0, StringUtils.levenshteinDistance("", ""));
        assertEquals(4, StringUtils.levenshteinDistance("test", ""));
        assertEquals(4, StringUtils.levenshteinDistance("", "test"));
    }

    @Test
    public void testNullInputs() {
        // Expect NullPointerException when passing null inputs
        assertThrows(NullPointerException.class, () -> {
            StringUtils.levenshteinDistance(null, "test");
        });
        assertThrows(NullPointerException.class, () -> {
            StringUtils.levenshteinDistance("test", null);
        });
        assertThrows(NullPointerException.class, () -> {
            StringUtils.levenshteinDistance(null, null);
        });
    }
}
