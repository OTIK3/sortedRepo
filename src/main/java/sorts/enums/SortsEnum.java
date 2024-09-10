package sorts.enums;

public enum SortsEnum {

    BUBBLE(1, "Пузырьковая сортировка", "BubbleSort"),
    COCKTAIL(2, "Шейкерная сортировка", "CocktailSort"),
    QUICK(3, "Быстрая сортировка", "QuickSort");

    private final int index;
    private final String name;
    private final String className;

    SortsEnum(int index, String name, String className) {
        this.index = index;
        this.name = name;
        this.className = className;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }
}
