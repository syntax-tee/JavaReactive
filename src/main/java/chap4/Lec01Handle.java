package chap4;

import reactor.core.publisher.Flux;
import utility.Util;

public class Lec01Handle {
    public static void main(String[] args) {
        //handle  = filter + map
        Flux.range(1, 20).handle(((integer, synchronousSink) -> {
            if (integer == 7)
                synchronousSink.complete();
            else
                synchronousSink.next(integer);
        })).subscribe(Util.subscriber());


        Flux.create(synchronousSink -> synchronousSink.next(Util.faker().country().name())).map(Object::toString).handle((s, synchronousSink) -> {
            synchronousSink.next(s);
            if (s.toLowerCase().equals( "nigeria")) {
                synchronousSink.complete();
            }
        }).subscribe(Util.subscriber());

    }
}
