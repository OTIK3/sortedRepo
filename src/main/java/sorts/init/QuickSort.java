package sorts.init;

import sorts.Sort;

import java.util.List;

public class QuickSort extends Sort {
    private List<Integer> copyArray;

    public QuickSort(List<Integer> array) {
        super(array);
    }

    public QuickSort(int size, int bound) {
        super(size, bound);
    }

    @Override
    public void sort() {
        copyArray = array;
        sortPartArray(0, copyArray.size() - 1);
        sortedArray = copyArray;
    }

    //TODO при прогоне рекурсии не понимаю как в конце сравнивать значения!!
    private void sortPartArray(int leftIndex, int rightIndex){
        if (leftIndex == rightIndex) {
            if (leftIndex == 0 && copyArray.get(leftIndex) > copyArray.get(leftIndex+1)){
                int count = copyArray.get(leftIndex);
                copyArray.set(leftIndex, copyArray.get(leftIndex + 1));
                copyArray.set(leftIndex + 1, count);
            }
            else if (copyArray.get(rightIndex)){
            }
        }
        int refIndex = (rightIndex + leftIndex)/2;
        int copyLeftIndex = leftIndex;
        int copyRightIndex = rightIndex;

        int ref = copyArray.get(refIndex);
        int left = copyArray.get(leftIndex);
        int right = copyArray.get(rightIndex);

        for (int i = leftIndex; i < rightIndex; i++) {
            if (copyLeftIndex == copyRightIndex)
                break;

            if (left > ref && right < ref){
                copyArray.set(copyLeftIndex, right);
                copyArray.set(copyRightIndex, left);
                left = copyArray.get(++copyLeftIndex);
                right = copyArray.get(--copyRightIndex);
            }
            else {
                if (left <= ref && (copyLeftIndex + 1) <= refIndex){
                    left = copyArray.get(++copyLeftIndex);
                }
                if (right >= ref && (copyRightIndex - 1) >= refIndex){
                    right = copyArray.get(--copyRightIndex);
                }
            }
        }

        sortPartArray(leftIndex, refIndex - 1);
        sortPartArray(refIndex + 1, rightIndex);
    }
}
