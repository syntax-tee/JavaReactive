package content.chap2;

import reactor.core.publisher.Flux;
import content.utility.Util;

public class Lec01FluxIntro {

    public static void main(String[] args) {

        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5, 6, 7);
        flux.subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        System.out.println("");

        Flux<Integer> fluxEmpty = Flux.empty();
        System.out.println("Flux empty");
        fluxEmpty.subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        System.out.println("");

        Flux<Object> fluxObject = Flux.just(1,2,3,"a",Util.faker().name().fullName(),"b");
        System.out.println("Flux Object");
        fluxObject.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }


}
