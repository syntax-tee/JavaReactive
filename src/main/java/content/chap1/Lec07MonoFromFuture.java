package content.chap1;

import reactor.core.publisher.Mono;
import content.utility.Util;

import java.util.concurrent.CompletableFuture;

public class Lec07MonoFromFuture {
    public static void main(String[] args) {
        Mono.fromFuture(getName()).subscribe(Util.onNext());
    }
    private static CompletableFuture<String> getName(){
        return CompletableFuture.supplyAsync(() -> Util.faker().name().fullName());
    }


}
