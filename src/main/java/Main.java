import sortClasses.QuickSort;

public class Main {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort(RandomElements.getRandomIntegerElements(500));
        OutputElements.output(quickSort);
        OutputElements.outputFromFile(quickSort);
    }
}