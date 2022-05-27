package chap1;

import reactor.core.publisher.Mono;
import utility.Util;

public class Lec03MonoSubscribe {

    public static void main(String[] args) {
        //publisher
        Mono<Integer> mono = Mono.just("ball").map(String::length);

        //1
        mono.subscribe();

        //2 subscriber
        mono.subscribe(System.out::println,
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed"));

        //3 neat with Uitility
        mono.subscribe(Util.onNext(),
                err -> Util.onError(),
                () -> Util.onComplete());
    }
}
