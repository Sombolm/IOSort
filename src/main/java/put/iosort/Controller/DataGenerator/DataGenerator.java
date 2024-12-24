package put.iosort.Controller.DataGenerator;

import org.springframework.stereotype.Service;

@Service
public class DataGenerator {

    public  int[] generateRandomIntArray(){
        int size = (int) (Math.random() * 100);
        int[] array = new int[size];
        
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        
        return array;
    }
    
    public  float[] generateRandomFloatArray(){
        int size = (int) (Math.random() * 100);
        float[] array = new float[size];
        
        for (int i = 0; i < size; i++) {
            array[i] = (float) (Math.random() * 1000);
        }
        
        return array;
    }
    
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
