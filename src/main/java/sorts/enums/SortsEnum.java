package sorts.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SortsEnum {

    BUBBLE(1, "Пузырьковая сортировка", "BubbleSort"),
    COCKTAIL(2, "Шейкерная сортировка", "CocktailSort"),
    QUICK(3, "Быстрая сортировка", "QuickSort");

    private final int index;
    private final String name;
    private final String className;
}
