package content.chap2;

import reactor.core.publisher.Flux;
import content.utility.Util;

import java.time.Duration;

public class Lec08Interval {

    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1)).subscribe(Util.onNext());
        Util.sleepSeconds(5);
    }
}
