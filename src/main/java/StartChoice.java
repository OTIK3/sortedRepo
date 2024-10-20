import lombok.SneakyThrows;
import sorts.InternalSort;
import sorts.Sort;
import sorts.enums.SortsEnum;
import sorts.init.NaturalExternalSort;
import sorts.support.Correct;
import sorts.support.FabricSorts;

import java.util.List;
import java.util.Scanner;

public class StartChoice {
    private static final Scanner in = new Scanner(System.in);
    private static final List<SortsEnum> enums = List.of(SortsEnum.values());
    private static InternalSort internalSort;
    private static int choiceValue;
    private static boolean isFile, isTimed;
    private static int index;
    private static int size;
    private static int bound;
    private static boolean isUnique = false;

    @SneakyThrows
    public static void start(){
        System.out.println("\n\nДобро пожаловать в меню выбора сортировок!\n");
        System.out.print("Выберите какие сортировки использовать (0 -> внешние, 1 -> внутренние): ");
        while(true){
            int choiceSort = in.nextInt();
            if (choiceSort != 0){
                choiceSort();
                initSizeBoundUnique();
                choiceOutput();
                sortAndOutput();

                boolean isActive;
                do  isActive = repeatMenu();
                while (isActive);
            }
            else
                startNaturalSort();
        }
    }

    private static void choiceSort(){
        System.out.println("\nВыберите сортировку (0 -> выход):");
        for (int i = 0; i < enums.size(); i++) {
            System.out.println("\t " + (i + 1) + " -> " + enums.get(i).getName());
        }
        System.out.print("\t -> ");
        do index = in.nextInt();
        while (index < 0 || index > enums.size());
        if (index == 0) System.exit(0);
    }

    private static void initSizeBoundUnique(){
        System.out.println("\nВыберите количество элементов и диапазон значение от 0 до ...");

        System.out.print("\t Количество элементов -> ");
        do size = in.nextInt();
        while(size <= 0);

        System.out.print("\t Диапазон значений -> ");
        bound = in.nextInt();

        if (size <= bound && index != 4){
            System.out.print("\nНужны ли уникальные значения (1 - да, 0 - нет): ");
            isUnique = in.nextInt() > 0;
        }
        else if (index == 4)
            isUnique = true;
    }

    private static void choiceOutput(){
        System.out.print("Выберите вывод в консоль или файл (1 - файл, 0 - консоль): ");
        isFile = in.nextInt() > 0;

        System.out.print("Выводить-ли скорость выполнения сортировки (1 - да, 0 - нет): ");
        isTimed = in.nextInt() > 0;
    }

    private static void sortAndOutput(){
        if (choiceValue == 3)
            internalSort = FabricSorts.getSortByIndexWithArray(index, internalSort.getArray());
        else
            internalSort = isUnique ?
                    FabricSorts.getSortByIndexWithUniqueValues(index, size, bound, true):
                    FabricSorts.getSortByIndex(index, size, bound);

        long runTime = sortTime(internalSort);

        System.out.println("---> Идет вывод в зависимости от выбранных данных:");
        if (isFile)
            ActiveFile.inputArrayToFile(internalSort);
        else
            DisplayArray.output(internalSort);

        if (isTimed) {
            System.out.println("\nВремя выполнения алгоритма: " + runTime + "n/s (" + runTime/1e6 + "m/s)");
        }

        System.out.println("\n\t Данные проверены и они" +
                (Correct.isValidSortArray(internalSort.getSortedArray()) ? " ": " не ") + "корректны");
        System.out.println("\t Количество элементов до и после сортировки -> " +
                internalSort.getArray().size() + " : " + internalSort.getSortedArray().size());
        System.out.println("\t Данные записаны, если выбрали файл, то можете в него посмотреть\n");
    }

    private static boolean repeatMenu(){
        System.out.println("Выберите опцию: ");
        System.out.print(
                "\t0 -> Выйти\n" +
                "\t1 -> Повторить сортировку для новых данных\n" +
                "\t2 -> Повторить сортировку для другой размерности\n" +
                "\t3 -> Выбрать другую сортировку по тем же данным\n" +
                "\t4... -> Вызвать меню выбора\n\t-> "
        );

        choiceValue = in.nextInt();

        boolean isActive = true;
        switch (choiceValue){
            case 0 -> {
                System.exit(1);
            }
            case 1 -> {
                sortAndOutput();
            }
            case 2 -> {
                initSizeBoundUnique();
                sortAndOutput();
            }
            case 3 -> {
                choiceSort();
                sortAndOutput();
            }
            default -> {
                isActive = false;
            }
        }

        return isActive;
    }

    private static void startNaturalSort(){
        System.out.println("Введите название файла с элементами:");
        var fileName = in.next();

        var sort = new NaturalExternalSort(fileName);
        var runTime = sortTime(sort);
        System.out.println("---> Время выполнения сортировки: " + runTime + "n/s (" + runTime/1e6 + "m/s)");
    }

    private static long sortTime(Sort sort){
        System.out.println("\n---> Начинается сортировка " + sort.getClass().getSimpleName() +  " ...");
        long startTime = System.nanoTime();
        sort.sort();
        long endTime = System.nanoTime();
        System.out.println("---> Сортировка закончилась...");
        return endTime - startTime;
    }
}
