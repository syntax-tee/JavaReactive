package chap6;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import utility.Util;

public class Lec02SubscribesOnDemo {

    public static void main(String[] args) {

        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("create");
                    fluxSink.next(1);})
                .doOnNext(i -> printThreadName("next " + i));

        flux.doFirst(() -> printThreadName("first 2"))
            .subscribeOn(Schedulers.boundedElastic())
            .doFirst(() -> printThreadName("first 21"))
            .subscribe(v -> printThreadName("sub " + v));

        Util.sleepSeconds(5);

    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t: Thread : " + Thread.currentThread().getName());
    }
}
