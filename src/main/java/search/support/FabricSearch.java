package search.support;

import lombok.SneakyThrows;
import search.Search;
import search.enums.SearchEnum;
import sorts.InternalSort;
import sorts.enums.SortsEnum;

import java.lang.reflect.Constructor;
import java.util.List;

public class FabricSearch {
    @SneakyThrows
    public static Search getSearchByIndex(int index, int size, int bound){
        Constructor<?> constructor = SearchEnum.values()[index - 1].getClassSearch()
                .getDeclaredConstructor(int.class, int.class);
        constructor.setAccessible(true);

        return (Search) constructor.newInstance(size, bound);
    }

    @SneakyThrows
    public static Search getSearchByIndexWithArray(int index, List<Integer> array){
        Constructor<?> constructor = SearchEnum.values()[index - 1].getClassSearch()
                .getDeclaredConstructor(List.class);
        constructor.setAccessible(true);

        return (Search) constructor.newInstance(array);
    }
}
