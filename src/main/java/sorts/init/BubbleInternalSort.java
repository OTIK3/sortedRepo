package sorts.init;
import sorts.InternalSort;

import java.util.List;

public class BubbleInternalSort extends InternalSort {
    public BubbleInternalSort(List<Integer> array) {
        super(array);
    }

    public BubbleInternalSort(int size, int bound) {
        super(size, bound);
    }

    public BubbleInternalSort(int size, int bound, boolean isUnique) {
        super(size, bound, isUnique);
    }

    @Override
    public void sort() {
        for (int i = 0; i < sortedArray.size(); i++) {
            boolean isSorted = true;
            for (int j = 0; j < sortedArray.size() - i - 1; j++) {
                if (sortedArray.get(j) > sortedArray.get(j + 1)){
                    var z = sortedArray.get(j);
                    sortedArray.set(j, sortedArray.get(j + 1));
                    sortedArray.set(j + 1, z);
                    if (isSorted)
                        isSorted = false;
                }
            }
            if (isSorted)
                return;
        }
    }
}
