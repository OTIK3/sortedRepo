import lombok.SneakyThrows;
import sorts.Sort;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.List;

public class ActiveFile {
    @SneakyThrows
    public static void inputArrayToFile(Sort sort){
        FileWriter writer = new FileWriter("example.txt", false);
        List<Integer> array = sort.getArray();
        List<Integer> sortedArray = sort.getSortedArray();

        writer.write("Массив до сортировки:\n");
        for (int i = 0; i < array.size(); i++) {
            writer.write(array.get(i) + " ");
            if ((i + 1) % 10 == 0){
                writer.write("\n");
            }
        }

        writer.write("\n");

        writer.write("Массив после сортировки:\n");
        for (int i = 0; i < sortedArray.size(); i++) {
            writer.write(sortedArray.get(i) + " ");
            if ((i + 1) % 10 == 0){
                writer.write("\n");
            }
        }
        writer.close();
    }

    @SneakyThrows
    public static void outputFile(){
        FileInputStream fileInputStream = new FileInputStream("example.txt");
        int data;
        while ((data = fileInputStream.read()) != -1) {
            System.out.print((char) data);
        }
    }
}
