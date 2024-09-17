package sorts.init;

import sorts.Sort;

import java.util.List;

public class QuickSort extends Sort {

    public QuickSort(List<Integer> array) {
        super(array);
    }

    public QuickSort(int size, int bound) {
        super(size, bound);
    }

    @Override
    public void sort() {
        quickSort(0, sortedArray.size() - 1);
    }

    public void quickSort(int left, int right) {
        if (sortedArray.isEmpty() || left >= right)
            return;

        int middle = left + (right - left) / 2;
        int pivot = sortedArray.get(middle);
        int i = left, j = right;

        while (i <= j) {
            while (sortedArray.get(i) < pivot)
                i++;
            while (sortedArray.get(j) > pivot)
                j--;

            if (i <= j) {
                int save = sortedArray.get(i);
                sortedArray.set(i++, sortedArray.get(j));
                sortedArray.set(j--, save);
            }
        }

        if (left < j)
            quickSort(left, j);
        if (right > i)
            quickSort(i, right);
    }
}
