package sorts.enums;

import lombok.Getter;
import lombok.SneakyThrows;

@Getter
public enum SortsEnum {
    BUBBLE("Пузырьковая сортировка", "BubbleInternalSort"),
    COCKTAIL("Шейкер сортировка", "CocktailInternalSort"),
    QUICK("Быстрая сортировка", "QuickInternalSort"),
    BINARY("Бинарная сортировка", "TreeInternalSort"),
    COUNTING("Сортировка подсчетом", "CountingInternalSort");

    private final String name;
    private final Class<?> classSort;

    @SneakyThrows
    SortsEnum(String name, String className){
        this.name = name;
        this.classSort = Class.forName( "sorts.init." + className);
    }
}
