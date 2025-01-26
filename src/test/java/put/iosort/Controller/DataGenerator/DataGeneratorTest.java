package put.iosort.Controller.DataGenerator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DataGeneratorTest {

    @Autowired
    private DataGenerator dataGenerator;

    @Test
    void testGenerateRandomIntArray_NotNull() {
        int[] result = dataGenerator.generateRandomIntArray();
        assertNotNull(result, "Generated int array should not be null.");
    }

    @Test
    void testGenerateRandomIntArray_ValidSize() {
        int[] result = dataGenerator.generateRandomIntArray();
        assertTrue(result.length > 0 && result.length <= 100, "Generated int array size should be between 1 and 100.");
    }

    @Test
    void testGenerateRandomIntArray_ValidElements() {
        int[] result = dataGenerator.generateRandomIntArray();
        for (int value : result) {
            assertTrue(value >= 0 && value < 1000, "Each element in the int array should be between 0 and 999.");
        }
    }

    @Test
    void testGenerateRandomIntArray_UniqueResults() {
        int[] result1 = dataGenerator.generateRandomIntArray();
        int[] result2 = dataGenerator.generateRandomIntArray();
        assertNotEquals(result1, result2, "Consecutive executions should generate different int arrays.");
    }

    @Test
    void testGenerateRandomFloatArray_NotNull() {
        float[] result = dataGenerator.generateRandomFloatArray();
        assertNotNull(result, "Generated float array should not be null.");
    }

    @Test
    void testGenerateRandomFloatArray_ValidSize() {
        float[] result = dataGenerator.generateRandomFloatArray();
        assertTrue(result.length > 0 && result.length <= 100, "Generated float array size should be between 1 and 100.");
    }

    @Test
    void testGenerateRandomFloatArray_ValidElements() {
        float[] result = dataGenerator.generateRandomFloatArray();
        for (float value : result) {
            assertTrue(value >= 0 && value < 1000, "Each element in the float array should be between 0 and 999.");
        }
    }

    @Test
    void testGenerateRandomFloatArray_UniqueResults() {
        float[] result1 = dataGenerator.generateRandomFloatArray();
        float[] result2 = dataGenerator.generateRandomFloatArray();
        assertNotEquals(result1, result2, "Consecutive executions should generate different float arrays.");
    }

    @Test
    void testGenerateRandomStringArray_NotNull() {
        String[] result = dataGenerator.generateRandomStringArray();
        assertNotNull(result, "Generated string array should not be null.");
    }

    @Test
    void testGenerateRandomStringArray_ValidSize() {
        String[] result = dataGenerator.generateRandomStringArray();
        assertTrue(result.length > 0 && result.length <= 100, "Generated string array size should be between 1 and 100.");
    }

    @Test
    void testGenerateRandomStringArray_ValidElements() {
        String[] result = dataGenerator.generateRandomStringArray();
        for (String value : result) {
            assertNotNull(value, "Each string in the array should not be null.");
            assertTrue(value.length() <= 10, "Each string size should not exceed 10 characters.");
        }
    }

    @Test
    void testGenerateRandomStringArray_UniqueResults() {
        String[] result1 = dataGenerator.generateRandomStringArray();
        String[] result2 = dataGenerator.generateRandomStringArray();
        assertNotEquals(result1, result2, "Consecutive executions should generate different string arrays.");
    }
}