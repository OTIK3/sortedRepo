package sorts;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileWriter;

public abstract class ExternalSort implements Sort{
    protected final String fileName1;
    protected final String fileName2;
    protected final String fileName3;
    protected FileInputStream fileFirst;
    protected FileWriter fileSecond;
    protected FileWriter fileThird;

    @SneakyThrows
    public ExternalSort(String fileName){
        this.fileName1 = fileName + ".txt";
        this.fileName2 = fileName + "1.txt";
        this.fileName3 = fileName + "2.txt";
    }

    public abstract void sort();
}
