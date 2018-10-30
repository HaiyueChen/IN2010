import java.util.Arrays;

class Main{

    public static void main(String[] args) {
        int[] asc = new int[] {1, 2, 3 ,4};
        int[] desc = new int[] {4, 3, 2, 3, 2, 5, 2, 2, 1};
        int[] random = new int[] {3, 4, 1, 2};


        //Selection sort
        /*
        int[] original_selection = desc;

        int[] sorted_selection = Selection_Sort.Sort(original_selection);
        System.out.println("\nIs Sorted: " + check(sorted_selection));
        System.out.println("\nSorted array: " + Arrays.toString(sorted_selection));
        System.out.println("Original array: " + Arrays.toString(original_selection) + "\n");
        */
        ////////////////////////////////////////////////////////////////////////

        //Insertion sort
        int[] original_insertion = desc;
        int[] sorted_insertion = Insertion_Sort.sort(original_insertion);
        System.out.println("\nIs Sorted: " + check(sorted_insertion));
        System.out.println("\nSorted array: " + Arrays.toString(sorted_insertion));
        System.out.println("Original array: " + Arrays.toString(original_insertion) + "\n");
    
        ////////////////////////////////////////////////////////////////////////
    
    
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