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

    /** Алгоритм работает следующим образом:

     * Метод swap -> переставление элементов местами по индексу

     * Метод sortPartArray принимает 2 аргумента (граничные индексы левой и правой стороны)
     *  В нем происходит основной алгоритм

     * Есть несколько переменных pivot, left, right
     * pivot - ведущий элемент (начинается с 0)
     * left - левый элемент (указатель слево на право)
     * right - правый элемент (указатель справа на лево)

     * Смысл заключается в том, что ведущий элемент начинается с 0 индекса
     * Далее левый элемент (справа от ведущего) сравнивается с ведущим
     * Если же левый меньше или равен, то меняем их местами
     * Если же больше, то проверяем правый элемент
     *  Сравниваем правый и ведущий
     *      Если же меньше или равно, то меняем местами левый и правый
     *      Со следующей итерацией будет проверка и с ведущим элементом
     * Далее алгоритм повторяется до тех пор, пока левый указатель будет больше правого
     * После цикла останется отсортировать левую и правую часть массива от ведущего элемента

     * Рекурсия работает до тех пор, пока указатель будет
     *  либо с некорректными указателями
     *  либо с одинаковыми указателями
     */
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
