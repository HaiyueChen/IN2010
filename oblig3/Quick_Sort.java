class Quick_Sort{

    public static int[] sort(int[] numbers){
        int[] sorted = numbers.clone();
        
        sorted = quicksort(sorted, 0, sorted.length -1);
        return sorted;
    }

    public static int[] quicksort(int[] numbers, int left, int right){
        return numbers;
    }

    public static int partition(int[] numbers, int l_index, int r_index){
        int p_index = randIntRange(l_index, r_index);
        int pivot = numbers[p_index];

        numbers[p_index] = numbers[r_index];
        numbers[r_index] = pivot; 

        while(l_index <= r_index){
            while(l_index <= r_index && numbers[l_index] <= pivot){
                l_index ++;
            }
            while(r_index >= l_index && numbers[r_index] >= pivot){
                r_index --;
            }

            if(l_index < r_index){
                int to_swap = numbers[l_index];
                numbers[l_index] = numbers[r_index];
                numbers[r_index] = to_swap;
            }
        }
        


        return l_index;
    }

    public static int randIntRange(int lower, int higher){
        int x = (int)(Math.random() * ((higher - lower) + 1)) + lower;
        return x;
    }

}