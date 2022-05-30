package chap6;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import utility.Util;

public class Lec03SubscribeOnMultipleItems {

    public static void main(String[] args) {

        Flux<Object> flux = Flux.create(fluxSink -> {
            printThreadName("create");
            for (int i = 0; i < 4; i++) {
                fluxSink.next(i);
                Util.sleepSeconds(1);
            }
            fluxSink.complete();
        }).doOnNext(i -> printThreadName("next " + i));

        Runnable runnable = () -> flux.subscribeOn(Schedulers.boundedElastic()).subscribe(v -> printThreadName("sub " + v));
        for (int i = 0; i < 5; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(5);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t: Thread : " + Thread.currentThread().getName());
    }
}
