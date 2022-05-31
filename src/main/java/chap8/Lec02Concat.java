package chap8;

import reactor.core.publisher.Flux;
import utility.Util;

public class Lec02Concat {

    public static void main(String[] args) {
        Flux<String> flux1 = Flux.just("a","b","c");
        Flux<String> flux2 = Flux.just("d","e","f");

        Flux<String> concatFlux = flux1.concatWith(flux2);
        Flux<String> concatFlux2 = Flux.concat(flux1,flux2);
        concatFlux.subscribe(System.out::println);

        System.out.println("FLUXXXXXXX2");
        concatFlux2.subscribe(System.out::println);
        Flux<String> fluxa = Flux.just("1","2","3");
        Flux<String> fluxc = Flux.error(new RuntimeException("error"));
        Flux<String> fluxb = Flux.just("4","5","6");

        Flux<String> fluxalphabet = Flux.concatDelayError(fluxa,fluxb,fluxc);
        fluxalphabet.subscribe(Util.subscriber());
    }
}
