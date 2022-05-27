package chap2.helper;

import reactor.core.publisher.Flux;
import utility.Util;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

//    public static List<String> getNames(int count){
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < count; i++) {
//            list.add(getName());
//        }
//        return list;
//    }

    public  static Flux<String> getNames(int count){
        return  Flux.range(0, count).map(i -> getName());
    }

    private static String getName(){
        Util.sleepSeconds(1);
        return Util.faker().name().fullName();
    }
}
