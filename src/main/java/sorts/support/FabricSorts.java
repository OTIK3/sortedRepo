package sorts.support;

import lombok.SneakyThrows;
import sorts.Sort;
import sorts.enums.SortsEnum;

import java.lang.reflect.Constructor;

public class FabricSorts {
    @SneakyThrows
    public static Sort getSortByIndex(int index, int size, int bound){

        String factoryClassName = "sorts.init." + SortsEnum.values()[index - 1].getClassName();
        Class<?> factoryClass = Class.forName(factoryClassName);
        Constructor<?> constructor = factoryClass.getDeclaredConstructor(int.class, int.class);
        constructor.setAccessible(true);

        return (Sort) constructor.newInstance(size, bound);
    }
}
