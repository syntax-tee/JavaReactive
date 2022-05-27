package chap1;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import utility.Util;

public class Lec06SupplierRefactoring {

    public static void main(String[] args) {
        //  getName().subscribeOn(Schedulers.boundedElastic()).subscribe(Util.onNext());
        String name = getName().subscribeOn(Schedulers.boundedElastic()).block();
        System.out.println(name);
    }

    private static Mono<String> getName() {
        System.out.println("Entered getName Method");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name..");
            Util.sleepSeconds(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }
}
