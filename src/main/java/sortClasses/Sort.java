package sortClasses;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public abstract class Sort<T> {
    protected final List<T> array;
    protected List<T> sortedArray = null;

    public abstract void sort();

    public List<T> getArray(){
        return new ArrayList<>(array);
    }

    public List<T> getSortedArray(){
        return sortedArray == null ? null : new ArrayList<>(sortedArray);
    }
}
