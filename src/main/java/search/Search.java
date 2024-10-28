package search;

import sorts.support.RandomElements;

import java.util.ArrayList;

public abstract class Search {
    protected ArrayList<Integer> sortedValues;

    public Search(int size, int bound){
        sortedValues = new ArrayList<>(
                RandomElements.getRandomElements(size, bound).stream().
                        sorted().
                        toList()
        );
    }

    public ArrayList<Integer> getSortedValues(){
        return new ArrayList<>(sortedValues);
    }

    public abstract int search(int value);
}
