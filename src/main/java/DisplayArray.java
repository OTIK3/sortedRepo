import sorts.Sort;

public class DisplayArray {

    public static void output(Sort sort){
        System.out.println("Массив до: ");
        sort.getArray().forEach(v -> System.out.print(v + " "));
        System.out.println("\nМассив после: ");

        sort.sort();
        sort.getSortedArray().forEach(v -> System.out.print(v + " "));
    }

//    @SneakyThrows
//    public static void outputFromFile(Sort sort){
//        System.out.println("\nСортировка массива из файла: ");
//        if (sort.getSortedArray() == null){
//            sort.sort();
//        }
//
//        System.out.println("Массив до: ");
//        ActiveFile.inputArrayToFile(sort.getArray());
//        ActiveFile.outputFile();
//        System.out.println("\nМассив после: ");
//        ActiveFile.inputArrayToFile(sort.getSortedArray());
//        ActiveFile.outputFile();
//    }
}
