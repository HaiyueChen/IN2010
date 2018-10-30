class Insertion_Sort{

    public static int[] sort(int[] numbers){
        int[] sorted = numbers.clone();
        
        if(sorted.length == 0 || sorted.length == 1){return sorted;}

        for(int i = 1; i < sorted.length; i++){

            int j = i;
            int current = sorted[j];
            while(j > 0 && current < sorted[j-1]){
                sorted[j] = sorted[j - 1];
                j--;
            }
            sorted[j] = current;

        }
        return sorted;
    }

    
}