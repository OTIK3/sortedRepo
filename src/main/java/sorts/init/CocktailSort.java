package sorts.init;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import sorts.Sort;

import java.util.List;

@State(Scope.Thread)
public class CocktailSort extends Sort {
    public CocktailSort(List<Integer> array) {
        super(array);
    }

    public CocktailSort(int size, int bound){
        super(size, bound);
    }

    @Override
    public void sort() {
        for (int i = 0; i < sortedArray.size() - i; i++) {
            boolean isSorted1 = true, isSorted2 = true;
            for (int j = sortedArray.size() - i - 1; j >= i + 1; j--) {
                if (sortedArray.get(j) < sortedArray.get(j - 1)){
                    var z = sortedArray.get(j);
                    sortedArray.set(j, sortedArray.get(j - 1));
                    sortedArray.set(j - 1, z);
                    isSorted1 = false;
                }
            }

            for (int j = i + 1; j < sortedArray.size() - i - 1; j++) {
                if (sortedArray.get(j) > sortedArray.get(j + 1)){
                    var z = sortedArray.get(j);
                    sortedArray.set(j, sortedArray.get(j + 1));
                    sortedArray.set(j + 1, z);
                    isSorted2 = false;
                }
            }

            if (isSorted1 && isSorted2)
                return;
        }

    }
}
