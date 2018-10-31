import java.util.HashMap;
import java.util.LinkedList;

class Bucket_Sort{

    public static int[] sort(int[] numbers, int low, int high){
        int[] sorted = new int[numbers.length];
        HashMap<Integer, LinkedList<Integer>> buckets = new HashMap<Integer, LinkedList<Integer>>();
        for(int i = low; i < high + 1; i++){
            buckets.put(i, new LinkedList<Integer>());
        }

        for(int i = 0; i < numbers.length; i++){
            int current = numbers[i];
            buckets.get(current).add(current);
        }

        int sorted_index = 0;
        for(LinkedList<Integer> bucket : buckets.values()){
            if(!bucket.isEmpty()){
                for(int i : bucket){
                    sorted[sorted_index] = i;
                    sorted_index ++;
                }
            }
        }

        return sorted;
    }











}