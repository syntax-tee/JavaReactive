package content.chap4;

import reactor.core.publisher.Flux;
import content.utility.Util;

public class Lec09SwitchIfEmpty {

    public static void main(String[] args) {
        getOrderNumbers().filter(i -> i>10).switchIfEmpty(fallback()).subscribe(Util.subscriber());
    }

    private static Flux<Integer> getOrderNumbers(){
        return  Flux.range(1,8);
    }

    private static Flux<Integer> fallback(){
        return  Flux.range(20,5);
    }
}
