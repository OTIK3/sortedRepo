package sorts.init;
import sorts.Sort;

import java.util.List;

public class CocktailSort extends Sort {
    private int saveIterationIndex = -1;
    private int saveIterationValue = -1;
    private int lastIndexRight = -1;
    private int lastIndexLeft = -1;
    private boolean isSorted;

    public CocktailSort(List<Integer> array) {
        super(array);
    }

    public CocktailSort(int size, int bound){
        super(size, bound);
    }

    @Override
    public void sort() {
        lastIndexLeft = 1;
        lastIndexRight = sortedArray.size() - 1;
        for (int i = 0; i < sortedArray.size()/2; i++) {
            rightToLeft(lastIndexLeft, lastIndexRight);

            if (isSorted) return;

            leftToRight(lastIndexLeft, lastIndexRight);
        }
    }

    private void rightToLeft(int startIndex, int endIndex){
        isSorted = true;
        for (int j = endIndex; j >= startIndex; j--) {
            if ((saveIterationIndex >= 0 ? saveIterationValue : sortedArray.get(j)) < sortedArray.get(j - 1)){
                if (saveIterationIndex < 0) {
                    saveIterationIndex = j;
                    saveIterationValue = sortedArray.get(saveIterationIndex);
                }

                sortedArray.set(j, sortedArray.get(j - 1));
                isSorted = false;

                if (startIndex == j) {
                    sortedArray.set(j - 1, saveIterationValue);
                }
                lastIndexLeft = j;
            }
            else if (saveIterationIndex >= 0){
                sortedArray.set(j, saveIterationValue);
                saveIterationIndex = -1;
                lastIndexLeft = j;
            }
        }
        saveIterationIndex = -1;
    }

    private void leftToRight(int startIndex, int endIndex){
        for (int j = startIndex; j < endIndex; j++) {
            if ((saveIterationIndex >= 0 ? saveIterationValue : sortedArray.get(j)) > sortedArray.get(j + 1)){
                if (saveIterationIndex < 0) {
                    saveIterationIndex = j;
                    saveIterationValue = sortedArray.get(saveIterationIndex);
                }

                sortedArray.set(j, sortedArray.get(j + 1));

                if (endIndex - 1 == j) {
                    sortedArray.set(j + 1, saveIterationValue);
                }
                lastIndexRight = j;
            }
            else if (saveIterationIndex >= 0){
                sortedArray.set(j, saveIterationValue);
                saveIterationIndex = -1;
                lastIndexRight = j;
            }
        }
        saveIterationIndex = -1;
    }
}
