package sortClasses;

import java.util.ArrayList;
import java.util.List;

public abstract class Sort {
    protected final List<Integer> array;
    protected List<Integer> sortedArray;

    public Sort(List<Integer> array){
        this.array = array;
        this.sortedArray = new ArrayList<>(array);
    }

    public Sort(int size, int bound){
        this.array = RandomElements.getRandomIntegerElements(size, bound);
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
