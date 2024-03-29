package content.chap3;

import reactor.core.publisher.Flux;
import content.utility.Util;

public class Lec07FluxGeneratorCounter {

    public static void main(String[] args) {
        Flux.generate(() -> 1, (counter, sink) -> {
                    String country = Util.faker().country().name();
                    sink.next(country);

                    if (counter >= 10 || country.toLowerCase().equals("canada"))
                        sink.complete();
                    return counter + 1;

                }
        ).take(4).subscribe(Util.subscriber());
    }
}
