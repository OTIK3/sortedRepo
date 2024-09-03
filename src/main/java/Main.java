import sortClasses.CocktailSort;
import sortClasses.BubbleSort;
import sortClasses.RandomElements;

public class Main {
    public static void main(String[] args) {
        var list = RandomElements.getRandomIntegerElements(100, 500);
        BubbleSort quickSort = new BubbleSort(list);
        CocktailSort cocktailSort = new CocktailSort(list);
        OutputElements.output(quickSort);
        OutputElements.output(cocktailSort);
//        OutputElements.outputFromFile(quickSort);
    }
}