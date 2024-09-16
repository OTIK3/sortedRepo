package sorts.support;

import java.util.List;

public class Correct {
    public static boolean isValidSortArray(List<Integer> sortArray){

        for (int i = 0; i < sortArray.size() - 1; i++) {
            if (sortArray.get(i) > sortArray.get(i + 1)) {
                System.out.println("Застопорился на -> " + i);
                return false;
            }
        }

        return true;
    }
}
