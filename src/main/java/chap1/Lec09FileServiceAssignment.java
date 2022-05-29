package chap1;

import chap1.assignment.FileService;
import utility.Util;

import java.util.ArrayList;
import java.util.List;

public class Lec09FileServiceAssignment {

    public static void main(String[] args) {

        //read file
        FileService.read("file01.txt").subscribe(Util.onNext(),Util.onError(),Util.onComplete());

        //write file
        FileService.write("file04.txt",generateString(20)).subscribe(Util.onNext(),Util.onError(),Util.onComplete());

        //delete file
        FileService.delete("file03.txt").subscribe(Util.onNext(),Util.onError(),Util.onComplete());



    }

    private static  List<String> generateString(int n){
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stringList.add("Line"+ i);
        }
        return stringList;
    }
}
