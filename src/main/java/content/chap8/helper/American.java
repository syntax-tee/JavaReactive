package content.chap8.helper;

import reactor.core.publisher.Flux;
import content.utility.Util;

import java.time.Duration;

public class American {

    public static Flux<String> getFlights() {
        return Flux.range(1, Util.faker().random().nextInt(10, 20))
                .delayElements(Duration.ofSeconds(1))
                .map(i -> "AA " + Util.faker().random().nextInt(100, 999))
                .filter(i -> Util.faker().random().nextBoolean());
    }
}
