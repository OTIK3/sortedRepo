package search.init;

import search.Search;

import java.util.ArrayList;

public class BinaryTrackingSearch extends Search {
    private int lastIndex = -1;

    public BinaryTrackingSearch(int size, int bound) {
        super(size, bound);
    }

    @Override
    public int search(int searchValue){
        lastIndex = lastIndex == -1?
                new BinarySearch(sortedValues).search(searchValue):
                sortedValues.get(lastIndex) > searchValue? leftAndSearch(searchValue): rightAndSearch(searchValue);

        return lastIndex;
    }

    private int leftAndSearch(int searchValue){
        int count2 = 1;

        int max = lastIndex, min = max - 1;
        do{
            if (sortedValues.get(min) < searchValue){
                var searchBinary = new BinarySearch(new ArrayList<>(sortedValues.subList(min, max))).search(searchValue);
                return searchBinary == -1? -1: min + searchBinary;
            }

            count2 *= 2;
            min = max - count2;

        }while(min >= 0 && sortedValues.get(min) != searchValue);

        if (min >= 0)
            return min;

        if (searchValue == sortedValues.get(0))
            return 0;

        return -1;
    }

    private int rightAndSearch(int searchValue){
        int count2 = 1;

        int min = lastIndex, max = min + 1;
        do{
            if (sortedValues.get(max) > searchValue) {
                var searchBinary = new BinarySearch(new ArrayList<>(sortedValues.subList(min, max))).search(searchValue);
                return searchBinary == -1? -1: min + searchBinary;
            }

            count2 *= 2;
            max = min + count2;

        }while(max < sortedValues.size() && sortedValues.get(max) != searchValue);

        if (max < sortedValues.size())
            return max;

        if (searchValue == sortedValues.get(sortedValues.size() - 1))
            return sortedValues.size() - 1;

        return -1;
    }
}
