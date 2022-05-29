package chap4;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import utility.Util;

public class Lec06OnError {

    public static void main(String[] args) {

        Flux.range(1, 100)
//                .log()
                .map(i -> 10 / (3 - i))
//                .onErrorReturn(-1)
//                .onErrorResume(e -> fallback())
                .onErrorContinue((err,obj)->{
                    System.out.println("onerror continue"+err);
                    System.out.println("onerror continue"+obj);
                })
                .subscribe(Util.subscriber());
    }

    private static Mono<Integer> fallback() {
        return Mono.fromSupplier(() -> Util.faker().random().nextInt(100, 200));
    }
}
