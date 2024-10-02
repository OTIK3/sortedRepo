package sorts.init;

import sorts.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountingSort extends Sort {
    public CountingSort(List<Integer> array) {
        super(array);
    }

    public CountingSort(int size, int bound) {
        super(size, bound);
    }

    public CountingSort(int size, int bound, boolean isUnique) {
        super(size, bound, isUnique);
    }

    @Override
    public void sort() {
        sortedArray = new ArrayList<>(Collections.nCopies(array.size(), 0));

        int max = Collections.max(array);
        var countingValues = new ArrayList<>(Collections.nCopies(max + 1, 0));
        array.forEach(v -> countingValues.set(v, countingValues.get(v) + 1));

        //кумулятивные суммы
        for (int i = 1; i <= max; i++) {
            countingValues.set(i, countingValues.get(i-1) + countingValues.get(i));
        }

        array.forEach(v -> sortedArray.set(countingValues.set(v, countingValues.get(v) - 1) - 1, v));
    }
}
