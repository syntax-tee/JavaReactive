package chap1;

import chap1.assignment.FileService;
import utility.Util;

public class Lec09Assignment {

    public static void main(String[] args) {

        //read file
        FileService.read("file01.txt").subscribe(Util.onNext(),Util.onError(),Util.onComplete());

        //write file
        FileService.write("file02.txt","This is file 2").subscribe(Util.onNext(),Util.onError(),Util.onComplete());

        //delete file
        FileService.delete("file03.txt").subscribe(Util.onNext(),Util.onError(),Util.onComplete());


    }
}
