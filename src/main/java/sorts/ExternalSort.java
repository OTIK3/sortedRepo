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
        this.fileName1 = fileName;
        this.fileName2 = fileName + "1";
        this.fileName3 = fileName + "2";

        this.fileFirst = new FileInputStream(fileName + ".txt");
        this.fileSecond = new FileWriter(fileName2 + ".txt");
        this.fileThird = new FileWriter(fileName3 + ".txt");
    }

    public abstract void sort();
}
