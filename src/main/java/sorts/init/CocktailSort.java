package sorts.init;
import sorts.Sort;

import java.util.List;

public class CocktailSort extends Sort {
    private int swapIndex = -1;
    private int swapValue = -1;
    private boolean isSorted;

    public CocktailSort(List<Integer> array) {
        super(array);
    }

    public CocktailSort(int size, int bound){
        super(size, bound);
    }

    @Override
    public void sort() {
        for (int i = 0; i < sortedArray.size()/2; i++) {
            rightToLeft(sortedArray.size() - i - 1, i + 1);

            if (isSorted) return;

            leftToRight(i + 1, sortedArray.size() - i - 1);
        }
    }

    private void rightToLeft(int startIndex, int endIndex){
        isSorted = true;
        for (int j = startIndex; j >= endIndex; j--) {
            if ((swapIndex >= 0 ? swapValue : sortedArray.get(j)) < sortedArray.get(j - 1)){
                if (swapIndex < 0) {
                    swapIndex = j;
                    swapValue = sortedArray.get(swapIndex);
                }

                sortedArray.set(j, sortedArray.get(j - 1));
                isSorted = false;

                if (endIndex == j) {
                    sortedArray.set(j - 1, swapValue);
                }
            }
            else if (swapIndex >= 0){
                sortedArray.set(j, swapValue);
                swapIndex = -1;
            }
        }
        swapIndex = -1;
    }

    private void leftToRight(int startIndex, int endIndex){
        for (int j = startIndex; j < endIndex; j++) {
            if ((swapIndex >= 0 ? swapValue : sortedArray.get(j)) > sortedArray.get(j + 1)){
                if (swapIndex < 0) {
                    swapIndex = j;
                    swapValue = sortedArray.get(swapIndex);
                }

                sortedArray.set(j, sortedArray.get(j + 1));

                if (endIndex - 1 == j)
                    sortedArray.set(j + 1, swapValue);
            }
            else if (swapIndex >= 0){
                sortedArray.set(j, swapValue);
                swapIndex = -1;
            }
        }
        swapIndex = -1;
    }
}
