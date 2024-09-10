import sorts.Sort;

public class DisplayArray {
    public static void output(Sort sort){
        System.out.println("Массив до: ");
        sort.getArray().forEach(v -> System.out.print(v + " "));
        System.out.println("\nМассив после: ");

        sort.sort();
        sort.getSortedArray().forEach(v -> System.out.print(v + " "));
    }
}
