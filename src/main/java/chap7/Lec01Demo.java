package chap7;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import utility.Util;

public class Lec01Demo {
    public static void main(String[] args) {

        Flux.create(fluxSink -> {
                    for (int i = 0; i < 500; i++) {
                        fluxSink.next(i);
                        System.out.println("Pushed : " + i);
                    }
                }).publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    Util.sleepMillis(10);
                }).subscribe(Util.subscriber());
        Util.sleepSeconds(60);
    }
}
