package content.chap8;

import content.chap8.helper.American;
import content.chap8.helper.Emirate;
import content.chap8.helper.Qatar;
import reactor.core.publisher.Flux;
import content.utility.Util;

public class Lec03Merge {

    public static void main(String[] args) {

        Flux<String> merge = Flux.merge(Qatar.getFlights(), Emirate.getFlights(), American.getFlights());
        merge.subscribe(Util.subscriber());
        Util.sleepSeconds(10);

    }
}
