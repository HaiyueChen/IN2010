import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

class Bucket_Sort{

    public static int[] sort(int[] numbers, int low, int high){
        int[] sorted = new int[numbers.length];
        //System.out.println(Arrays.toString(numbers));
        HashMap<Integer, Integer> buckets = new HashMap<Integer, Integer>();
        for(int i = low; i < high + 1; i++){
            buckets.put(i, 0);
        }



        for(int i = 0; i < numbers.length; i++){
            int current = numbers[i];
            if(buckets.get(current) == null){
                System.out.println(current);
                System.out.println(buckets.get(current));
                break;
            }
            //buckets.put(current, buckets.get(current) + 1);
        }

        int sorted_index = 0;
        for(int key : buckets.keySet()){
            if(buckets.get(key) > 0){
                for(int i = 0; i < buckets.get(key); i++){
                    sorted[sorted_index] = key;
                    sorted_index ++;
                }

            }
        }

        return sorted;
    }











}