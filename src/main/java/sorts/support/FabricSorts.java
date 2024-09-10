package sorts.support;

import sorts.Sort;
import sorts.init.BubbleSort;
import sorts.init.CocktailSort;

import java.util.List;

public class FabricSorts {
    public static Sort getSortByIndex(int index){
        return null;
    }

    public static Sort getSortByIndex(int index, int size, int bound){
        return switch (index){
            case 2 -> new CocktailSort(size, bound);
            default -> new BubbleSort(size, bound);
        };
    }

    public static Sort getSortByIndex(int index, List<Integer> values){
        return switch (index){
            case 2 -> new CocktailSort(values);
            default -> new BubbleSort(values);
        };
    }
}
