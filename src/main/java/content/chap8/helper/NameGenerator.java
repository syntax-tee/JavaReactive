package content.chap8.helper;

import reactor.core.publisher.Flux;
import content.utility.Util;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {


    private List<String> list = new ArrayList<>();

    public Flux<String> generateNames() {
        return Flux.generate(stringSynchronousSink -> {
            System.out.println("generated fresh");
            Util.sleepSeconds(1);
            String name = Util.faker().name().firstName();
            list.add(name);
            stringSynchronousSink.next(name);
        }).cast(String.class)
          .startWith(getFromCache());

    }

    private Flux<String> getFromCache() {
        System.out.println("from cache");
        return Flux.fromIterable(list);
    }
}
