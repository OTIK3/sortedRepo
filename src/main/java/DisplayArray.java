import sorts.InternalSort;

public class DisplayArray {
    public static void output(InternalSort internalSort){
        System.out.println("Массив до: ");
        System.out.println(internalSort.getArray());
        System.out.println("\nМассив после: ");
        System.out.println(internalSort.getSortedArray());
    }
}
