import java.util.Arrays;

class Quick_Sort{

    public static int[] sort(int[] numbers){
        int[] sorted = numbers.clone();
        quicksort(sorted, 0, sorted.length -1);
        return sorted;
    }

    public static void quicksort(int[] numbers, int left, int right){
        if(left >= right){
            return;
        }
        int pivot_index = partition(numbers, left, right);
        quicksort(numbers, left, pivot_index - 1);
        quicksort(numbers, pivot_index + 1, right);
    }

    public static int partition(int[] numbers, int lower, int higher){
        int l_index = lower;
        int r_index = higher;
        int p_index = randIntRange(l_index, r_index);
        int pivot = numbers[p_index];

        //int pivot = numbers[numbers.length - 1];

        numbers[p_index] = numbers[r_index];
        numbers[r_index] = pivot;
        r_index --;
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
        
        int to_swap = numbers[l_index];
        numbers[l_index] = pivot;
        numbers[higher] = to_swap;
        return l_index;
    }

    public static int randIntRange(int lower, int higher){
        int x = (int)(Math.random() * ((higher - lower) + 1)) + lower;
        return x;
    }

}