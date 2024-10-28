package search.init;

import search.Search;

public class BinaryTrackingSearch extends Search {
    private int lastIndex = -1;

    public BinaryTrackingSearch(int size, int bound) {
        super(size, bound);
    }

    //TODO реализуй алгоритм движения по индексам
    //TODO так же объедини поиск влево и вправо, но уже после сдачи
    @Override
    public int search(int searchValue){
        lastIndex = lastIndex == -1?
                new BinarySearch(sortedValues).search(searchValue):
                sortedValues.get(lastIndex) > searchValue? leftAndSearch(): rightAndSearch();

        return lastIndex;
    }

    private int leftAndSearch(){
        int count2 = 1;

        int max = lastIndex, min = max;
        //TODO цикл до нижней границы и до момента пока значение по индексу
        //не будет больше (уменьшать степенью двойки)

        return 0;
    }

    private int rightAndSearch(){

        return 0;
    }
}
