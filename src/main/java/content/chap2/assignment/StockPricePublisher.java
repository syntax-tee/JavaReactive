package content.chap2.assignment;

import reactor.core.publisher.Flux;
import content.utility.Util;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class StockPricePublisher {

    public static Flux<Integer> getPrice(){
        AtomicInteger atomicInteger = new AtomicInteger(100);
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> atomicInteger.getAndAccumulate(
                        Util.faker().random().nextInt(-5, 5),
                        Integer::sum
                ));
    }


}