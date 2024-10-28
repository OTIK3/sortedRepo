package search.init;

import search.Search;

import java.util.ArrayList;

public class BinarySearch extends Search {
    public BinarySearch(int size, int bound) {
        super(size, bound);
    }

    public BinarySearch(ArrayList<Integer> sortedValues){
        super(0, 0);
        this.sortedValues = sortedValues;
    }

    @Override
    public int search(int searchValue) {
        int left = 0;
        int right = sortedValues.size() - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            int current = sortedValues.get(middle);

            if (current == searchValue) return middle;
            else if (current < searchValue) left = middle + 1;
            else right = middle - 1;

        }
        return -1;
    }
}
