package sorts.support;

import lombok.SneakyThrows;
import sorts.InternalSort;
import sorts.enums.SortsEnum;

import java.lang.reflect.Constructor;
import java.util.List;

public class FabricSorts {
    @SneakyThrows
    public static InternalSort getSortByIndex(int index, int size, int bound){
        Constructor<?> constructor = SortsEnum.values()[index - 1].getClassSort()
                .getDeclaredConstructor(int.class, int.class);
        constructor.setAccessible(true);

        return (InternalSort) constructor.newInstance(size, bound);
    }

    @SneakyThrows
    public static InternalSort getSortByIndexWithUniqueValues(int index, int size, int bound, boolean isUnique){
        Constructor<?> constructor = SortsEnum.values()[index - 1].getClassSort()
                .getDeclaredConstructor(int.class, int.class, boolean.class);
        constructor.setAccessible(true);

        return (InternalSort) constructor.newInstance(size, bound, isUnique);
    }

    @SneakyThrows
    public static InternalSort getSortByIndexWithArray(int index, List<Integer> array){
        Constructor<?> constructor = SortsEnum.values()[index - 1].getClassSort()
                .getDeclaredConstructor(List.class);
        constructor.setAccessible(true);

        return (InternalSort) constructor.newInstance(array);
    }
}
