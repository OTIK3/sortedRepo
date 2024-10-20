package sorts.init;

import lombok.SneakyThrows;
import sorts.ExternalSort;

import java.io.FileInputStream;
import java.io.FileWriter;

public class NaturalExternalSort extends ExternalSort {
    public NaturalExternalSort(String fileName) {
        super(fileName);
    }

    @Override
    @SneakyThrows
    public void sort() {
        splitIntoGroups();
        mergeByGroups();
        System.out.println();
        //Вторая итерация -> слиянием в изначальный файл записать новые группы
        //Повторить
    }

    @SneakyThrows
    private void splitIntoGroups(){
        StringBuilder value = new StringBuilder();
        int saveValue = -1, data;
        boolean isSecond = true;

        while ((data = fileFirst.read()) != -1) {
            if ((char)data == ' ' || (char)data == '\n'){
                int currentValue = Integer.parseInt(value.toString());

                if (saveValue != -1 && currentValue <= saveValue)
                    isSecond = !isSecond;

                (isSecond? fileSecond: fileThird).write(currentValue + " ");

                saveValue = currentValue;
                value = new StringBuilder();
                continue;
            }
            value.append((char) data);
        }

        fileFirst.close();
        fileSecond.close();
        fileThird.close();
    }

    //TODO бесконечный цикл
    @SneakyThrows
    private void mergeByGroups(){
        var value2 = new StringBuilder();
        var value3 = new StringBuilder();
        var file1 = new FileWriter(fileName1 + ".txt", false);
        var file2 = new FileInputStream(fileName2 + ".txt");
        var file3 = new FileInputStream(fileName3 + ".txt");
        int data2 = file2.read(), data3 = file3.read();
        boolean isFirst = true, isSecond = true;
        int saveValue1 = -1, saveValue2 = -1;

        while(data2 != -1 && data3 != -1){
            while(isFirst && (char)data2 != ' ' && (char)data2 != '\n'){
                value2.append((char) data2);
                data2 = file2.read();
            }

            while(isSecond && (char)data3 != ' ' && (char)data3 != '\n'){
                value3.append((char) data3);
                data3 = file3.read();
            }

            int first = isFirst? Integer.parseInt(value2.toString()): saveValue1;
            int second = isSecond? Integer.parseInt(value3.toString()): saveValue2;

            if (isFirst && first < saveValue1){
                while(saveValue2 < second){
                    while((char)data3 != ' ' && (char)data3 != '\n'){
                        value3.append((char) data3);
                        data3 = file3.read();
                    }

                    file1.write(saveValue1);
                    saveValue2 = second;
                    second = Integer.parseInt(value3.toString());
                }
            }
            else if (second < saveValue2){
                while(saveValue1 < first){
                    while((char)data2 != ' ' && (char)data2 != '\n'){
                        value2.append((char) data2);
                        data2 = file2.read();
                    }

                    file1.write(saveValue1);
                    saveValue1 = first;
                    first = Integer.parseInt(value2.toString());
                }
            }
            file1.write(Math.min(first, second) + " ");

            isFirst = first < second;
            isSecond = !isFirst;

            if (isFirst) saveValue1 = first;
            if (isSecond) saveValue2 = second;


        }

        file1.close();
        file2.close();
        file3.close();
    }
}
