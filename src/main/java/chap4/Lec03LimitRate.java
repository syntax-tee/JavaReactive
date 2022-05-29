package chap4;

import reactor.core.publisher.Flux;
import utility.Util;

public class Lec03LimitRate {

    public static void main(String[] args) {
        Flux.range(1,1000)
                .log()
                .limitRate(10)
                .subscribe(Util.subscriber());
    }
}
