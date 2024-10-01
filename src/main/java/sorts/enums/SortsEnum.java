package sorts.enums;

import lombok.Getter;
import lombok.SneakyThrows;

@Getter
public enum SortsEnum {
    BUBBLE("Пузырьковая сортировка", "BubbleSort"),
    COCKTAIL("Шейкер сортировка", "CocktailSort"),
    QUICK("Быстрая сортировка", "QuickSort"),
    BINARY("Бинарная сортировка", "TreeSort");

    private final String name;
    private final Class<?> classSort;

    @SneakyThrows
    SortsEnum(String name, String className){
        this.name = name;
        this.classSort = Class.forName( "sorts.init." + className);
    }
}
