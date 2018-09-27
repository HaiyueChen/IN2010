import java.lang.reflect.Array;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BSTtest{

    public static void main(String[] args) {
        
        BSTree<Integer> t = new BSTree<>();
       // Random r = new Random();
       // int temp = 0;

        //int[] numbers = new int[] { 8, 3, 5, 96, 10, 12, 18, 38, 48, 50, 71, 71, 26, 79, 81, 85, 88, 89, 18, 97};
        
        System.out.println("Test remove");
        int[] numbers = new int[] { 10, 5, 15, 3, 7, 12, 17, 6};
        ArrayList<Integer> asList = new ArrayList<>();
        for(int i = 0; i < numbers.length; i ++){
            asList.add(numbers[i]);
        }
        t.addAll(asList);
        
        //t.remove(10);

        ArrayList<Integer> sorted = t.sortedArrayList();
        for (int itt : sorted) {
            System.out.print(itt + "  ");
        }
        System.out.println("\nsize: " + t.size());

        System.out.println(t.findNearestSmallerThan(7));

       /*

        t.remove(8);
        sorted = t.sortedArrayList();
        for (int itt : sorted) {
            System.out.print(itt + "  ");
        }
        System.out.println("\nsize: " + t.size());



        t.remove(3);
        sorted = t.sortedArrayList();
        for (int itt : sorted) {
            System.out.print(itt + "  ");
        }
        System.out.println("\nsize: " + t.size());



        t.remove(5);
        sorted = t.sortedArrayList();
        for (int itt : sorted) {
            System.out.print(itt + "  ");
        }
        System.out.println("\nsize: " + t.size());

        System.out.println("Remove non-existent value");
        System.out.println(t.remove(1));
        System.out.println("Test remove done");
        System.out.println("------------------------");
        System.out.println("------------------------");

        System.out.println("Test findInRange 25 90");
        ArrayList<Integer> inrange = t.findInRange(25, 90);
        for(int temp : inrange){
            System.out.print(temp + "  ");
        }
        System.out.println("inrange size : " + inrange.size());
        System.out.println("Test findInRange done");
        System.out.println("------------------------");
        System.out.println("------------------------");

        System.out.println("Test nearest smallest than 37");
        int nearest = t.findNearestSmallerThan(37);
        System.out.println(nearest);

        */
    }


}
