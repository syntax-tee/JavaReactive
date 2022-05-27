package chap3;

import reactor.core.publisher.Flux;
import utility.Util;


public class Lec06FluxGenerateUtil {

    public static void main(String[] args) {

        Flux.generate(synchronousSink -> {
            String country = Util.faker().country().name();
            System.out.println("emitting " + country);
            synchronousSink.next(country);
            if (country.toLowerCase().equals("canada"))
                synchronousSink.complete();

        }).subscribe(Util.subscriber());

        Flux.generate(synchronousSink -> {
            String country = Util.faker().country().name();
            System.out.println("emitting " + country);
            synchronousSink.next(country);
            if (country.toLowerCase().equals("canada"))
                synchronousSink.complete();

        }).subscribe(Util.subscriber());
    }
}
