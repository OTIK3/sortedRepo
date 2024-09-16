package sorts.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import sorts.Sort;

@Getter
public enum SortsEnum {
    BUBBLE(1, "Пузырьковая сортировка", "BubbleSort"),
    COCKTAIL(2, "Шейкер сортировка", "CocktailSort"),
    QUICK(3, "Быстрая сортировка", "QuickSort");

    private final int index;
    private final String name;
    private final Class<?> classSort;

    @SneakyThrows
    SortsEnum(int index, String name, String className){
        this.index = index;
        this.name = name;
        this.classSort = Class.forName( "sorts.init." + className);
    }
}
