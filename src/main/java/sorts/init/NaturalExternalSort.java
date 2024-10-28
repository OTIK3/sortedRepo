package sorts.init;

import lombok.SneakyThrows;
import sorts.ExternalSort;

import java.io.FileInputStream;
import java.io.FileWriter;

//TODO переделать алгоритм, все завязано на пробелах и концах файлов - уброть эту жесткую привязку
public class NaturalExternalSort extends ExternalSort {
    private FileWriter file1;
    private FileInputStream file2;
    private FileInputStream file3;
    private boolean isFirst, isSecond;
    private int data2, data3;

    public NaturalExternalSort(String fileName) {
        super(fileName);
    }

    @Override
    @SneakyThrows
    public void sort() {
        int count = 10;
        while(true){
            splitIntoGroups();

            var fileSecond = new FileInputStream(fileName2);
            var fileThird = new FileInputStream(fileName3);

            var sizeSecond = fileSecond.readAllBytes().length;
            var sizeThird = fileThird.readAllBytes().length;

            if (sizeSecond == 0 || sizeThird == 0)
                return;

            fileSecond.close();
            fileThird.close();

            mergeByGroups();
        }
        //Повторить
    }

    @SneakyThrows
    private void splitIntoGroups(){
        fileFirst = new FileInputStream(fileName1);
        fileSecond = new FileWriter(fileName2);
        fileThird = new FileWriter(fileName3);
        StringBuilder value = new StringBuilder();
        int saveValue = -1, data = fileFirst.read();
        isSecond = true;

        while (data != -1) {
            data = fileFirst.read();
            if ((char)data == ' ' || (char)data == '\n' || data == -1){
                int currentValue = Integer.parseInt(value.toString());

                if (saveValue != -1 && currentValue <= saveValue)
                    isSecond = !isSecond;

                (isSecond? fileSecond: fileThird).write(" " + currentValue);

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

    @SneakyThrows
    private void mergeByGroups(){
        var value2 = new StringBuilder();
        var value3 = new StringBuilder();
        file1 = new FileWriter(fileName1, false);
        file2 = new FileInputStream(fileName2);
        file3 = new FileInputStream(fileName3);;
        isFirst = true;
        isSecond = true;
        data2 = file2.read();
        data3 = file3.read();
        int saveValue1 = -1, saveValue2 = -1;

        while(data2 != -1 || data3 != -1){
            while(isFirst && (char)(data2 = file2.read()) != ' ' && data2 != -1){
                if ((char)data2 != '\n')
                    value2.append((char) data2);
            }

            while(isSecond && (char)(data3 = file3.read()) != ' ' && data3 != -1){
                if ((char)data3 != '\n')
                    value3.append((char) data3);
            }

            int first = isFirst && !value2.isEmpty()? Integer.parseInt(value2.toString()): saveValue1;
            int second = isSecond && !value3.isEmpty()? Integer.parseInt(value3.toString()): saveValue2;

            if (data2 == -1) fillLastValues(file3);
            else if (data3 == -1) fillLastValues(file2);

            if (isFirst && first < saveValue1 && data3 != -1){
                second = addLaggingItems(file3, saveValue2, second);
            }
            else if (second < saveValue2 && data2 != -1){
                first = addLaggingItems(file2, saveValue1, first);
            }

            if (data2 == -1 && data3 == -1)
                break;
            file1.write(" " + Math.min(first, second));

            isFirst = first < second;
            isSecond = !isFirst;

            saveValue1 = first;
            saveValue2 = second;

            value2 = new StringBuilder();
            value3 = new StringBuilder();
        }

        file1.close();
        file2.close();
        file3.close();
    }

    @SneakyThrows
    private int addLaggingItems(FileInputStream file, int saveValue, int currentValue){
        int data;
        var value = new StringBuilder();

        while(saveValue <= currentValue){
            while((data = file.read()) != -1 && (char)data != ' '){
                if ((char)data != '\n')
                    value.append((char) data);
            }

            file1.write(" " + currentValue);
            saveValue = currentValue;
            if (data == -1) {
                if (file == file2)
                    data2 = data;
                else
                    data3 = data;

                break;
            }
            currentValue = Integer.parseInt(value.toString());
            value = new StringBuilder();
        }

        return currentValue;
    }

    @SneakyThrows
    private void fillLastValues(FileInputStream file){
        int data;
        while((data = file.read()) != -1){
            file1.write((char)data);
        }
    }
}


