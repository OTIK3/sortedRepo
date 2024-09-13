import sorts.Sort;

public class DisplayArray {
    public static void output(Sort sort){
        System.out.println("Массив до: ");
        System.out.println(sort.getArray());
        System.out.println("\nМассив после: ");
        System.out.println(sort.getSortedArray());
    }
}
