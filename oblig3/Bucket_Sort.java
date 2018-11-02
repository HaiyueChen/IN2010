import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

class Bucket_Sort{

    public static int[] sort(int[] numbers, int low, int high){
        int[] sorted = new int[numbers.length];
        //System.out.println(Arrays.toString(numbers));
        int off_set = -low;
        int[] buckets = new int[high - low + 1];
        for(int i = 0; i < (high - low); i++){
            buckets[i] = 0; 
        }

        for(int i = 0; i < numbers.length; i++){
            int current = numbers[i];
            buckets[current + off_set] += 1;
        }

        int sorted_index = 0;
        for(int i = 0; i < buckets.length; i++){
            for(int j =0; j < buckets[i]; j++){
                sorted[sorted_index] = i - off_set;
                sorted_index ++;
            }
        }

        return sorted;
    }











}