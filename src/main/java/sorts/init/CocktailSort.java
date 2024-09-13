package sorts.init;
import sorts.Sort;

import java.util.List;

public class CocktailSort extends Sort {
    public CocktailSort(List<Integer> array) {
        super(array);
    }

    public CocktailSort(int size, int bound){
        super(size, bound);
    }
    //TODO обмены заменить сдвигами до тех пор пока не будет элемента больше
    @Override
    public void sort() {
        for (int i = 0; i < sortedArray.size() - i; i++) {
            boolean isSorted = true;
            for (int j = sortedArray.size() - i - 1; j >= i + 1; j--) {
                if (sortedArray.get(j) < sortedArray.get(j - 1)){
                    var z = sortedArray.get(j);
                    sortedArray.set(j, sortedArray.get(j - 1));
                    sortedArray.set(j - 1, z);
                    isSorted = false;
                }
            }

            if (isSorted)
                return;

            for (int j = i + 1; j < sortedArray.size() - i - 1; j++) {
                if (sortedArray.get(j) > sortedArray.get(j + 1)){
                    var z = sortedArray.get(j);
                    sortedArray.set(j, sortedArray.get(j + 1));
                    sortedArray.set(j + 1, z);
                }
            }
        }

    }
}
