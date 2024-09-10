import sorts.Sort;
import sorts.enums.SortsEnum;
import sorts.support.Correct;
import sorts.support.FabricSorts;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class StartChoice {
    public static void start() throws IOException {
        Scanner in = new Scanner(System.in);
        Sort sort;
        List<SortsEnum> enums = List.of(SortsEnum.values());

        System.out.println("\n\nДобро пожаловать в меню выбора сортировок!\n");
        while(true){
            int choiceValue;
            System.out.println("\nВыберите сортировку (0 -> выход):");
            enums.forEach(v -> System.out.println("\t " + v.getIndex() + " -> " + v.getName()));
            System.out.print("\t -> ");
            do choiceValue = in.nextInt();
            while (choiceValue < 0 || choiceValue > enums.size());

            if (choiceValue == 0) break;

            int size, bound;
            System.out.println("\nВыберите количество элементов и диапазон значение от 0 до ...");

            System.out.print("\t Количество элементов -> ");
            do size = in.nextInt();
            while(size <= 0);

            System.out.print("\t Диапазон значений -> ");
            bound = in.nextInt();

            sort = FabricSorts.getSortByIndex(choiceValue, size, bound);

            boolean isFileActive;
            System.out.print("\nВыберите вывод в консоль или файл (1 - файл, 0 - консоль): ");
            int activeFile = in.nextInt();
            isFileActive = activeFile > 0;

            boolean isTimed;
            System.out.print("Выводить-ли скорость выполнения сортировки (1 - да, 0 - нет): ");
            int time = in.nextInt();
            isTimed = time > 0;

            System.out.println("\n---> Начинается сортировка...");
            long startTime = System.nanoTime();
            sort.sort();
            long endTime = System.nanoTime();
            long runTime = endTime - startTime;
            System.out.println("---> Сортировка закончилась...");

            System.out.println("---> Идет вывод в зависимости от выбранных данных:");
            if (isFileActive)
                ActiveFile.inputArrayToFile(sort);
            else
                DisplayArray.output(sort);

            if (isTimed)
                System.out.println("\nВремя выполнения алгоритма: " + runTime + "n/s (" + runTime/1e6 + "m/s)");

            System.out.println("\n\t Данные проверены и они" +
                    (Correct.isValidSortArray(sort.getSortedArray()) ? " ": " не ") + "корректны");
            System.out.println("\t Количество элементов до и после сортировки -> " +
                    sort.getArray().size() + " : " + sort.getSortedArray().size());
            System.out.println("\t Данные записаны, если выбрали файл, то можете в него посмотреть\n");
        }
    }
}
