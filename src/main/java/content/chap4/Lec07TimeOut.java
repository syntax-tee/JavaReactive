package content.chap4;

import reactor.core.publisher.Flux;
import content.utility.Util;

import java.time.Duration;

public class Lec07TimeOut {

    public static void main(String[] args) {

       getOrderNumbers().timeout(Duration.ofSeconds(2),fallback()).subscribe(Util.subscriber());

       Util.sleepSeconds(60);
    }

    private static Flux<Integer> getOrderNumbers(){
        return  Flux.range(1,10).delayElements(Duration.ofSeconds(5));
    }

    private static Flux<Integer> fallback(){
     return  Flux.range(100,10).delayElements(Duration.ofSeconds(1));
    }
}
