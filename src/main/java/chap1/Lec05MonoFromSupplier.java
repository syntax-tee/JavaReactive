package chap1;

import reactor.core.publisher.Mono;
import utility.Util;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec05MonoFromSupplier {

    public static void main(String[] args) {
        //use just only when you have the data only
//        Mono<String> mono = Mono.just(getName());

        Supplier<String> stringSupplier = () -> getName();
        Mono<String> mono = Mono.fromSupplier(stringSupplier);
        mono.subscribe(
                Util.onNext()
        );

        Callable<String> stringCallable = () -> getName();
        Mono<String> monoCallable = Mono.fromCallable(stringCallable);
        monoCallable.subscribe(
                Util.onNext()
        );

    }

    private static String getName() {
        System.out.println("Generating name..");
        return Util.faker().name().fullName();
    }
}

