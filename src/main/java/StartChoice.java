import lombok.SneakyThrows;
import sorts.init.BubbleSort;
import sorts.init.CocktailSort;
import sorts.Sort;

import java.io.IOException;
import java.util.Scanner;

public class StartChoice {
    @SneakyThrows
    public static void start() throws IOException {
        Scanner in = new Scanner(System.in);
        Sort sort;
        int choiceValue = 0;

        System.out.println("Добро пожаловать в меню выбора сортировок!\n");
        while(true){
            System.out.println("Выберите сортировку (0 -> выход):");
            System.out.println("\t 1 -> Сортировка пузырьком");
            System.out.println("\t 2 -> Сортировка перемешиванием");
            do {
                choiceValue = in.nextInt();
            } while (choiceValue != 1 && choiceValue != 2 && choiceValue != 0);

            if (choiceValue == 0)
                break;

            int size = 0, bound = 0;
            System.out.println("Выберите количество элементов и диапазон значение от 0 до ...");
            System.out.print("\t Количество элементов -> ");
            do {
                size = in.nextInt();
            } while(size <= 0);

            System.out.print("\t Диапазон значений -> ");
            bound = in.nextInt();

            switch (choiceValue){
                case 1 -> sort = new BubbleSort(size, bound);
                case 2 -> sort = new CocktailSort(size, bound);
                default -> sort = new BubbleSort(size, bound);
            }

            boolean isFileActive = false;
            System.out.println("Выберите вывод в консоль или файл (0 - консоль, 1 - файл):");
            int choiceFlag = in.nextInt();
            isFileActive = choiceFlag > 0;

            System.out.println("Начинается сортировка...");
            sort.sort();
            System.out.println("Сортировка закончилась...");

            System.out.println("Идет вывод в зависимости от выбранных данных:");
            if (isFileActive)
                ActiveFile.inputArrayToFile(sort);
            else
                DisplayArray.output(sort);

            System.out.println("\n\t Данные записаны, если выбрали файл, то можете в него посмотреть\n");
        }
    }
}
