package ss16_io_text_file.thuc_hanh;

import java.util.List;

import static ss16_io_text_file.thuc_hanh.ReadAndWriteFile.findMax;

public class TimGiaTriLonNhat {
    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("H:\\A0921I1-LeHuuHuy\\module2\\src\\ss16_io_text_file\\thuc_hanh\\input.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("H:\\A0921I1-LeHuuHuy\\module2\\src\\ss16_io_text_file\\thuc_hanh\\result.txt", maxValue);
    }
}