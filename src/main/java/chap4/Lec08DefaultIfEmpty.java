package chap4;

import reactor.core.publisher.Flux;
import utility.Util;

import java.time.Duration;

public class Lec08DefaultIfEmpty {

    public static void main(String[] args) {
        getOrderNumbers().filter(i-> i>10).defaultIfEmpty(-100).subscribe(Util.subscriber());
    }

    private static Flux<Integer> getOrderNumbers(){
        return  Flux.range(1,14);
    }
}
