package chap2;

import reactor.core.publisher.Flux;
import utility.Util;

import java.util.Arrays;
import java.util.List;

public class Lec03FluxFromArrayOrList {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a","b","c");
        Flux.fromIterable(strings).subscribe(Util.onNext());

        System.out.println();

        Integer[] arr = {2,5,6,7,8};
        Flux.fromArray(arr).subscribe(Util.onNext());
    }
}
