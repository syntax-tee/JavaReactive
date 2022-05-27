package chap3;

import reactor.core.publisher.Flux;
import utility.Util;

public class Lect05FluxGenerate {

    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            String country = Util.faker().country().name();
            System.out.println("emitting.."+country);
            synchronousSink.next(Util.faker().country().name());
        }).take(2).subscribe(Util.subscriber());
    }
}
