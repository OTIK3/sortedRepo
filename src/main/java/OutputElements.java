import lombok.SneakyThrows;
import sortClasses.Sort;

public class OutputElements {

    public static void output(Sort sort){
        System.out.println("Массив до: ");
        sort.getArray().forEach(v -> System.out.print(v + " "));
        System.out.println("\nМассив после: ");

        long startTime = System.nanoTime();
        sort.sort();
        sort.getSortedArray().forEach(v -> System.out.print(v + " "));
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("\nМетод выполнился за " + duration + " наносекунд.");
    }

    @SneakyThrows
    public static void outputFromFile(Sort sort){
        System.out.println("\nСортировка массива из файла: ");
        if (sort.getSortedArray() == null){
            sort.sort();
        }

        System.out.println("Массив до: ");
        ActiveFile.inputArrayToFile(sort.getArray());
        ActiveFile.outputFile();
        System.out.println("\nМассив после: ");
        ActiveFile.inputArrayToFile(sort.getSortedArray());
        ActiveFile.outputFile();
    }
}
