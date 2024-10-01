package sorts.support;

import lombok.SneakyThrows;
import sorts.Sort;
import sorts.enums.SortsEnum;

import java.lang.reflect.Constructor;
import java.util.List;

public class FabricSorts {
    @SneakyThrows
    public static Sort getSortByIndex(int index, int size, int bound){
        Constructor<?> constructor = SortsEnum.values()[index - 1].getClassSort()
                .getDeclaredConstructor(int.class, int.class);
        constructor.setAccessible(true);

        return (Sort) constructor.newInstance(size, bound);
    }

    @SneakyThrows
    public static Sort getSortByIndexWithUniqueValues(int index, int size, int bound, boolean isUnique){
        Constructor<?> constructor = SortsEnum.values()[index - 1].getClassSort()
                .getDeclaredConstructor(int.class, int.class, boolean.class);
        constructor.setAccessible(true);

        return (Sort) constructor.newInstance(size, bound, isUnique);
    }

    @SneakyThrows
    public static Sort getSortByIndexWithArray(int index, List<Integer> array){
        Constructor<?> constructor = SortsEnum.values()[index - 1].getClassSort()
                .getDeclaredConstructor(List.class);
        constructor.setAccessible(true);

        return (Sort) constructor.newInstance(array);
    }
}
