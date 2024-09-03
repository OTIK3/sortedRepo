package sortClasses;

import java.util.ArrayList;
import java.util.List;

public class QuickSort extends Sort<Integer> {
    public QuickSort(List<Integer> array) {
        super(array);
    }

    @Override
    public void sort() {
        sortedArray = new ArrayList<Integer>(array);
        for (int i = 0; i < sortedArray.size(); i++) {
            for (int j = 0; j < sortedArray.size() - i - 1; j++) {
                if (sortedArray.get(j) > sortedArray.get(j + 1)){
                    var z = sortedArray.get(j);
                    sortedArray.set(j, sortedArray.get(j + 1));
                    sortedArray.set(j + 1, z);
                }
            }
        }
    }
}
