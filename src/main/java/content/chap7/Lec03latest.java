package content.chap7;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import content.utility.Util;

public class Lec03latest {
    public static void main(String[] args) {

        Flux.create(fluxSink -> {
                    for (int i = 0; i < 500; i++) {
                        fluxSink.next(i);
                        System.out.println("Pushed : " + i);
                    }
                }).onBackpressureLatest()
                 .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    Util.sleepMillis(10);
                }).subscribe(Util.subscriber());
        Util.sleepSeconds(60);
    }
}
