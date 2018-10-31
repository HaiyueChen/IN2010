import java.util.Arrays;

class Selection_Sort{

    public static int[] Sort(int[] numbers){
        int[] sorted = numbers.clone();
        for(int i = 0; i < sorted.length; i++){
            System.out.println(Arrays.toString(sorted));
            int smallest_index = smallest_index(sorted, i);
            int smallest_num = sorted[smallest_index];
            if(sorted[i] > sorted[smallest_index]){
                smallest_num = sorted[smallest_index];
                sorted[smallest_index] = sorted[i];
                sorted[i] = smallest_num;
                
            }
            else{
                if(sorted[i] == sorted[smallest_index]){
                    while(sorted[i] == sorted[smallest_index] 
                          && i < sorted.length
                          && i < smallest_index){
                            i ++;
                            if(sorted[i] > sorted[smallest_index]){
                                smallest_num = sorted[smallest_index];
                                sorted[smallest_index] = sorted[i];
                                sorted[i] = smallest_num;
                                break;
                            }
                    }
                } 
                else{
                    continue;
                }
            }
        }
        

        return sorted;

    }

    public static int smallest_index(int[] numbers, int current_index){
        int smallest_index = current_index;
        for(int i = current_index; i < numbers.length; i++){
            if(numbers[i] < numbers[smallest_index]){
                smallest_index = i;

            }
        }
        return smallest_index;
    }



    
}