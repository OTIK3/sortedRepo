package sorts.init;

import sorts.InternalSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountingInternalSort extends InternalSort {
    public CountingInternalSort(List<Integer> array) {
        super(array);
    }

    public CountingInternalSort(int size, int bound) {
        super(size, bound);
    }

    public CountingInternalSort(int size, int bound, boolean isUnique) {
        super(size, bound, isUnique);
    }

    @Override
    public void sort() {
        sortedArray = new ArrayList<>();

        int max = Collections.max(array);
        var countingValues = new ArrayList<>(Collections.nCopies(max + 1, 0));
        array.forEach(v -> countingValues.set(v, countingValues.get(v) + 1));

        int indexCount = 0;
        while(sortedArray.size() < array.size()){
            for (int i = 0; i < countingValues.get(indexCount); i++) {
                sortedArray.add(indexCount);
            }
            indexCount++;
        }
    }
}
