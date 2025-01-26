package put.iosort.Controller.DataGenerator;

import org.springframework.stereotype.Service;

/**
 * The {@code DataGenerator} class provides methods to generate random data arrays of integers, floats, and strings.
 * This service can be used to supply random test data for sorting operations.
 *
 * <p>Features:</p>
 * <ul>
 *     <li>Generates random integer arrays with random sizes and values.</li>
 *     <li>Generates random float arrays with random sizes and values.</li>
 *     <li>Generates random string arrays with random sizes and random alphanumeric content.</li>
 * </ul>
 *
 * <p>Purpose:</p>
 * <ul>
 *     <li>Facilitates testing and demonstrations by providing random input data for sorting endpoints.</li>
 * </ul>
 *
 * @author caprimol
 * @version 1.0
 * @since 2025-01-27
 */

@Service
public class DataGenerator {

    /**
     * Generates a random integer array.
     *
     * <p>The size of the array is a random number between 0 and 100. Each integer in the array
     * is a random number between 0 and 1000.</p>
     *
     * @return an integer array populated with random values.
     */
    public  int[] generateRandomIntArray(){
        int size = (int) (Math.random() * 100);
        int[] array = new int[size];
        
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        
        return array;
    }

    /**
     * Generates a random float array.
     *
     * <p>The size of the array is a random number between 0 and 100. Each float in the array
     * is a random number between 0 and 1000.</p>
     *
     * @return a float array populated with random values.
     */
    public  float[] generateRandomFloatArray(){
        int size = (int) (Math.random() * 100);
        float[] array = new float[size];
        
        for (int i = 0; i < size; i++) {
            array[i] = (float) (Math.random() * 1000);
        }
        
        return array;
    }

    /**
     * Generates a random string array.
     *
     * <p>The size of the array is a random number between 0 and 100. Each string in the array is
     * composed of a random number of lowercase alphabetic characters (between 1 and 10).</p>
     *
     * @return a string array populated with random alphabetic strings.
     */
    public  String[] generateRandomStringArray(){
        int size = (int) (Math.random() * 100);
        String[] array = new String[size];
        
        for (int i = 0; i < size; i++) {
            int stringSize = (int) (Math.random() * 10);
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < stringSize; j++) {
                sb.append((char) ((int) (Math.random() * 26) + 97));
            }
            array[i] = sb.toString();
        }
        
        return array;
    }


}
