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
        sortPartArray(0, sortedArray.size() - 1);
    }

    private void sortPartArray(int leftIndex, int rightIndex){
        if (leftIndex >= rightIndex)
            return;

        int pivot = leftIndex;
        int left = leftIndex + 1;
        int right = rightIndex;
        while(left <= right){
            if (sortedArray.get(left) > sortedArray.get(pivot)){
                if (sortedArray.get(right) <= sortedArray.get(pivot)){
                    swap(left, right);
                }
                else
                    right--;
            }
            else
                swap(left++, pivot++);
        }

        sortPartArray(leftIndex, pivot - 1);
        sortPartArray(pivot + 1, rightIndex);
    }

    private void swap(int first, int second){
        int copy = sortedArray.get(first);
        sortedArray.set(first, sortedArray.get(second));
        sortedArray.set(second, copy);
    }

}
