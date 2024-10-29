package search.enums;

import lombok.Getter;
import lombok.SneakyThrows;

@Getter
public enum SearchEnum {
    BINARY("Бинарный поиск", "BinarySearch"),
    BINARY_TRACKING("Бинарный следящий поиск", "BinaryTrackingSearch");

    private final String name;
    private final Class<?> classSearch;

    @SneakyThrows
    SearchEnum(String name, String className){
        this.name = name;
        this.classSearch = Class.forName( "search.init." + className);
    }
}
