package sorts;

import sorts.support.RandomElements;

import java.util.ArrayList;
import java.util.List;

public abstract class InternalSort implements Sort{
    protected final List<Integer> array;
    protected List<Integer> sortedArray;

    public InternalSort(List<Integer> array){
        this.array = array;
        this.sortedArray = new ArrayList<>(array);
    }

    public InternalSort(int size, int bound){
        this.array = RandomElements.getRandomElements(size, bound);
        this.sortedArray = new ArrayList<>(array);
    }

    public InternalSort(int size, int bound, boolean isUnique){
        this.array = isUnique?
                RandomElements.getRandomUniqueElements(size, bound):
                RandomElements.getRandomElements(size, bound);
        this.sortedArray = new ArrayList<>(array);
    }

    public abstract void sort();

    public List<Integer> getArray(){
        return new ArrayList<>(array);
    }

    public List<Integer> getSortedArray(){
        return new ArrayList<>(sortedArray);
    }
}
