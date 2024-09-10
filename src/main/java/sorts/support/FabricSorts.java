package sorts.support;

import sorts.Sort;
import sorts.enums.SortsEnum;
import sorts.init.BubbleSort;
import sorts.init.CocktailSort;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class FabricSorts {
    public static Sort getSortByIndex(int index, int size, int bound){
        String factoryClassName = "sorts.init." + SortsEnum.values()[index - 1].getClassName();
        try {
            Class<?> factoryClass = Class.forName(factoryClassName);
            Constructor<?> constructor = factoryClass.getDeclaredConstructor(int.class, int.class);
            constructor.setAccessible(true);
            Sort instance = (Sort) constructor.newInstance(size, bound);

            if (instance == null)
                throw new ClassNotFoundException();

            return instance;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

}
