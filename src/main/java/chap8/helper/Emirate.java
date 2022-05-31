package chap8.helper;

import reactor.core.publisher.Flux;
import utility.Util;

import java.time.Duration;

public class Emirate {

    public static Flux<String> getFlights() {
        return Flux.range(1, Util.faker().random().nextInt(1, 10))
                .delayElements(Duration.ofSeconds(1))
                .map(i -> "Emirate " + Util.faker().random().nextInt(100, 999))
                .filter(i -> Util.faker().random().nextBoolean());
    }
}
