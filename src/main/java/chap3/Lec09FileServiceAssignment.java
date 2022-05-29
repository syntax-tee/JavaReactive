package chap3;

import chap1.assignment.FileService;
import chap3.assignment.FileReaderService;
import utility.Util;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Lec09FileServiceAssignment {

    public static void main(String[] args) {
        FileReaderService readerService = new FileReaderService();

        Path path = Paths.get("src/main/resources/assignment/sec033/file01.txt");
        readerService.read(path).take(10).subscribe(Util.subscriber());
    }


}
