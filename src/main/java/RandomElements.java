import java.util.ArrayList;
import java.util.Random;

public class RandomElements {
    public static ArrayList<Integer> getRandomIntegerElements(int size){
        var list = new ArrayList<Integer>();
        var rand = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(0, 100));
        }

        return list;
    }
}
