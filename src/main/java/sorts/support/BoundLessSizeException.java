package sorts.support;

public class BoundLessSizeException extends RuntimeException{
    public BoundLessSizeException(){
        super("Диапазон много меньше размерности и не годен для уникальных значений");
    }
}
