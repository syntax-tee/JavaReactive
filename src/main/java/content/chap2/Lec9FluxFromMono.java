package content.chap2;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import content.utility.Util;

public class Lec9FluxFromMono {

    public static void main(String[] args) {

        //Mono to Flux
        Mono<String> mono = Mono.just("a");
        Flux<String> flux = Flux.from(mono);
        flux.subscribe(Util.onNext());

        // FLux to Mono
        Flux.range(1,10).filter(i-> i>3).next().subscribe(Util.onNext(),Util.onError(),Util.onComplete());

    }

    private static void doSomething(Flux<String> flux) {

    }
}
