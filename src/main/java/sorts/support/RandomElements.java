package sorts.support;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;

public class RandomElements {
    private static final Random rand = new Random();
    private static ArrayList<Integer> list = new ArrayList<>();

    public static ArrayList<Integer> getRandomElements(int size, int bound){
        list.clear();
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(0, bound + 1));
        }

        return list;
    }

    public static ArrayList<Integer> getRandomUniqueElements(int size, int bound){
        list.clear();

        try{
            if (bound < size) {
                throw new BoundLessSizeException();
            }
        } catch (RuntimeException exception){
            return getRandomElements(size, bound);
        }

        var saveValues = new LinkedHashSet<Integer>();
        for (int i = 0; i < size; i++) {
            saveValues.add(rand.nextInt(0, bound + 1));
        }

        int rangeValuesLeft = 0;
        int rangeValuesRight = bound + 1;
        while(saveValues.size() < size){
            if (saveValues.contains(rangeValuesLeft))
                rangeValuesLeft++;
            if (saveValues.contains(rangeValuesRight))
                rangeValuesRight--;

            saveValues.add(rand.nextInt(rangeValuesLeft, rangeValuesRight));
        }
        list = new ArrayList<>(saveValues.stream().toList());

        return list;
    }
}
