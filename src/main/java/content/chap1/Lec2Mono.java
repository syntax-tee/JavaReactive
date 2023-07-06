package content.chap1;

import reactor.core.publisher.Mono;

public class Lec2Mono {
    public static void main(String[] args) {
        //publisher
        Mono<Integer> mono = Mono.just(1);
        System.out.println(mono);
        //subscriber
        mono.subscribe(i -> System.out.println(i));
    }
}
