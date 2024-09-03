import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ActiveFile<T> {
    public static void inputArrayToFile(List<Integer> sortedArray) throws IOException {
        FileWriter writer = new FileWriter("example.txt", false); // true означает добавление в конец файла
        String sortedArrayLine = sortedArray.toString();
        for (int i = 0; i < sortedArray.size(); i++) {
            writer.write(sortedArray.get(i) + " ");
            if ((i + 1) % 10 == 0){
                writer.write("\n");
            }

        } // \n добавляет перенос строки
        writer.close();
    }

    public static void outputFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("example.txt");
        int data;
        while ((data = fileInputStream.read()) != -1) {
            System.out.print((char) data);
        }
    }
}
