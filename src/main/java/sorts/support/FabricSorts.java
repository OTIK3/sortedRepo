package sorts.support;

import lombok.SneakyThrows;
import sorts.Sort;
import sorts.enums.SortsEnum;

import java.lang.reflect.Constructor;
import java.util.List;

public class FabricSorts {
    @SneakyThrows
    public static Sort getSortByIndex(int index, int size, int bound){
        Constructor<?> constructor = getClass(index).getDeclaredConstructor(int.class, int.class);
        constructor.setAccessible(true);

        return (Sort) constructor.newInstance(size, bound);
    }

    @SneakyThrows
    public static Sort getSortByIndexWithArray(int index, List<Integer> array){
        Constructor<?> constructor = getClass(index).getDeclaredConstructor(List.class);
        constructor.setAccessible(true);

        return (Sort) constructor.newInstance(array);
    }


    @SneakyThrows
    private static Class<?> getClass(int index){
        String factoryClassName = "sorts.init." + SortsEnum.values()[index - 1].getClassName();
        return Class.forName(factoryClassName);
    }
}
