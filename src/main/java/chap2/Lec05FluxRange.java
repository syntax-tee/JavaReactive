package chap2;

import reactor.core.publisher.Flux;
import utility.Util;

public class Lec05FluxRange {

    public static void main(String[] args) {
        Flux.range(0,10).log().map(i -> i+1).subscribe(Util.onNext());

        Flux.range(0,10).map(i -> Util.faker().name().fullName()).subscribe(Util.onNext());

    }
}
