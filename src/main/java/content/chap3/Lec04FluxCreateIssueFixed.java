package content.chap3;

import reactor.core.publisher.Flux;
import content.utility.Util;

public class Lec04FluxCreateIssueFixed {
    public static void main(String[] args) {
//        Flux.create(fluxSink ->{
//            String country;
//            do{
//                country =  Util.faker().country().name();
//                System.out.println("emitting: "+country);
//                fluxSink.next(country);
//            }while (!country.toLowerCase().equals("canada") && !fluxSink.isCancelled());
//            fluxSink.complete();
//        }).take(3).subscribe(Util.subscriber());


        Flux.create(fluxSink ->{
            String country;
            int couter = 0;
            do{
                country =  Util.faker().country().name();
                System.out.println("emitting: " +country);
                fluxSink.next(country);
                couter++;
            }while (!country.toLowerCase().equals("canada") && !fluxSink.isCancelled() && couter <10);
            fluxSink.complete();
        }).subscribe(Util.subscriber());
    }
}
