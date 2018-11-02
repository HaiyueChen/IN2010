import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

class Main{

    public static void main(String[] args) {

        LinkedList<int[]> asc = new LinkedList<>();
        LinkedList<int[]> desc = new LinkedList<>();
        LinkedList<int[]> rand = new LinkedList<>();


        int size = 10000;
        for(int i = 0; i < 5; i++){
            asc.add(gen_asc(size));
            size *= 5;
        }


        size = 10000;
        for(int i = 0; i < 5; i++){
            desc.add(gen_desc(size));
            size *= 5;
        }

        size = 10000;
        int lower = -100000000;
        int higher = 100000000;
        for(int i = 0; i < 5; i++){
            rand.add(gen_rand(size, lower, higher));
            size *= 5;
        }

        //Selection sort
        /*
        int[] original_selection = random;
        int[] sorted_selection = Selection_Sort.Sort(original_selection);
        System.out.println("\nIs Sorted: " + check(sorted_selection));
        System.out.println("\nSorted array: " + Arrays.toString(sorted_selection));
        System.out.println("Original array: " + Arrays.toString(original_selection) + "\n");
        */

        
        //System.out.println("--------------\nSelection sort:");
        /*
        System.out.println("\nAscending:");
        for(int[] arr : asc){
            long t = System.nanoTime();
            Selection_Sort.sort(arr);
            double run_time = (System.nanoTime() - t) / 1000000;
            System.out.println("Nr. elements: " + arr.length + " Runtime: " + run_time);
        }

        System.out.println("\nDecending:");
        for (int[] arr : desc) {
            long t = System.nanoTime();
            Selection_Sort.sort(arr);
            double run_time = (System.nanoTime() - t) / 1000000;
            System.out.println("Nr. elements: " + arr.length + " Runtime: " + run_time);
        }
        System.out.println("\nRandom:");
        for (int[] arr : rand) {
            long t = System.nanoTime();
            Selection_Sort.sort(arr);
            double run_time = (System.nanoTime() - t) / 1000000;
            System.out.println("Nr. elements: " + arr.length + " Runtime: " + run_time);
        }
        */
        
        ////////////////////////////////////////////////////////////////////////

        //Insertion sort
        /*
        int[] original_insertion = random;
        int[] sorted_insertion = Insertion_Sort.sort(original_insertion);
        System.out.println("\nIs Sorted: " + check(sorted_insertion));
        System.out.println("\nSorted array: " + Arrays.toString(sorted_insertion));
        System.out.println("Original array: " + Arrays.toString(original_insertion) + "\n");
        */

        
        //System.out.println("--------------\nInsertion sort:");
        /*
        System.out.println("\nAscending:");
        for (int[] arr : asc) {
            long t = System.nanoTime();
            Insertion_Sort.sort(arr);
            double run_time = (System.nanoTime() - t) / 1000000;
            System.out.println("Nr. elements: " + arr.length + " Runtime: " + run_time);
        }

        System.out.println("\nDecending:");
        for (int[] arr : desc) {
            long t = System.nanoTime();
            Insertion_Sort.sort(arr);
            double run_time = (System.nanoTime() - t) / 1000000;
            System.out.println("Nr. elements: " + arr.length + " Runtime: " + run_time);
        }
        System.out.println("\nRandom:");
        for (int[] arr : rand) {
            long t = System.nanoTime();
            Insertion_Sort.sort(arr);
            double run_time = (System.nanoTime() - t) / 1000000;
            System.out.println("Nr. elements: " + arr.length + " Runtime: " + run_time);
        }
        */
        
        ////////////////////////////////////////////////////////////////////////
        
        //Quick sort
        /*
        int[] original_quick = fuck;
        int[] sorted_quick = Quick_Sort.sort(original_quick);
        System.out.println("\nIs Sorted: " + check(sorted_quick));
        */
        //System.out.println("\nSorted array: " + Arrays.toString(sorted_quick));
        //System.out.println("Original array: " + Arrays.toString(original_quick) + "\n");
        
        //System.out.println("--------------\nQuick sort:");
        /*
        System.out.println("\nAscending:");
        for (int[] arr : asc) {
            long t = System.nanoTime();
            Quick_Sort.sort(arr);
            double run_time = (System.nanoTime() - t) / 1000000;
            System.out.println("Nr. elements: " + arr.length + " Runtime: " + run_time);
        }

        System.out.println("\nDecending:");
        for (int[] arr : desc) {
            long t = System.nanoTime();
            Quick_Sort.sort(arr);
            double run_time = (System.nanoTime() - t) / 1000000;
            System.out.println("Nr. elements: " + arr.length + " Runtime: " + run_time);
        }
        
        System.out.println("\nRandom:");
        for (int[] arr : rand) {
            long t = System.nanoTime();
            Quick_Sort.sort(arr);
            double run_time = (System.nanoTime() - t) / 1000000;
            System.out.println("Nr. elements: " + arr.length + " Runtime: " + run_time);
        }
        
        */

        ////////////////////////////////////////////////////////////////////////
    
        //Bucket sort
        /*
        int[] original_bucket = random; 
        int[] sorted_bucket = Bucket_Sort.sort(original_bucket, 1, 4);
        System.out.println("\nIs Sorted: " + check(sorted_bucket)); 
        System.out.println("\nSorted array: " + Arrays.toString(sorted_bucket));
        System.out.println("Original array: " + Arrays.toString(original_bucket) + "\n");
        */
        System.out.println("--------------\nBucket sort:");
        
        System.out.println("\nAscending:");
        for (int[] arr : asc) {
            long t = System.nanoTime();
            int[] sorted = Bucket_Sort.sort(arr, 0, arr.length);
            double run_time = (System.nanoTime() - t) / 1000000;
            System.out.println("Nr. elements: " + arr.length + " Runtime: " + run_time);
            System.out.println("sorted: " + check(sorted));
        }
        
        System.out.println("\nDecending:");
        for (int[] arr : desc) {
            long t = System.nanoTime();
            int[] sorted = Bucket_Sort.sort(arr, 0, arr.length);
            double run_time = (System.nanoTime() - t) / 1000000;
            System.out.println("Nr. elements: " + arr.length + " Runtime: " + run_time);
            System.out.println("sorted: " + check(sorted));
        }
        System.out.println("\nRandom:");
        for (int[] arr : rand) {
            long t = System.nanoTime();
            int[] sorted = Bucket_Sort.sort(arr, lower, higher);
            double run_time = (System.nanoTime() - t) / 1000000;
            System.out.println("Nr. elements: " + arr.length + " Runtime: " + run_time);
            System.out.println("sorted: " + check(sorted));
            //System.out.println(Arrays.toString(sorted));
        }
        
        ////////////////////////////////////////////////////////////////////////

        //Array sort
        /*
        System.out.println("Arrays.sort()");
        System.out.println("Ascending");
        for (int[] arr : asc) {
            long t = System.nanoTime();
            Arrays.sort(arr);
            double run_time = (System.nanoTime() - t) / 1000000;
            System.out.println("Nr. elements: " + arr.length + " Runtime: " + run_time);
        }

        System.out.println("Descending");
        for (int[] arr : desc) {
            long t = System.nanoTime();
            Arrays.sort(arr);
            double run_time = (System.nanoTime() - t) / 1000000;
            System.out.println("Nr. elements: " + arr.length + " Runtime: " + run_time);
        }

        System.out.println("Random");
        for (int[] arr : rand) {
            long t = System.nanoTime();
            Arrays.sort(arr);
            double run_time = (System.nanoTime() - t) / 1000000;
            System.out.println("Nr. elements: " + arr.length + " Runtime: " + run_time);
        }
        */

    }


    public static int[] gen_asc(int size){
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = i;
        }
        return arr;
    }

    public static int[] gen_desc(int size) {
        int[] arr = new int[size];
        for (int i = size - 1; i > - 1; i--) {
            arr[i] = i;
        }
        return arr;
    }

    public static int[] gen_rand(int size, int lower, int higher){
        Random rand = new Random();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = lower + rand.nextInt(higher);
        }
        return arr;
    }

    public static boolean check(int[] to_check){
        if(to_check.length == 0){
            return false;
        }

        int smaller = to_check[0];
        for(int i = 1; i < to_check.length; i++){
            if(to_check[i] < smaller){
                return false;
            }
            smaller = to_check[i];
        }
        return true;

    }



}